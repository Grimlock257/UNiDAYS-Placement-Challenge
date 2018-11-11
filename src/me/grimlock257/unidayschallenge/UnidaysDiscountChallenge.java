package me.grimlock257.unidayschallenge;

import java.util.HashMap;

public class UnidaysDiscountChallenge {
    private HashMap<Item, Integer> basket;

    // TODO Better?
    private Discount[] discounts = {
            new Discount("2 for £20", "B", 20, 2),
            new Discount("3 for £10", "C", 10, 3),
            new Discount("Buy 1 get 1 free", "D", 7, 2),
            new Discount("3 for the price of 2", "E", 10, 3)
    };

    public UnidaysDiscountChallenge() {
        basket = new HashMap<>();
    }

    public void addToBasket(Item item) {
        Integer previousValue = basket.get(item);
        basket.put(item, previousValue == null ? 1 : previousValue + 1);
    }

    public PriceResult calculateTotalPrice() {
        float total = 0;
        float deliveryCharge = 0;

        float curDiscount;
        float curNonDiscount;

        for (Item item : basket.keySet()) {
            Discount theDiscount = null;

            // TODO Improve?
            for (int i = 0; i < discounts.length; i++) {
                if (item.getName().equals(discounts[i].getProductName())) {
                    theDiscount = discounts[i];
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
}
