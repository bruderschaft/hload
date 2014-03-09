package ru.mail.go;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by max on 05.03.14.
 */
public class SimpleTests {
    private WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("http://go.mail.ru/");
        webDriver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSugges(){
        Assert.assertTrue(new MainPage(webDriver)
        .suggest("vk")
        .contains("vk"));
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
