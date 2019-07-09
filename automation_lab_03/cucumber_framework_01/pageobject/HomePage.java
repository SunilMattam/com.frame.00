package com.automation.automation_lab_03.cucumber_framework_01.pageobject;

import com.automation.automation_lab_03.cucumber_framework_01.driver.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverHelper {
    // assertion string

    public String getHomePageUrl() {
        /** normal way of returning a value
            String currentUrl = driver.getCurrentUrl(); //return currentUrl;
            reduced line and memory allocation */
        return driver.getCurrentUrl();
    }

    public static String mySearchItem;
    @FindBy(id = "searchTerm")
    private WebElement searchBox;
    @FindBy(css = "button[type='submit']")
    private WebElement magnifierGlass;

    public void doSearch(String searchItem) {
        mySearchItem = searchItem;
        searchBox.sendKeys(searchItem);
        magnifierGlass.click();
    }

    /**
     normal way of writing  test logic
     public void doSearch(String searchItem) {
        mySearchItem = searchItem;
        driver.findElement(By.id("searchTerm")).sendKeys(searchItem + Keys.ENTER);
     }
     */
}
