package me.grimlock257.unidayschallenge;

public class Item {
    private String name;
    private float price;
    private Discount discount;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
        this.discount = null;
    }

    public Item(String name, float price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
