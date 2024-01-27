@tag
Feature: users list
  I want to get all users list

  @Restfull @get
  Scenario: get users list 
    Given tester goes to the website to get the list of users
    When gets users list 
    Then validate Get request outcomes of users status code is 200