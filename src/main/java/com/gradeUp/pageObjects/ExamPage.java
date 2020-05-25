package com.gradeUp.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamPage {

    public ExamPage(AndroidDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='SSC & Railway']")
    public AndroidElement selectedSSCCGLExam;

    @AndroidFindBy(className = "android.widget.TextView")
    public List<AndroidElement> listOfItems;

    @AndroidFindBy(xpath = "//*[@text='Classroom']")
    public AndroidElement classRoom;

    public void clickOnSelectedExam(List<AndroidElement> listOfItems, String examName) {
        for (AndroidElement element : listOfItems) {
            if (element.getAttribute("text").contains(examName)) {
                element.click();
            }
        }
    }

    public boolean verifySelectedExam(List<AndroidElement> listOfItems, String examName) {
        for (AndroidElement element : listOfItems) {
            if (element.getAttribute("text").contains(examName)) {
                return true;

            }
        }
        return false;
    }

    public void clickOnViewCourse(AndroidDriver driver) {
        scrollAndClick("VIEW COURSE", driver);
    }

    private void scrollAndClick(String visibleText, AndroidDriver driver) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }

}

