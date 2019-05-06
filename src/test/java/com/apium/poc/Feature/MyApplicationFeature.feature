@Functional
Feature: Selendroid Application Test


  Scenario: Validate home page elements
    Given User opens Selendroid application
    Then validate the elements on UI for home page    


  Scenario Outline: Register a new user in the application
    Given User opens Selendroid application
    When User clicks on Create New User icon
    And User provides valid details and click on submit button "<name>","<userName>","<email>","<password>","<language>","<addRequired>","<isUsed>"
    Then User details should be populated correctly on verify screen
    When user clicks on Confirm button
    Then homepage should be displayed
    Examples:
    |name				|userName					|email										|password				|language				|addRequired				|isUsed				|
    |Abhishek		|abhi.021988			|abhi.021988@gmail.com		|12345					|Ruby						|TRUE								|Used					|	
    |Amit				|Amit.021988			|amit.021988@gmail.com		|12345					|Ruby						|TRUE								|Used					|	
    
    Scenario Outline: Validate EN button functionality
    Given User opens Selendroid application
    When User clicks on EN button
    Then Popup should be displayed with Iagree and No button disabled
    And Agree button should have text "<agreeButtonText>" and cancel button should have text "<cancelButtonText>"
    Examples:
    |agreeButtonText			|cancelButtonText			|
    |I agree							|No, no								|
    
    Scenario: Validate EN button functionality
    Given User opens Selendroid application
    When User clicks on EN button
    Then user should be on home page on the click of cancel button
    
    Scenario: Validate EN button functionality
    Given User opens Selendroid application
    When User clicks on EN button
    Then application should close on the click of agree button
    