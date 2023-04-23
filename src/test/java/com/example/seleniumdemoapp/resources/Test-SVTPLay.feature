Feature: Test SVTPlay

  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then The title should be "SVT Play"

  Scenario: SVT Play should show correct menu links
    Given SVT Play is available
    When User visits SVT Play
    Then The menu links should be "https://www.svtplay.se/", "https://www.svtplay.se/program" and "https://www.svtplay.se/kanaler"

  Scenario: SVT Play logo should be visible
      Given SVT Play is available
      When User visits SVT Play
      Then The logo should be visible

  Scenario: SVT Play should show correct name for main menu links
      Given SVT Play is available
      When User visits SVT Play
      Then The name for the main menu links should be "START", "PROGRAM" and "KANALER"

  Scenario: The link in the footer should be visible and the link text should be correct
      Given SVT Play is available
      When User visits SVT Play
      And Cookies are accepted
      Then The correct link in the footer should be visible
      And the link text should be correct

  Scenario: Follow the bottom link and check the headline
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    Then The link in footer should be clicked
    And The headline in the following page should be correct

  Scenario: SVT Play should display the correct number of categories in the Program page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    Then The link to Program should be clicked
    And There should be 17 categories in the Program page

  Scenario: The correct number of stripes should be available in the start page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    Then There should be 34 stripes available on the start page

  Scenario: SVT Play should show the correct title when entering Kanaler page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    And User click on KANALER
    Then The title on the page should be "På SVT just nu"

  Scenario: SVT Play should display the link for "dataanvändning" in the settings page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    And User enters the settings page
    Then The link for dataanvändning should be visible

  Scenario:SVT Play should list the correct amount of shortcuts in the contact page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    And User enters the contact page
    Then There should be 5 shortcuts listed

  Scenario: SVT Play should display their logo in the footer of the page
    Given SVT Play is available
    When User visits SVT Play
    And Cookies are accepted
    Then SVT Plays logo should be visible in the footer of the page









