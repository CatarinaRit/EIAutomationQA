Navigate to Home Page

 - `home.GoToHomePage(url);`

Click on the button to take a tour and skip it 

- ` home.TakeAndSkipTour();`

Select the currency and go to register page

-   `home.SelectCurrency("US Dollars");`
-  `home.GoToRegister();`

Create the new user on the register page

-  `register.SignUpAndRegister(email, username, "+351967754192", password);`

Validate that the user was created

-  `home.ValidateRegister(username);`
  