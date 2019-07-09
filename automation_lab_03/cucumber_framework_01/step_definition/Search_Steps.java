package com.automation.automation_lab_03.cucumber_framework_01.step_definition;

import com.automation.automation_lab_03.cucumber_framework_01.driver.DriverHelper;
import com.automation.automation_lab_03.cucumber_framework_01.pageobject.HomePage;
import com.automation.automation_lab_03.cucumber_framework_01.pageobject.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Search_Steps extends DriverHelper {

    HomePage homePage = new HomePage();
    ResultPage resultPage = new ResultPage();

    @Given("^I am on a Homepage$")
    public void i_am_on_a_Homepage() {
        String actualHomepageUrl = homePage.getHomePageUrl();
        assertThat(actualHomepageUrl, endsWith("co.uk/"));
    }

    @When("^I search for a Product \"([^\"]*)\"$")
    public void i_search_for_a_Product(String searchItem) {
        homePage.doSearch(searchItem);
    }

    @Then("^Then i should be able to see respective products$")
    public void then_i_should_be_able_to_see_respective_products() {
       String actualResultPage = resultPage.searchHeader();
       assertThat(actualResultPage,is(equalToIgnoringCase(homePage.mySearchItem)));
    }
}
