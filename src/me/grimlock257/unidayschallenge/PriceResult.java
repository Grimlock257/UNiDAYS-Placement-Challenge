package me.grimlock257.unidayschallenge;

public class PriceResult {
    private float total = 0.0f;
    private float deliveryCharge = 0.0f;

    public PriceResult(float total, float deliveryCharge) {
        this.total = total;
        this.deliveryCharge = deliveryCharge;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public String toString() {
        return "Total: " + this.total + ". Delivery Charge: " + this.getDeliveryCharge();
    }
}
