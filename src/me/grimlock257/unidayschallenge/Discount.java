package me.grimlock257.unidayschallenge;

import me.grimlock257.unidayschallenge.utils.FileUtils;

import java.util.ArrayList;

/**
 * Represents a discount that can be applied to the basket based on item quantity
 */
public class Discount {
    private String discountName;
    private String productName;
    private float price;
    private int quantity;

    // This list stores the available discounts
    public static ArrayList<Discount> discounts = new ArrayList<>();

    /**
     * Represents a Discount that can be applied to a basket
     *
     * @param discountName - The name of the discount
     * @param productName  - The productName of the discount
     * @param price        - The price of the resulting discount
     * @param quantity     - The required quantity of the item for the discount to be applied
     */
    public Discount(String discountName, String productName, float price, int quantity) {
        this.discountName = discountName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * This static method places all the available items into the items ArrayList
     *
     * @param path - The path to the discounts .txt file
     */
    public static void loadDiscounts(String path) {
        String discountsFile = FileUtils.loadFileAsString(path);

        // Loop through each line of the file, splitting by new lines
        for (String line : discountsFile.split("\n")) {
            // Split the current line by the delimiter ; in order to separate item, price and required quantity
            String[] itemData = line.split(";");
            String discountName = itemData[0];
            String productName = itemData[1];
            float discountPrice;
            int requiredQuantity;

            // Validate whether the price and quantity found in the file are valid numbers
            try {
                discountPrice = Float.parseFloat(itemData[2]);
                requiredQuantity = Integer.parseInt(itemData[3]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.err.println("[Discount] Could not process discount. Aborting.");
                return;
            }

            // Create the new item and add to the ArrayList
            discounts.add(new Discount(discountName, productName, discountPrice, requiredQuantity));
        }
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Applies to item '" + this.getProductName() + "': " + this.getDiscountName();
    }
}
