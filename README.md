# RetailStoreData

## Overview
As part of this project we are calculating discounts on the basis of user type and as response we are getting final percentage-based discounts on a bill.
The RetailDiscountServiceImpl class is part of the retailStoreDiscounts application and implements the RetailDiscountService interface. It provides functionality to calculate discounts based on various criteria for a retail store.


## Technology used
Java, springBoot

## Approach
```
Steps to generate the discounted bill
1 USer will select the UserID 
2 User will add total groceries amount bill
3 User will add total other amount bill

This code will check the userType and accordingly calculate the percentage-based discount and for every $100 on the bill, there would be a $ 5 discount and final we will add both discounted amount.
And will subtract the discounted amount from total amount and return back.
```
<img width="581" alt="image" src="https://github.com/user-attachments/assets/3202cc25-1810-48fa-b36a-0e54d71029e7">


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

## 


## CURL to test the application :
```
end point url is : (POST) http://localhost:9001/api/discount/calculate
curl --location 'http://localhost:9001/api/discount/calculate' \
--header 'Content-Type: application/json' \
--header 'x-api-key: 0kXprL6RIP5iahdPD8zhSHO3PFyv3dL6TdYnxW8g' \
--data '{
    "userId": "employee",
    "billAmount": false,
    "groceriesBillAmount": 990.0
}'
```
