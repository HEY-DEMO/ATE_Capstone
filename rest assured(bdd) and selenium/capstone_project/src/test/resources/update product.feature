@tag
Feature: update product
  I want to update product by details

  @Restfull @put
  Scenario: update product by details
    Given tester goes to the website to update
    When updates product by providing details
    Then validate put request outcomes status code is 405