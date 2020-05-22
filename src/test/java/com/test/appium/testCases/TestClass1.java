package com.test.appium.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass1 {
    WebDriver driver;

    @BeforeClass
    void upDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();


    }

    @Test
    void testMethod1() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
        Thread.sleep(4000);
    }

    @AfterClass
    void closeDriver() {
        driver.close();
    }
}
