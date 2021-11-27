Feature: AddNewAddress

  Scenario Outline: AddNewAddress
    Given Open in browser mystore-testlab.coderslab.pl
    When click on botton Sign in
    When entering <email> in Email input
    When entering <password> in Password input
    And click on button Sign in to log in the site
    When click on button Addresses
    When click on button + Create new address
    And entering <alias> in Alias input
    And entering <address> in Address input
    And entering <zip> in Zip input
    And entering <city> in City input
    And choose Country on select list
    And entering <phone> in Phone input
    And click on button Save
    Then address successfully added
    Then checking form address <alias>, <address>, <city>, <zip> and <phone>
    And closed browser

    Examples:
    |email|password|alias|address|zip|city|phone|
    |xytjawcrqdjqonhmqi@mrvpm.net|Test1234!|Test Alias|Test Address 1/1|11-500|Test Giżycko|608123456|