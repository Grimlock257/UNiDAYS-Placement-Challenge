package me.grimlock257.unidayschallenge;

import me.grimlock257.unidayschallenge.utils.UserInputUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        program.runProgram();
    }

    /**
     * The main program function.
     */
    public void runProgram() {
        // Load items & discounts from files
        Item.loadItems("items.txt");
        Discount.loadDiscounts("discounts.txt");

        // Key variables for program
        Scanner scanner = new Scanner(System.in);
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        PriceResult result;
        float totalPrice;
        float deliveryTotal;
        float overallTotal;

        while (true) {
            // Display menu & get user input
            System.out.println("1) Add an item to your basket");
            System.out.println("2) Remove item from basket");
            System.out.println("3) View basket");
            System.out.println("4) View available discounts");
            System.out.println("5) Calculate basket price");
            System.out.println("6) Empty basket");
            System.out.println("7) Exit program");

            int userMainMenuChoice = UserInputUtils.getIntegerInput(scanner, 1, 7);

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
                    if (basket.getBasket().size() != 0) {
                        System.out.println("Your basket currently contains:");
                        System.out.println(basket.toString());

                        // Retrieve the type of item they want to remove
                        System.out.println("Enter the number of the item you want do delete:");

                        int userRemoveItemChoice = UserInputUtils.getIntegerInput(scanner, 1, basket.getBasket().size());

                        Item removeItem = basket.getItem(userRemoveItemChoice);

                        // Ask how qty of removable (if applicable) and remove from basket
                        int userRemoveQuantityChoice;

                        if (basket.getBasket().get(removeItem) > 1) {
                            System.out.println("How many do you want to remove from your basket?");
                            userRemoveQuantityChoice = UserInputUtils.getIntegerInput(scanner, 1, basket.getBasket().get(removeItem));
                        } else {
                            userRemoveQuantityChoice = 1;
                        }

                        basket.removeFromBasket(removeItem, userRemoveQuantityChoice);

                        System.out.println("Removed!");
                    } else {
                        System.out.println("No items in your basket!");
                    }

                    break;
                case 3:
                    System.out.println("Your basket currently contains:");

                    // Print current basket contents in table like format
                    if (basket.getBasket().size() != 0) {
                        System.out.println(basket.toString());
                    } else {
                        System.out.println("No items in your basket!");
                    }

                    break;
                case 4:
                    // Print available discounts
                    if (Discount.discounts.size() > 0) {
                        for (Discount discount : Discount.discounts) {
                            System.out.println(discount.toString());
                        }
                    } else {
                        System.out.println("No discounts available!");
                    }

                    break;
                case 5:
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
                case 6:
                    System.out.println("Are you sure you want to empty your basket?");
                    System.out.println("1) Yes");
                    System.out.println("2) No");

                    int userEmptyConfirm = UserInputUtils.getIntegerInput(scanner, 1, 2);

                    if (userEmptyConfirm == 1) {
                        basket.emptyBasket();
                        System.out.println("You have emptied your basket!");
                    } else {
                        System.out.println("Your basket has not been changed.");
                    }

                    break;
                case 7:
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
