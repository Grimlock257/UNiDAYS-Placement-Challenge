package me.grimlock257.unidayschallenge;

public class Main {
    public static void main(String[] args) {
        Item a = new Item("A", 8);
        Item b = new Item("B", 12);
        Item c = new Item("C", 4);
        Item d = new Item("D", 7);
        Item e = new Item("E", 5);

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
