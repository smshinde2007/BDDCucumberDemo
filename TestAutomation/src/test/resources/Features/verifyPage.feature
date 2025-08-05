@Smoke
Feature: Page verification
  Scenario: Verify page details
    Given open a page URL
    When verify page title
    Then enter text into serach box
    And close the browser

