package com.gradeUp.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    public AndroidElement continueButton;

    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/name']")
    public AndroidElement enterName;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/email1']")
    public AndroidElement enterEmail;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/loginButton']")
    public AndroidElement registerButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='co.gradeup.android:id/close']")
    public AndroidElement closeEmainVerifyPop_Up;

    //
}

