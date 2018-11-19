package me.grimlock257.unidayschallenge.utils;

import java.util.Scanner;

public class UserInputUtils {
    /**
     * Get a validated user from the user
     *
     * @param min - The minimum allowed integer
     * @param max - The maximum allowed integer
     * @return - The validated user choice integer
     */
    public static int getIntegerInput(Scanner scanner, int min, int max) {
        int userOption;

        // Loop forever until valid selection is made
        while (true) {
            System.out.print("> ");

            // Check if there is an int in the scanner buffer, else say they need to enter an integer
            if (scanner.hasNextInt()) {
                userOption = scanner.nextInt();
            } else {
                System.out.println("You must enter an integer, please select a valid option (" + min + " to " + max + ")");
                scanner.next();
                continue;
            }

            // We know a integer has been input, is it within the specified bounds?
            if (userOption >= min && userOption <= max) {
                break;
            }

            System.out.println("Invalid selection, please select a valid option (" + min + " to " + max + ")");
        }

        return userOption;
    }
}
