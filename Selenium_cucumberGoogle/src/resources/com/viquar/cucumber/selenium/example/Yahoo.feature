Feature: Search on Google
  As an user
  I want to search on Yahoo 
  So that I can see results

  Scenario: results are shown
    Given the page is open "http://www.yahoo.com"
    When I click on a link
    Then I am no longer on the page
