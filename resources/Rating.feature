@Review
Feature:    Filter search result based on review
  As AN     Customer
  I WANT TO filter a products by its review
  SO THAT   I can view results of my filtered choice

  @SmokeTest_review
  Scenario: Filter products products by its review
    Given   I am on a Homepage
    When    I search for a Product "nike"
    And     I apply review filter "4or more" on result page
    Then    I should see all products of my filtered "4.00" choice

  @Regression_review
  Scenario Outline: Filter products by review rating
    Given   I am on a Homepage
    When    I search for a Product "nike"
    And     I apply review filter "<reviewFilter>"on result page
    Then    I should see all products of my filtered "<filteredchoice>"
    Examples:
      | reviewFilter |  | filteredchoice |
      | 5only        |  |      5.00       |
      | 4or more     |  |      4.00       |
      | 3or more     |  |      3.00       |
      | 2or more     |  |      2.00       |
      | 1or more     |  |      1.00       |
