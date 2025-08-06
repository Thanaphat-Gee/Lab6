package Lib;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
        checkRep();
    }

    private void checkRep() {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}
