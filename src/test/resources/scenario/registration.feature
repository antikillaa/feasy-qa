Feature: Registration user

  Scenario: Registration as Author
    Given Go to the "home" page
    Then Click registration button
    Then Click become author button
    And Input First Name: "AutoTester"
    And Input Last Name: "Tester"
    And Input Email: "auto"
    And Input Password: "Password!1"
    And Check agreement checkbox
    Then Click submit button
    Then Choose "Business" category
    And Choose "Finance" subcategory
    And Input title: "Title"
    And Input personal description: "Description"
    Then Click submit button
    And Check author agreement checkbox
    Then Click submit button
    Then First name should be "AutoTester"
    And  Last name should be "Tester"



