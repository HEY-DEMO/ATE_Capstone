@tag
Feature: products list
  I want to get all products list

  @Restfull @get
  Scenario: get products list 
    Given tester goes to the website to get the list of products
    When gets products list 
    Then validate Get request outcomes status code is 200