@search
Feature:    Search Function
  AS A      customer
  I WANT TO Search for a product
  SO THAT   I can view respective product

  @SmokeTest
  Scenario: Search for a product
    Given   I am on a Homepage
    When    I search for a Product "nike"
    Then    Then i should be able to see respective products

  @Regression
  Scenario Outline: : Search product with valid credential
    Given   I am on a Homepage
    When    I search for a Product "<products>"
    Then    Then i should get respective products
    Examples:
      | products |
      | Adidas   |
      | toys     |
      | Watch    |


