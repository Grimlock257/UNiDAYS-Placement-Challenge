package me.grimlock257.unidayschallenge;

public class Discount {
    private String discountName;
    private String productName;
    private float price;
    private int quantity;

    public Discount(String discountName, String productName, float price, int quantity) {
        this.discountName = discountName;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
