# RetailStoreData

Overview
The RetailDiscountServiceImpl class is part of the retailStoreDiscounts application and implements the RetailDiscountService interface. It provides functionality to calculate discounts based on various criteria for a retail store.

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