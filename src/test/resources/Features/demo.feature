@Smoke
Feature: Brac Create Stakeholder functionality
  This functionality is based on testing the valid, invalid and other criteria

  Scenario: User will be able to login successfully with valid credentials
    Given User is in Brac website
    When User is in Brac login page, validate this page
    When User is in Brac Sign In page, enter username and password for login
    Then Validate Brac Home page
    Then Click on admin from the homepage and switch the tab
    Then click on stakeholder mangement from left menu from admin page
    Then Select stakeholder information
    Then create a stakeholder
    Then validate that the stakeholder is successfully created
