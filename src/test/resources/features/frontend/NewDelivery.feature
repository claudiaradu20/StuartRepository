@frontend
@NewDelivery

Feature: New Delivery
  *As a* user of the Stuart application
  *I want to* be able to request a new delivery
  *So that* the package is delivered from the pick-up address to the drop-off address

  @testing
  @id:1 @Automated
  Scenario: User with correct addresses requests Now a Bike vehicle
    Given the user is logged in in the application with 'correct' email and 'correct' password
    And the user fills in the fields with a 'near pick-up' address
    And the user fills in the fields with a 'near drop-off' address
    And the user selects an available vehicle
    And the user selects a 'Now' as time of delivery
    When the user clicks on the REQUEST BUTTON
    Then a new job is created


  @id:2 @Automated
  Scenario: User with correct addresses requests Later a Car vehicle
    Given the user is logged in in the application with 'correct' email and 'correct' password
    And the user fills in the fields with a 'far pick-up' address
    When the user fills in the fields with a 'far drop-off' address
    Then 'Walker', 'Bike', 'Motorbike' and 'Cargobike' vehicles are not available
    And the user selects an available vehicle
    And the user selects a 'Later' as time of delivery
    When the user clicks on the REQUEST BUTTON
    Then a new job is scheduled


  @id:3 @Automated
  Scenario: Error message is displayed when pick-up and drop-off address are incorrect
    Given the user is logged in in the application with 'correct' email and 'correct' password
    And the user fills in the fields with a 'incorrect pick-up' address
    Then message 'The address is not accurate enough' is displayed in 'Pick-up' Address Form
    When the user fills in the fields with a 'near pick-up' address
    And the user fills in the fields with a 'incorrect drop-off' address
    Then message 'The address is not accurate enough' is displayed in 'Drop-off' Address Form


  @id:4
  Scenario: Phone number in not valid format is used
    Given the user is logged in in the application with 'correct' email and 'correct' password
    And the user fills in the Address field with a 'correct pick-up' value
    When the user fills in the Phone field with 'blank' value
    Then message 'This address is not accurate enough. Please provide a phone number.' is displayed
    When the user fills in the Phone field with 'incorrect' value
    Then message 'This address is not accurate enough. Please provide a phone number., Please provide a valid phone number' is displayed

  @id:5
  Scenario: Cost of delivery is correctly displayed in the Request button
    Given the user is logged in in the application and has filled out the pick-up and drop-off addresses
    When the user selects an available vehicle
    Then the cost is correctly displayed in the Request button
    When the user selects a different vehicle
    Then the cost is correctly displayed in the Request button






