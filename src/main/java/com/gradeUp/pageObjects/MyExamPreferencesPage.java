package com.gradeUp.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyExamPreferencesPage {

    public MyExamPreferencesPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //        driver.findElement(By.className("android.widget.EditText")).sendKeys("CTET");
    @AndroidFindBy(className = "android.widget.EditText")
    public AndroidElement searchExam;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/superActionBar']//android.widget.ImageView")
    public AndroidElement backbutton;
    @AndroidFindBy(xpath = "//*[@resource-id='co.gradeup.android:id/examName']")
    public List<AndroidElement> examList;

    public void clickOnExam(List<AndroidElement> examList, String examName) {
        for (AndroidElement examName_ : examList) {
            System.out.println(examName_.getAttribute("text"));
            if (examName_.getAttribute("text").contains(examName)) {
                examName_.click();
                break;
            }
        }
    }
}



