# RetailStoreData

## Overview
As part of this project we are calculating discounts on the basis of user type and as response we are getting final percentage-based discounts on a bill.
The RetailDiscountServiceImpl class is part of the retailStoreDiscounts application and implements the RetailDiscountService interface. It provides functionality to calculate discounts based on various criteria for a retail store.


## Technology used
Java, springBoot

## Build and run
```
In order to run and build the projedct you need to clone the project
cd clone
git checckout master

From terminal run build command
mvn clean install

Run Spring Boot app using Maven:
     mvn spring-boot:run
```

## generate test report
```
For generatting the test report we have run the command
mvn clean install 
and we will get test report file for the following path 
/RetailStoreDiscounts/RetailStoreData/target/jacoco-ut/index.html
```

## Features
Percentage Discounts: Applies different percentage-based discounts based on the user's type.
Flat Discounts: Provides a flat discount for every $100 spent.
Groceries Handling: Special handling for grocery items where percentage-based discounts do not apply.

## Methods
calculateDiscount(RequestDto request): Calculates the final discount based on the request details.


RequestDto
Ensure that the RequestDto class is defined with the following properties:

Since the items are groceries, the total bill amount is returned as is: 200.0


CURL to test the application :
end point url is : (POST) http://localhost:9001/api/discount/calculate
curl --location 'http://localhost:9001/api/discount/calculate' \
--header 'Content-Type: application/json' \
--header 'x-api-key: 0kXprL6RIP5iahdPD8zhSHO3PFyv3dL6TdYnxW8g' \
--data '{
    "userId": "employee",
    "billAmount": false,
    "groceriesBillAmount": 990.0
}'
