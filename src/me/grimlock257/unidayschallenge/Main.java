package me.grimlock257.unidayschallenge;

import me.grimlock257.unidayschallenge.utils.UserInputUtils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item.loadItems("items.txt");
        Discount.loadDiscounts("discounts.txt");

        Scanner scanner = new Scanner(System.in);
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        PriceResult result;
        float totalPrice;
        float deliveryTotal;
        float overallTotal;

        while (true) {
            // Display menu & get user input
            System.out.println("1) Add an item to your basket");
            System.out.println("2) Calculate basket price");
            System.out.println("3) Exit program");

            int userMainMenuChoice = UserInputUtils.getIntegerInput(scanner, 1, 3);

            // Handle options
            switch (userMainMenuChoice) {
                case 1:
                    System.out.println("Choose an item to add to your basket:");

                    // Generate numeric list of available items
                    int addItemCounter = 0;
                    for (Item item : Item.items.values()) {
                        System.out.println(++addItemCounter + ") " + item.getName());
                    }

                    int userAddChoice = UserInputUtils.getIntegerInput(scanner, 1, Item.items.size());

                    Item chosenItem = Item.getItem(userAddChoice);

                    basket.addToBasket(chosenItem);
                    System.out.println("Added item " + chosenItem.getName() + " to your basket!");

                    break;
                case 2:
                    // Display the basket price information
                    if (basket.getBasket().size() != 0) {
                        result = basket.calculateTotalPrice();

                        totalPrice = result.getTotal();
                        deliveryTotal = result.getDeliveryCharge();
                        overallTotal = totalPrice + deliveryTotal;

                        System.out.format("The total price of the items is £%.2f%n", totalPrice);
                        System.out.format("The delivery cost for your basket is £%.2f%n", deliveryTotal);
                        System.out.format("The overall total is £%.2f%n", overallTotal);
                    } else {
                        System.out.println("No items in your basket!");
                    }

                    break;
                case 3:
                    System.out.println("Exiting application...");
                    System.exit(0);

                    break;
                default:
                    System.err.println("Invalid option selected");
            }

            System.out.println(); // Print blank line before menu reprint
        }
    }
}
