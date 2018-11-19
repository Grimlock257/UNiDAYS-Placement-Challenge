package me.grimlock257.unidayschallenge;

import java.util.LinkedHashMap;

/**
 * Represents a shopping basket to contain Item objects
 */
public class UnidaysDiscountChallenge {
    private LinkedHashMap<Item, Integer> basket;

    public UnidaysDiscountChallenge() {
        basket = new LinkedHashMap<>();
    }

    /**
     * Add specified item to the basket
     *
     * @param item - The item to be added to the basket
     */
    public void addToBasket(Item item) {
        Integer previousValue = basket.get(item);
        basket.put(item, previousValue == null ? 1 : previousValue + 1);
    }

    /**
     * Remove specified item from the basket
     *
     * @param item     - The item to be removed from the basket
     * @param quantity - The amount to be remove from basket
     */
    public void removeFromBasket(Item item, int quantity) {
        if (basket.containsKey(item)) {
            if (basket.get(item) == 1) {
                basket.remove(item);
                return;
            } else {
                basket.put(item, basket.get(item) - quantity);

                if (basket.get(item) == 0) {
                    basket.remove(item);
                }
            }
        }
    }

    /**
     * Empty the basket of all items.
     */
    public void emptyBasket() {
        basket.clear();
    }

    /**
     * Calculate the total price of basket items and delivery charge
     *
     * @return - Return a new PriceResult object containing the calculated data
     */
    public PriceResult calculateTotalPrice() {
        float total = 0;
        float deliveryCharge = 0;

        float curDiscount;
        float curNonDiscount;

        for (Item item : basket.keySet()) {
            Discount theDiscount = null;

            for (Discount discount : Discount.discounts) {
                if (item.getName().equals(discount.getProductName())) {
                    theDiscount = discount;
                    break;
                }
            }

            if (theDiscount != null) {
                curDiscount = basket.get(item) / theDiscount.getQuantity() * theDiscount.getPrice();
                curNonDiscount = (basket.get(item) - ((basket.get(item) / theDiscount.getQuantity()) * theDiscount.getQuantity())) * item.getPrice();

                total += curDiscount + curNonDiscount;
            } else {
                total += item.getPrice() * basket.get(item);
            }
        }

        deliveryCharge = (total >= 50 || total == 0) ? 0 : 7;

        return new PriceResult(total, deliveryCharge);
    }

    /**
     * Return an item from the basket LinkedHashMap
     *
     * @param index - The index at which to find the item
     * @return - The Item at the specified index
     */
    public Item getItem(int index) {
        int counter = 0;
        for (Item item : basket.keySet()) {
            if (++counter == index) {
                return item;
            }
        }

        return null;
    }

    public LinkedHashMap<Item, Integer> getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("#  Item  Qty\n");

        int index = 0;
        for (Item item : getBasket().keySet()) {
            result.append(++index + "  " + item.getName() + "     " + getBasket().get(item) + "\n");
        }

        return result.toString();
    }
}
