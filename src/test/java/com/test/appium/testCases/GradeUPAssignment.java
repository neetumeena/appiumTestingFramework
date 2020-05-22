package com.test.appium.testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Neetu Meena
public class GradeUPAssignment {
    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    void upDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Redmi");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "co.gradeup.android");
        capabilities.setCapability("appActivity", "co.gradeup.android.view.activity.LauncherActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http:127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void gradeUPTest() throws InterruptedException {
        boolean found = false;
        // a) Launch Gradeup main app and select “SSC & Railway” as the exam from “which exam are you preparing for?” screen 
        List<AndroidElement> elements = driver.findElements(By.className("android.widget.TextView"));
        for (AndroidElement element : elements) {
            if (element.getAttribute("text").contains("SSC")) {
                element.click();
                Thread.sleep(4000);
                break;
            }
        }
        String xpathOfselectLangPopUP = "//android.widget.TextView[@text='DONE']";
        if (isElementPresent(xpathOfselectLangPopUP))
            driver.findElement(By.xpath(xpathOfselectLangPopUP)).click();

        //b) Register using any one of Phone number, Email address, Gmail, Facebook options available on
        // first page (OTP auto fill, Truecaller can be taken help of if registering via Phone number
        // (applicable for versions above 9.7)) 
        driver.findElement(By.xpath("//*[@text='Register']")).click();
        driver.findElement(By.xpath("//*[@text='nitumeena94@gmail.com']")).click();
        //c) Change exam to “CTET & Teaching jobs” from Select exam top dropdown on Home page
        // ( Take help of “Add more” options on Select Exam tab).
        driver.findElement(By.xpath("//*[@text='SSC & Railway']")).click();
        driver.findElement(By.xpath("//*[@resource-id='co.gradeup.android:id/plusIcon']")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("CTET");
        driver.hideKeyboard();
        List<AndroidElement> examList = driver.findElements(By.xpath("//*[@resource-id='co.gradeup.android:id/examName']"));
        for (AndroidElement examName : examList) {
            System.out.println(examName.getAttribute("text"));
            if (examName.getAttribute("text").contains("CTET")) {
                examName.click();
                break;
            }
        }

        //d)  Click “Turn On” button from “Are you preparing for CTET & Teaching jobs” message box and double click top left
        // back button on screen to return to Home tab.
        String xpathOfConfirmPopOnChangingExam = "//android.widget.TextView[@text='TURN ON']";
        if (isElementPresent(xpathOfConfirmPopOnChangingExam))
            driver.findElement(By.xpath(xpathOfConfirmPopOnChangingExam)).click();
        driver.findElement(By.xpath("//*[@resource-id='co.gradeup.android:id/backImgView']")).click();
        driver.findElement(By.xpath("//*[@resource-id='co.gradeup.android:id/superActionBar']//android.widget.ImageView")).click();

        //e) Verify Top heading on page to be changed to “CTET & Teaching jobs”
        List<AndroidElement> ListOfitems = driver.findElements(By.className("android.widget.TextView"));
        for (AndroidElement element : ListOfitems) {
            if (element.getAttribute("text").contains("CTET & Teaching Jobs")) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Fail");
            Assert.fail("Exam not selected");
        }
        //f) Click on “Classroom” page from bottom page selection icons on the page. 
        driver.findElement(By.xpath("//*[@text='Classroom']")).click();

        //g) Click on “VIEW COURSE” for the second course on page(applicable only if page has more than one courses listed)
        scrollAndClick("VIEW COURSE");

        //h) Click on “Start free trial” from the upcoming page.
        driver.findElement(By.xpath("//*[@text='START FREE TRIAL']")).click();

        //i) Print the name of course and price on console and close the application.
        System.out.println("course name = " + driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text"));
        System.out.println(driver.findElement(By.xpath("//*[@resource-id='co.gradeup.android:id/batchPrice']")).getAttribute("text"));

        driver.quit();
    }

    private void scrollAndClick(String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }


    private boolean isElementPresent(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
