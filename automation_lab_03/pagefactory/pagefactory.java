package com.automation.automation_lab_03.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class pagefactory {

    static WebDriver driver;
    static WebElement log;
    static WebElement pwd;
    static WebElement submit;

    private static org.openqa.selenium.support.PageFactory PageFactory;

    public static void main(String[] args) throws InterruptedException{
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com");

        PageFactory.initElements(driver, TestCase_POF.class);
        log.sendKeys("mmmm");
        pwd.sendKeys("nnnn");
        submit.click();
    }
}
