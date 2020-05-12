package java.testpackage;

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
    void testMethod1() {
        driver.get("https://www.google.com/");
    }

    @AfterClass
    void closeDriver() {
        driver.close();
    }
}
