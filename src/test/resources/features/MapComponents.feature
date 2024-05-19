Feature: Map Components 
  Verify if user is able to see all components on map

  Scenario Outline: Verification of map components 
    Given user has launched url
    Then user is able to see "<allcomponents>" on map 
        
    Examples:
    
    |    allcomponents    |
    | address search bar  |
    |      community      |
    | school query info   |
    |      medical        |
    |    hawker centres   |
    |     threeDMap       |
    |     draw tools      |
    |    share view       |
    |   get my location   |
    |   zoom button       |
    
    
    
