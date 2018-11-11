package me.grimlock257.unidayschallenge;

public class Main {
    public static void main(String[] args) {
        Item a = new Item("A", 8);
        Item b = new Item("B", 12, new Discount("2 for £20", 20, 2));
        Item c = new Item("C", 4, new Discount("3 for £10", 10, 3));
        Item d = new Item("D", 7, new Discount("Buy 1 get 1 free", 7, 2));
        Item e = new Item("E", 5, new Discount("3 for the price of 2", 10, 3));

        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();
        basket.addToBasket(b);
        basket.addToBasket(b);
        basket.addToBasket(b);

        PriceResult result = basket.calculateTotalPrice();

        System.out.println("Total Cost: " + result.getTotal());
        System.out.println("Delivery Cost: " + result.getDeliveryCharge());
        System.out.println("Overall Cost: " + (result.getTotal() + result.getDeliveryCharge()));
    }
}
