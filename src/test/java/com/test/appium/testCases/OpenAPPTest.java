package com.test.appium.testCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenAPPTest {
@Test
    void test() throws InterruptedException, MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

    capabilities.setCapability("deviceName", "Redmi");
    capabilities.setCapability("platformVersion", "7.0");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appPackage", "co.gradeup.android");
    capabilities.setCapability("appActivity", "co.gradeup.android.view.activity.LauncherActivity");
    capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"), capabilities);
    Thread.sleep(5000);
    driver.quit();

}


//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
//
//        capabilities.setCapability("deviceName", "Redmi");
//        capabilities.setCapability("platformVersion", "7.0");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("appPackage", "co.gradeup.android");
//        capabilities.setCapability("appActivity", "co.gradeup.android.view.activity.LauncherActivity");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
//        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http:127.0.0.1:4723/wd/hub"), capabilities);
//        Thread.sleep(5000);
//        driver.quit();
//
//
//    }
}
