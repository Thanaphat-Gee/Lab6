package Lib;

public final class Product {
    private final String productId;
    private final String productName;
    private final double price;

    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
    }

    private void checkRep() {
        if (productId == null || productId.isBlank()) throw new IllegalArgumentException("Invalid productId");
        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Invalid productName");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }

}
