package com.automation.automation_lab_03.cucumber_framework_01.step_definition;

import com.automation.automation_lab_03.cucumber_framework_01.pageobject.ResultPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Every.everyItem;

public class Rating_Steps {

    //the logic is written in Result page Class, methods need to be called via object creation
    ResultPage resultPage = new ResultPage();

    @When("^I apply review filter \"([^\"]*)\" on result page$")
    public void i_apply_review_filter_on_result_page(String reviewFilter) {
        /**calling selectARating(String selectedRating)connecting both String selectedRating = String myFilter,
           there by linking with the value "4or more" from Rating.feature file line number 11:-
           And I apply review filter "4or more" on result page
         */
        resultPage.selectARating(reviewFilter);
    }

    @Then("^I should see all products of my filtered \"([^\"]*)\" choice$")
    public void i_should_see_all_products_of_my_filtered_choice(double filteredchoice) {
        // Calling ResultClass method public List<Double> collectedCustomerRating(), Since it is returning
        // an array list it need to be stored to use
        List<Double> actualReviewList = resultPage.collectedCustomerRating();
        //System.out.println(actualReviewList);
        //System.out.println(arg1);
        assertThat(actualReviewList,everyItem(greaterThanOrEqualTo(filteredchoice)));
    }
}