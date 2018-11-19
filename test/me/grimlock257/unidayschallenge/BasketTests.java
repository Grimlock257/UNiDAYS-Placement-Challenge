package me.grimlock257.unidayschallenge;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTests {
    @BeforeClass
    public static void onLaunch() {
        // Load the items & discounts into memory
        Item.loadItems("items.txt");
        Discount.loadDiscounts("discounts.txt");
    }

    @Test
    public void testEmptyBasket() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(0, totalPrice, 0.0);
        assertEquals(0, deliveryTotal, 0.0);
        assertEquals(0, overallTotal, 0.0);
    }

    @Test
    public void testA() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("A"));

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

        basket.addToBasket(Item.getItem("B"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(12, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(19, overallTotal, 0.0);
    }

    @Test
    public void testC() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("C"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(4, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(11, overallTotal, 0.0);
    }

    @Test
    public void testD() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("D"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(7, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(14, overallTotal, 0.0);
    }

    @Test
    public void testE() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("E"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(5, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(12, overallTotal, 0.0);
    }

    @Test
    public void testBB() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(20, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(27, overallTotal, 0.0);
    }

    @Test
    public void testBBB() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(32, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(39, overallTotal, 0.0);
    }

    @Test
    public void testBBBB() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(40, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(47, overallTotal, 0.0);
    }

    @Test
    public void testCCC() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(10, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(17, overallTotal, 0.0);
    }

    @Test
    public void testCCCC() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(14, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(21, overallTotal, 0.0);
    }

    @Test
    public void testDD() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(7, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(14, overallTotal, 0.0);
    }

    @Test
    public void testDDD() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(14, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(21, overallTotal, 0.0);
    }

    @Test
    public void testEE() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(10, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(17, overallTotal, 0.0);
    }

    @Test
    public void testEEE() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(10, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(17, overallTotal, 0.0);
    }

    @Test
    public void testEEEE() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(15, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(22, overallTotal, 0.0);
    }

    @Test
    public void testDDDDDDDDDDDDDD() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(49, totalPrice, 0.0);
        assertEquals(7, deliveryTotal, 0.0);
        assertEquals(56, overallTotal, 0.0);
    }

    @Test
    public void testBBBBCCC() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(50, totalPrice, 0.0);
        assertEquals(0, deliveryTotal, 0.0);
        assertEquals(50, overallTotal, 0.0);
    }

    @Test
    public void testABBCCCDDEE() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("A"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("E"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(55, totalPrice, 0.0);
        assertEquals(0, deliveryTotal, 0.0);
        assertEquals(55, overallTotal, 0.0);
    }

    @Test
    public void testEDCBAEDCBC() {
        UnidaysDiscountChallenge basket = new UnidaysDiscountChallenge();

        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("A"));
        basket.addToBasket(Item.getItem("E"));
        basket.addToBasket(Item.getItem("D"));
        basket.addToBasket(Item.getItem("C"));
        basket.addToBasket(Item.getItem("B"));
        basket.addToBasket(Item.getItem("C"));

        PriceResult result = basket.calculateTotalPrice();

        float totalPrice = result.getTotal();
        float deliveryTotal = result.getDeliveryCharge();
        float overallTotal = totalPrice + deliveryTotal;

        assertEquals(55, totalPrice, 0.0);
        assertEquals(0, deliveryTotal, 0.0);
        assertEquals(55, overallTotal, 0.0);
    }
}