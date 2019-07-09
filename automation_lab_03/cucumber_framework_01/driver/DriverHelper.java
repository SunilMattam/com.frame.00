package com.automation.automation_lab_03.cucumber_framework_01.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public static WebDriver driver;

    /** if you want to create a page factory we need to create a constructor method first*/
    public DriverHelper() {
        /**initialise the page factory in the constructor method and assign to driver level*/
        PageFactory.initElements(driver, this);
    }

    public void browserSetUp(String selectABrowser, String enterBasleURL) {

        switch ( selectABrowser ) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                /**WebDriverManager.chromedriver().version("2.26").setup();
                 method to port to older versions, Force to use version 2.26 of chromedriver*/
                break;

            case "Safari":
                driver = new SafariDriver();
                break;

            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            case "Opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;

            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        driver.get(enterBasleURL);
    }

    public void getUrl(String typeURL) {
        driver.get(typeURL);
    }

    public void maximizeBroser() {
        driver.manage().window().maximize();
    }

    public void applyImplicitlyWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void privacyFooter() {
        driver.findElement(By.cssSelector(".privacy-prompt-footer")).click();
    }

    public void quitTheBrowser() {
        driver.quit();
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


