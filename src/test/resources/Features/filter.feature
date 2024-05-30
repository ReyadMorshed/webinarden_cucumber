@Smoke
Feature: Webinarden filter functionality
  This functionality is based on testing the valid, invalid and other criteria

  Scenario: User will be able to login successfully with valid credentials
    Given User is in WebinarDen website
    When User is in WebinarDen Landing page, validate this page
    Then click on sign up button 
    And click on Sign In
    And Validate WebinarDen Sign In page
    When User is in WebinarDen Sign In page, enter <username> and <password> for login
    | username | reyadmorshed@yopmail.com |
    | password | Reyad@123 |
    Then Validate WebinarDen Home page
    Then Click on webinarden menu from the top
    And Validate the webinarden page
    Then Click on webinar type dropdown and select featured