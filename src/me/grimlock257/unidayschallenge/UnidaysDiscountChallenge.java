package me.grimlock257.unidayschallenge;

import java.util.HashMap;

public class UnidaysDiscountChallenge {
    private HashMap<Item, Integer> basket;

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
}
