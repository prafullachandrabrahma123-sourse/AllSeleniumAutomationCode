
@tag
  Feature: Add the products in cart 
    I want to few products in the cart.
    
    Background:
     Given I landed on loginPage
    
    @Regression
     Scenario Outline: Add the <products> in cart 
     Given Logged in with userName<name> and password<Password>
     When i added products <productName>from cart
     Then    check<productName> is present 
     
     Examples:

              | name                           |Password    |productName   |
              | prafullachandrabrahma@gmail.com|Prafulla@123|ZARA COAT 3   |           
     
