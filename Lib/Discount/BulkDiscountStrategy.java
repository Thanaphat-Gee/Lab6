package Lib.Discount;

import Lib.CartItem;

public class BulkDiscountStrategy implements DiscountStrategy {
    private final int minimumQuantity;
    private final double discountPercentage;

    public BulkDiscountStrategy(int minimumQuantity, double discountPercentage) {
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item) {
        double pricePerItem = item.getProduct().getPrice();
        int quantity = item.getQuantity();
        if (quantity >= minimumQuantity) {
            pricePerItem *= (1.0 - discountPercentage);
        }
        return quantity * pricePerItem;
    }
}
