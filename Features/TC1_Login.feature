@Login
Feature: Verifying SwagLabs login details

  Scenario Outline: Verifying SwagLabs Login Valid
    Given User is on the SwagLabs page
    When User should perform login "<username>","<password>"
    Then User should verify after login success message "PRODUCTS"

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Verifying SwagLabs Login using Enter key
    Given User is on the SwagLabs page
    When User should perform login "<username>","<password>" with Enter key
    Then User should verify after login success message "PRODUCTS"

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Verifying SwagLabs Login using Invalid Credential
    Given User is on the SwagLabs page
    When User should perform login "<username>","<password>"
    Then User should verify after login with invalid credential error msg "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | username | password |
      | Ashok    | ashok    |
