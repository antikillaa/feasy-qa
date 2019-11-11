Feature: Registration user "Create suite"

  Scenario:
    Given Create Test Suite

  Scenario: Author registration C189
    Given TC: "189"
    Given Go to the "home" page
    Then Click registration button
    Then Click become author button
    And Input First Name: "AutoTester"
    And Input Last Name: "Tester"
    And Input Email
    And Input Password
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
    And Last name should be "Tester"

  Scenario: Entering email for notification C183
    Given TC: "183"
    Given Go to the main page
    And Input Invalid Email in Enter your email address
    Then Click submit button
    And Input Valid Email in Enter your email address
    Then Click submit button
    Then Confirmation popup is appear

  Scenario: Clicking on 'Sign-in' button C250
    Given TC: "250"
    Given Go to the main page
    Then Click Sign in to beta button
    Then Sign in page is opened
    Then "sign-in" page is opened

  Scenario: User login with correct credentials C1
    Given TC: "1"
    Given Go to the "home" page
    Then Click registration button
    Then Click become author button
    And Input First Name: "AutoTester"
    And Input Last Name: "Tester"
    And Input Email
    And Input Password
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
    And Last name should be "Tester"
    Then Click Avatar link
    And Click Sign Out link
    Then Click Sign In link
    And Input Email
    And Input Password
    Then Click submit button
    Then First name should be "AutoTester"
    And Last name should be "Tester"