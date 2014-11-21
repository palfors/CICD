Feature: Checking account usage

    Scenario: A deposit should increase the value of the account
        Given I have an account with 100
        When I make a deposit of 50
        Then there should be 150 in the account

    Scenario: A withdrawal should decrease the value of the account
        Given I have an account with 100
        When I make a withdrawal of 50
        Then there should be 50 in the account

    Scenario: A withdrawal may not be larger than the current balance
        Given I have an account with 100
        When I attempt to overdraw the account by requesting 150
        Then the balance should remain 100

    Scenario: A series of deposits are made
        Given the following deposits are applied
          |initial|deposit|result|
          |100    |25     |125   |
          |400    |50     |450   |
          |325    |75     |400   |
