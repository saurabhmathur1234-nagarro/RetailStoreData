# RetailStoreData

## Overview
As part of this project we are calculating discounts on the basis of user type and as response we are getting final percentage-based discounts on a bill.
The RetailDiscountServiceImpl class is part of the retailStoreDiscounts application and implements the RetailDiscountService interface. It provides functionality to calculate discounts based on various criteria for a retail store.


## Technology used
Java, springBoot

## Build and run
In order to run and build the projedct you need to clone the project
cd clone 
git checckout master
From terminal run build command
mvn clean install


Features
Percentage Discounts: Applies different percentage-based discounts based on the user's type.
Flat Discounts: Provides a flat discount for every $100 spent.
Groceries Handling: Special handling for grocery items where percentage-based discounts do not apply.

Methods
calculateDiscount(RequestDto request): Calculates the final discount based on the request details.

Parameters:

RequestDto request: Contains the details of the bill amount, user type, whether the items are groceries, and the number of years as a customer.
Returns: double - The final amount after applying all discounts.

getPercentageDiscount(RequestDto request): Determines the percentage discount based on the user type and customer tenure.

calculateFlatDiscount(double amount): Calculates a flat discount of $5 for every $100 in the bill amount.

RequestDto
Ensure that the RequestDto class is defined with the following properties:



Discount Rules
Employee: 30% discount on the total bill.
Affiliate: 10% discount on the total bill.
Customer: 5% discount if the customer has been with the store for more than 2 years.
Groceries: No percentage discounts apply; the total bill amount is returned as is.
Flat Discount: An additional $5 discount for every $100 on the bill.
Examples
Example 1: Employee Discount
Request:

userType: "employee"
isGroceries: "false"
billAmount: 990.0
yearsAsCustomer: 1
Calculation:

Percentage Discount: 30% of 990.0 = 297.0
Flat Discount: (990.0 / 100) * 5 = 45.0
Total Discount: 297.0 + 45.0 = 342.0
Final Amount: 990.0 - 342.0 = 648.0
Example 2: Grocery Items
Request:

userType: "employee"
isGroceries: "true"
billAmount: 200.0
yearsAsCustomer: 1
Calculation:

Since the items are groceries, the total bill amount is returned as is: 200.0


CURL to test the application :
end point url is : (POST) http://localhost:9001/api/discount/calculate
curl --location 'http://localhost:9001/api/discount/calculate' \
--header 'Content-Type: application/json' \
--header 'x-api-key: 0kXprL6RIP5iahdPD8zhSHO3PFyv3dL6TdYnxW8g' \
--data '{
    "userType": "employee",
    "isGroceries": false,
    "billAmount": 990.0,
    "yearsAsCustomer": 1
}'
