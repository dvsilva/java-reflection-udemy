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

package com.udemy.data;

public class UserInterfaceConfig {
	
	private String titleColor;
	private String footerText;
	private short titleFontSize;
	private short footerFontSize;

	public String getTitleColor() {
		return titleColor;
	}

	public String getFooterText() {
		return footerText;
	}

	public short getTitleFontSize() {
		return titleFontSize;
	}

	public short getFooterFontSize() {
		return footerFontSize;
	}

	@Override
	public String toString() {
		return "UserInterfaceConfig{" + "titleColor='" + titleColor + '\'' + ", footerText='" + footerText + '\''
				+ ", titleFontSize=" + titleFontSize + ", footerFontSize=" + footerFontSize + '}';
	}
	
}
