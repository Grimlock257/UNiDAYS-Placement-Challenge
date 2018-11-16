package me.grimlock257.unidayschallenge;

public class Main {
    public static void main(String[] args) {
        Item.loadItems("items.txt");
        Discount.loadDiscounts("discounts.txt");

        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));

        PriceResult result = basket.calculateTotalPrice();

        System.out.println("Total Cost: " + result.getTotal());
        System.out.println("Delivery Cost: " + result.getDeliveryCharge());
        System.out.println("Overall Cost: " + (result.getTotal() + result.getDeliveryCharge()));
    }
}
