package me.grimlock257.unidayschallenge;

import me.grimlock257.unidayschallenge.utils.FileUtils;

import java.util.LinkedHashMap;

public class Item {
    private String name;
    private float price;

    // This list stores the available items for purchase
    public static LinkedHashMap<String, Item> items = new LinkedHashMap<>();

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public static void loadItems(String path) {
        String itemsFile = FileUtils.loadFileAsString(path);

        // Loop through each line of the file, splitting by new lines
        for (String line : itemsFile.split("\n")) {
            // Split the current line by the delimiter ; in order to separate name and price
            String[] itemData = line.split(";");
            String itemName = itemData[0];
            float itemPrice;

            // Validate whether the price found in the file is a valid number
            try {
                itemPrice = Float.parseFloat(itemData[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.err.println("[Item] Could not process item. Aborting.");
                return;
            }

            // Create the new item and add to the ArrayList
            items.put(itemName, new Item(itemName, itemPrice));
        }
    }

    public static Item getItem(int index) {
        int counter = 0;
        for (Item item : Item.items.values()) {
            if (++counter == index) {
                return item;
            }
        }

        return null;
    }

    public static Item getItem(String name) {
        for (Item item : Item.items.values()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
