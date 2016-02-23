@run
Feature: Create Account details validation

  In order to ensure that a user provided required and properly formatted information for account creation
  As a store owner
  I want to forbid account creation if the information is missing or incorrect and provide corresponding feedback to the user

  Scenario Outline: User's enters invalid email during account creation
    Given I want to create a new user account
    And I enter "John" as my first name
    And I enter "Smith" as my last name
    And I enter "123456" as my password
    And I enter "123456" to confirm my password
    And I enter "<Email>" as my email
    When I select create account option
    Then I see a message "Please enter a valid email address." informing me to enter a correct email
    And user account is not created

    Examples:
      | Email                                                                   |
      | test                                                                    |
#      | test@.com                                                               |
#      | test@gmail.                                                             |
#      | test.test.com                                                           |
#      | test@                                                                   |
#      | A@b@c@test.com                                                          |
#      | a"b(c),e@test.com                                                       |
#      | a"bbb"ccc@test.com                                                      |
#      | test test@test.org                                                      |
#      | test\ test@test.org                                                     |
#      | test\"test@test.org                                                     |
#      | abc@test..com                                                           |
#      | ab..c@test.com                                                          |
#      | test@.gmail.com                                                         |
#      | .test@gmail.com                                                         |
#      | 71symbolInvalidEmail71symbolInvalidEmail71symbolInvalidEmail7@gmail.com |

    #First name and Last name - alphanumeric, between 1 and 25 characters
    #First and last names may include symbols -/''. only as part of alphanumeric name
  Scenario Outline: User's enters invalid first and last names during account creation
    Given I want to create a new user account
    And I enter "<First name>" as my first name
    And I enter "<Last name>" as my last name
    And I enter "123456" as my password
    And I enter "123456" to confirm my password
    And I enter "jsmith@gmail.com" as my email
    When I select create account option
    Then I see a message "Please enter a valid first name." informing me to enter the correct first name
    And I see a message "Please enter a valid last name." informing me to enter the correct last name
    And user account is not created

    Examples:
      | First name                 | Last name                  |
      | John@#$                    | S$mi32th';                 |
#      | 1234                       | 1234                       |
#      | !@#$%^&*()_+               | !@#$%^&*()_+               |
#      | -                          | ''                         |
#      | '                          | -                          |
#      | .                          | .                          |
#      | /                          | /                          |
#      | /.'-                       | /.'-                       |
#      | JohnS1234567890qwertyuiopa | JohnS1234567890qwertyuiopa |


  Scenario Outline: User enters the password which does not match password requirements
    Given I want to create a new user account
    And I enter "John" as my first name
    And I enter "Smith" as my last name
    And I enter "<Password>" as my password
    And I enter "<Confirm password>" to confirm my password
    And I enter "jsmith@gmail.com" as my email
    When I select create account option
    Then user account is not created
    And I see the message informing me to enter a valid password "<Message>"

    Examples:
      | Password      | Confirm password | Message                                                                                   |
      | Abc1#         | Abc1#            | Your password must contain between 6 and 12 characters, with no spaces. Please try again. |
      | 1234567890123 | 1234567890123    | Your password must contain between 6 and 12 characters, with no spaces. Please try again. |
      | Pass 1        | Pass 1           | Your password must contain between 6 and 12 characters, with no spaces. Please try again. |


  Scenario Outline: User enters passwords which do not match.
    Given I want to create a new user account
    And I enter "John" as my first name
    And I enter "Smith" as my last name
    And I enter "<Password>" as my password
    And I enter "<Confirm password>" to confirm my password
    And the passwords entered do not match
    And I enter "jsmith@gmail.com" as my email
    When I select create account option
    Then user account is not created
    And I see the message informing me that passwords do not match "<Message>"

    Examples:
      | Password | Confirm password | Message                                                   |
      | Abc123   | 123abc           | The passwords you entered do not match. Please try again. |

  Scenario: Required information is not entered
    Given I want to create a new user account
    And I do not enter a first name
    And I do not enter a last name
    And I do not enter an email
    And I do not enter a password
    And I do not confirm password
    When I select create account option
    Then user account is not created
    And I see a message "This information is required." informing me to enter each required detail

  #Scenario: User with email entered already exists in db
