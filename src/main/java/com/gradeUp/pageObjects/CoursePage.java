package com.gradeUp.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {

    public CoursePage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='START FREE TRIAL']")
    public AndroidElement startFreeTrial;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/superActionBar']/android.widget.TextView")
    public AndroidElement courseName;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/batchPrice']")
    public AndroidElement price;

}