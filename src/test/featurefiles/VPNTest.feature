Feature: Speech Check scenario with and without VPN Connected

#  Scenario: Check for network speed without VPN
#    Given user launches "fast.com"
#    And user waits for the speed meter
#    When speed meter calculates speed
#    Then user network speed is displayed
#    And user network speed without VPN is saved to compare later

  Scenario: Check for network speed with VPN
   Given user has VPN app running
   And user navigates to connect page
   When user clicks on connect button
   Then user is connected to VPN
    And user launches "http://fast.com" to check speed