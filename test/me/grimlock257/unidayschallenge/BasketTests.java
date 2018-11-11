package me.grimlock257.unidayschallenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTests {
    private Item a = new Item("A", 8);
    private Item b = new Item("B", 12, new Discount("2 for £20", 20, 2));

    @Test
    public void testA() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(a);

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(8, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(15, overallTotal, 0.0);
    }

    @Test
    public void testB() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(b);

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(12, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(19, overallTotal, 0.0);
    }

    @Test
    public void testBB() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(b);
        basket.addToBasket(b);

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(20, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(27, overallTotal, 0.0);
    }
}