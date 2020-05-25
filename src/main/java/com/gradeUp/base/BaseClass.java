package com.gradeUp.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static Properties prop = new Properties();
    static String PROPERTYFILEPATH = System.getProperty("user.dir") + "/src/test/resources/properties/androidsettings.properties";
    private static int EXPLICIT_WAIT_TIME;
    private static int IMPLICIT_WAIT_TIME;
    private static int DEFAULT_WAIT_TIME;
    private static String APPLICATION_NAME;
    private static String BASE_PKG;
    private static String APP_ACTIVITY;
    private static String AUTOMATION_INSTRUMENTATION;
    private static String PLATFORM_NAME;
    private static String NEW_COMMAND_TIMEOUT;
    private static String PLATFORM_VERSION;
    private static String DEVICE_READY_TIMEOUT;
    private static String DEVICE_NAME;
    private static String serverUrl = "http:127.0.0.1:4723/wd/hub";

    private static void loadConfigProp(String propertyFileName) throws IOException {
        FileInputStream fis = new FileInputStream(propertyFileName);
        prop.load(fis);

        EXPLICIT_WAIT_TIME = Integer
                .parseInt(prop.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer
                .parseInt(prop.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        APPLICATION_NAME = prop.getProperty("application.path");
        BASE_PKG = prop.getProperty("package.name");
        APP_ACTIVITY = prop.getProperty("application.activity");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instumentation");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT = prop.getProperty("new.command.timeout");
        DEVICE_READY_TIMEOUT = prop.getProperty("device.ready.timeout");

    }

    public static AndroidDriver<AndroidElement> upDriver() throws IOException {
        loadConfigProp(PROPERTYFILEPATH);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("appPackage", BASE_PKG);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(serverUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        return driver;
    }

}
