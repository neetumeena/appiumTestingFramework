package com.test.appium.gradeUPTestCases;

import com.gradeUp.base.BaseClass;
import com.gradeUp.pageObjects.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GradeUPAssignment {
    @Test
    void gradeUPTest() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = BaseClass.upDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ExamPage examPage = new ExamPage(driver);
        SelectExamPage selectExamPage = new SelectExamPage(driver);
        MyExamPreferencesPage examPreferencesPage = new MyExamPreferencesPage(driver);
        Pop_UPsPage pop_uPsPage = new Pop_UPsPage(driver);
        ExamCategoryPage examCategoryPage = new ExamCategoryPage(driver);
        CoursePage coursePage = new CoursePage(driver);
        homePage.sscExamElemet.click();
        SelectLangPage langPage = new SelectLangPage(driver);
        langPage.doneButton.click();
        loginPage.continueButton.click();
        loginPage.enterName.sendKeys("Neetu Meena");
        loginPage.registerButton.click();
        loginPage.closeEmainVerifyPop_Up.click();
        examPage.selectedSSCCGLExam.click();
        selectExamPage.plusIcon.click();
        examPreferencesPage.searchExam.sendKeys("CTET");
        driver.hideKeyboard();
        examPreferencesPage.clickOnExam(examPreferencesPage.examList, "CTET");
        pop_uPsPage.confirmPopOnChangingExam.click();
        examCategoryPage.backbutton.click();
        examPreferencesPage.backbutton.click();
        if (!examPage.verifySelectedExam(examPage.listOfItems, "CTET & Teaching Jobs")) {
            System.out.println("Fail");
            Assert.fail("Exam not selected");
        }
        examPage.classRoom.click();
        examPage.clickOnViewCourse(driver);
        coursePage.startFreeTrial.click();
        System.out.println("course name = " + coursePage.courseName.getAttribute("text"));
        System.out.println("course price = " + coursePage.price.getAttribute("text"));
        driver.quit();
    }
}
