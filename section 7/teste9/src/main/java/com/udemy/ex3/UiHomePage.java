package com.udemy.ex3;

import com.udemy.ex3.Annotations.Viawable;
import com.udemy.ex3.Annotations.Viawable.DeviceType;

@Viawable(deviceType = DeviceType.DESKTOP, width = 1280, height = 720)
@Viawable(deviceType = DeviceType.DESKTOP, width = 1920, height = 1080)
@Viawable(deviceType = DeviceType.MOBILE, width = 1440, height = 2960)
@Viawable(deviceType = DeviceType.TABLET, width = 1536, height = 2048)
public class UiHomePage {

}
 
