package Lib;

import java.util.*;

public class ShoppingCart {
    private final PricingService pricingService;
    private final ProductCatalog catalog;
    private final List<CartItem> items = new ArrayList<>();

    public ShoppingCart(PricingService pricingService, ProductCatalog catalog) {
        this.pricingService = pricingService;
        this.catalog = catalog;
        checkRep();
    }

    public void addItem(String productId, int quantity) {
        if (quantity <= 0) return;
        Product product = catalog.findById(productId);
        if (product == null) return;

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                checkRep();
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        checkRep();
    }

    public void removeItem(String productId) {
        items.removeIf(item -> item.getProduct().getProductId().equals(productId));
        checkRep();
    }

    public void clearCart() {
        items.clear();
        checkRep();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items) {
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }

    public int getItemCount() {
        return items.size();
    }

    private void checkRep() {
        for (CartItem item : items) {
            if (item == null || item.getProduct() == null) {
                throw new IllegalStateException("Invalid CartItem");
            }
        }
    }
}
