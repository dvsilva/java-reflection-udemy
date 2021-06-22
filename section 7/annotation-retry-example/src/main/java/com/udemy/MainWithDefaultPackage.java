package com.udemy;

/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.udemy.annotations.InitializerClass;
import com.udemy.annotations.InitializerMethod;
import com.udemy.annotations.RetryOperation;
import com.udemy.annotations.ScanPackages;

/**
 * Annotations - Application Initialization
 * https://www.udemy.com/course/java-reflection-master-class
 */

@ScanPackages({"app", "app.configs", "app.databases", "app.http"})
public class MainWithDefaultPackage {

    public static void main(String[] args) throws Throwable {
        initialize();
    }

    public static void initialize() throws Throwable {
    	ScanPackages scanPackages = Main.class.getAnnotation(ScanPackages.class);

        if (scanPackages == null || scanPackages.value().length == 0) {
            return;
        }

        List<Class<?>> classes = getAllClasses(scanPackages.value());

        for (Class<?> clazz : classes) {
            if (!clazz.isAnnotationPresent(InitializerClass.class)) {
                continue;
            }

            List<Method> methods = getAllInitializingMethods(clazz);

            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Method method : methods) {
            	callInitializingMethod(instance, method);
            }
        }
    }

    private static void callInitializingMethod(Object instance, Method method) throws Throwable {
        RetryOperation retryOperation = method.getAnnotation(RetryOperation.class);

        int numberOfRetries = retryOperation == null ? 0 : retryOperation.numberOfRetries();

        while (true) {
            try {
                method.invoke(instance);
                break;
            } 
            catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();

                if (numberOfRetries > 0 && Set.of(retryOperation.retryExceptions()).contains(targetException.getClass())) {
                    numberOfRetries--;

                    System.out.println("Retrying ...");
                    Thread.sleep(retryOperation.durationBetweenRetriesMs());
                } 
                else if (retryOperation != null) {
                    throw new Exception(retryOperation.failureMessage(), targetException);
                } 
                else {
                    throw targetException;
                }
            }
        }
    }
    
    private static List<Method> getAllInitializingMethods(Class<?> clazz) {
        List<Method> initializingMethods = new ArrayList<>();
        
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InitializerMethod.class)) {
                initializingMethods.add(method);
            }
        }
        
        return initializingMethods;
    }

    public static List<Class<?>> getAllClasses(String... packageNames) throws URISyntaxException, IOException, ClassNotFoundException {
        List<Class<?>> allClasses = new ArrayList<>();

        for (String packageName : packageNames) {
            Class<?> mainClass = MainWithDefaultPackage.class;
			String mainPackage = mainClass.getPackageName();
            
            String fullPackageName = mainPackage + "." + packageName;
            String packageRelativePath = packageName.replace('.', '/');
            
			URI packageUri = mainClass.getResource(packageRelativePath).toURI();
            
            if (packageUri.getScheme().equals("file")) {
                Path packageFullPath = Paths.get(packageUri);
                allClasses.addAll(getAllPackageClasses(packageFullPath, fullPackageName));
            } 
            else if (packageUri.getScheme().equals("jar")) {
                FileSystem fileSystem = FileSystems.newFileSystem(packageUri, Collections.emptyMap());
                String fullPackageRelativePath = fullPackageName.replace('.', '/');
                Path packageFullPathInJar = fileSystem.getPath(fullPackageRelativePath);
                
                allClasses.addAll(getAllPackageClasses(packageFullPathInJar, fullPackageName));

                fileSystem.close();
            }
        }
        
        return allClasses;
    }

    private static List<Class<?>> getAllPackageClasses(Path packagePath, String packageName) throws IOException, ClassNotFoundException {
		if (!Files.exists(packagePath)) {
			return Collections.emptyList();
		}

        List<Path> files = Files.list(packagePath)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        List<Class<?>> classes = new ArrayList<>();

        for (Path filePath : files) {
            String fileName = filePath.getFileName().toString();

            if (fileName.endsWith(".class")) {
                String classFullName = packageName.isBlank() ?
                        fileName.replaceFirst("\\.class$", "")
                        : packageName + "." + fileName.replaceFirst("\\.class$", "");
                
                Class<?> clazz = Class.forName(classFullName);
                classes.add(clazz);
            }
        }
        
        return classes;
    }
}
