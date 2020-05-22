package com.test.appium.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    static String PROPERTYFILEPATH = System.getProperty("user.dir") + "src/test/resources/properties/androidsettings.properties";

    public static Properties prop = new Properties();

    public static void main(String[] agrs) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileInputStream fileInputStream = new FileInputStream(PROPERTYFILEPATH);
        prop.load(fileInputStream);
        System.out.println(prop.getProperty("explicit.wait"));
    }
}
