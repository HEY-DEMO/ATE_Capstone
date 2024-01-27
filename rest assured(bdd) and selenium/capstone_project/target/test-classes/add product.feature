@tag
Feature: Add product
  I want to add product by details

  @Restfull @post
  Scenario: add product by details
    Given tester goes to the website to add
    When adds product by providing details
    Then validate post request outcomes status code is 200