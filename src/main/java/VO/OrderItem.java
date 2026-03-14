package VO;

public class OrderItem {
    private final String id;
    private String name;
    private int quantity;
    private Money price;
    private final String category;

    public OrderItem(String id, String name, int quantity, Money price, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
}
