package com.udemy.ex3;

import com.udemy.ex3.Annotations.Viawable;
import com.udemy.ex3.Annotations.Viawable.DeviceType;

@Viawable(deviceType = DeviceType.DESKTOP, width = 1280, height = 720)
@Viawable(deviceType = DeviceType.MOBILE, width = 750, height = 1334)
@Viawable(deviceType = DeviceType.TABLET, width = 800, height = 1280)
public class SmallUiHomePage {

}