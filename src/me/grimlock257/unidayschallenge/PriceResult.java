package me.grimlock257.unidayschallenge;

/**
 * Object to store basket information (total cost of items and delivery charge)
 */
public class PriceResult {
    private float total;
    private float deliveryCharge;

    /**
     * Object structure to store price information for basket
     *
     * @param total          - The total cost of items in the basket (discounts applied)
     * @param deliveryCharge - The total delivery cost for the basket
     */
    public PriceResult(float total, float deliveryCharge) {
        this.total = total;
        this.deliveryCharge = deliveryCharge;
    }

    public float getTotal() {
        return total;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }

    @Override
    public String toString() {
        return "Total: " + this.total + ". Delivery Charge: " + this.getDeliveryCharge() + ".";
    }
}
