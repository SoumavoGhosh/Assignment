Feature: Location Search and Map Component Validation 
  Verify if user is able to search and locate valid address

  Scenario Outline: Locate valid address
    Given user has launched url
    When user types in "<address>" in the address search bar
    Then user is able to successfully locate "<address>" on map 
        
    Examples:
    
    |    address    |
    | RACE COURSE 138 |
    

    
    
