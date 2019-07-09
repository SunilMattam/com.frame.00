package com.automation.automation_lab_03.cucumber_framework_01.pageobject;

import com.automation.automation_lab_03.cucumber_framework_01.driver.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends DriverHelper {

    @FindBy(css = ".search-title__term")
    private WebElement searchResult;
    public String searchHeader() {
        return searchResult.getText();
    }

    /**
     * public String searchHeader() {
     * //Other way of writing the code
     * String actualSearchedProduct = driver.findElement(By.cssSelector(".search-title__term")).getText();
     * return actualSearchedProduct;
     * return driver.findElement(By.cssSelector(".search-title__term")).getText();
     * }
     */

    public String getSearchPageUrl() {
        return driver.getCurrentUrl();
    }

    //-----------------------------Click a Specific Customer Rating -------------------------------------//

    @FindBy(css = ".ac-facet__filters--rating .ac-facet__label--rating")
    private List<WebElement> customerRatings;
    public void selectARating(String selectedRating) {
        for (WebElement customerRating : customerRatings) {
            if (customerRating.getText().equalsIgnoreCase(selectedRating)) {
                sleep(3000);
                customerRating.click();
                break;
            }
        }
    }
    /**public void selectARating(String customerRating) {
        List<WebElement> ratingWebElements = driver.findElements
                (By.cssSelector(".ac-facet__filters--rating .ac-facet__label--rating"));
        for (WebElement ratingWebElement : ratingWebElements) {
            if (ratingWebElement.getText().equalsIgnoreCase(customerRating)) {
                sleep(3000);
                ratingWebElement.click();
                break;
            }
        }
    }**/

    //-----------------------------Collect Customer Rating from Dom for assertion-------------------------------------//

    @FindBy(css = ".ac-star-rating")private List<WebElement> starRatingWebElements;
    /**@CacheLookup :once we navigate away from the page and returning (which would mean that a different
    element with the same name would be present) It would be handy if we could "cache" the element once
    we'd looked it up:*/

    public List<Double> collectedCustomerRating() {
        List<Double> collectedRatingList = new ArrayList<>(); // Empty array list to store collected rating value from dom
        //looping through each web elements to collect all rating value
        for (WebElement starRatingWebElement : starRatingWebElements) {
            //getAttribute actually returns the value in String, casting it to double and adding to the array list
            collectedRatingList.add(Double.parseDouble(starRatingWebElement.getAttribute("data-star-rating")));
        }
        return collectedRatingList;// returning all the collected ratings for assertion
    }
    /**public List<Double> collectedCustomerRating (){
        List<Double> collectedRatingList = new ArrayList<>();
        List<WebElement> starRatingWebElements = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement starRatingWebElement:starRatingWebElements) {
           //String ratingValueInString = starRatingWebElement.getAttribute("data-star-rating");
           //double ratingValue  = Double.parseDouble(ratingValueInString);
           //collectedRatingList.add(ratingValue);//
           sleep(3000);
           collectedRatingList.add(Double.parseDouble(starRatingWebElement.getAttribute("data-star-rating")));
        }
        sleep(3000);
        return collectedRatingList;
    }*/


}
