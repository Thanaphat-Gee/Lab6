package Lib.Discount;

import Lib.CartItem;

public class BogoDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculatePrice(CartItem item) {
        int quantity = item.getQuantity();
        int payFor = (quantity / 2) + (quantity % 2);
        return payFor * item.getProduct().getPrice();
    }
}
