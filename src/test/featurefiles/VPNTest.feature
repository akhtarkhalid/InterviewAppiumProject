Feature: Speech Check scenario with and without VPN Connected

  Scenario: Check for network speed without VPN
    Given user launches "fast.com"
    And user waits for the speed meter
    When speed meter calculates speed
    Then user network speed is displayed
    And user network speed without VPN is saved to compare later

  Scenario: Check for network speed with VPN
    Given user has VPN app running
    And user clicks on connect button
    When user is connected to VPN
    Then user launches "fast.com"
    And user waits for the speed meter
    And speed meter calculates speed
    And user network speed is displayed
    And user network speed without VPN is saved to compare later