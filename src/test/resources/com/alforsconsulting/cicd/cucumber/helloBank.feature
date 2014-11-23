Feature: HelloBank usage

    Scenario: A customer may log in using their name
        Given a customer with name Test exists
        When I login using name Test
        Then the system will find customer Test

    Scenario: A customer's name is unique in the system
        Given a customer with name Test exists
        When I attempt to create a duplicate user named Test
        Then the system should have 1 customer named Test
