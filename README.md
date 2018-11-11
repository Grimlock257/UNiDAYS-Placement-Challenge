# UNiDAYS Discounts Challenge Placement 2019/20
This repository is my solution for the technical challenged posed by UNiDAYS for the placement year of 2019/20.

### Version information
Java Version: `9.0.1`

Testing Dependency: `JUnit 4`

IDE: `IntelliJ IDEA 2017.3.1 Build #IU-173.3942.27, December 11, 2017`

## Approaching the problem
### Planning
Firstly based upon the problem description, I will need to represent items and a basket of some kind. As the program is about applying discounts to the basket, I will also need to represent discounts. I will start with the following classes:
- `Item` - Represent a item (containing `name` and `price`)
- `Basket` - Represent a basket (containing list of `Item`s)
- `Discount` - Represent a discount that can be applied to a basket (containing `item` to be applied to, `price` after discount on `quantity` of products)

From the initial problem description I know that the `Basket` class will need to have methods `addToBasket` and `calculateTotalPrice`.
- `addToBasket` will add an `Item` to the basket list
- `calculateTotalPrice` will need to calculate the total item cost and delivery cost and return them in a data structure

For this data structure I will create a class called `PriceResult` which will store these two pieces of information.

### Test-driven approach
I will be using JUnit 4 to perform unit tests on my code as I code my solution to ensure my program functions as expected before moving onto implementing new features.