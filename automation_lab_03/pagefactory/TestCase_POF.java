package com.automation.automation_lab_03.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestCase_POF {
    public static class LogIn_TestCase {

        private static WebDriver driver = null;

        public static void main(String[] args) {
            // Create a new instance of the Firefox driver
            driver = new FirefoxDriver();
            //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Launch the Online Store Website
            driver.get("http://www.store.demoqa.com");
            // Find the element that's ID attribute is 'account'(My Account)
            driver.findElement(By.linkText("My Account")).click();
            // Find the element that's ID attribute is 'log' (Username)
            // Enter Username on the element found by above desc.
            driver.findElement(By.id("log")).sendKeys("testuser_1");
            // Find the element that's ID attribute is 'pwd' (Password)
            // Enter Password on the element found by the above desc.
            driver.findElement(By.id("pwd")).sendKeys("Test@123");
            // Now submit the form. WebDriver will find the form for us from the element
            driver.findElement(By.id("login")).click();
            // Print a Log In message to the screen
            System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
            // Find the element that's ID attribute is 'account_logout' (Log Out)
            driver.findElement(By.id("account_logout"));
            // Close the driver
            driver.quit();
        }
    }
}
