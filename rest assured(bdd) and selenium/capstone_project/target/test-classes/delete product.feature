@tag
Feature: Delete product
  I want to delete product  by Id

  @Restfull @delete
  Scenario: Delete product by Id
    Given tester goes to the website
    When delete product by id 101
    Then validate delete request outcomes status code is 200
