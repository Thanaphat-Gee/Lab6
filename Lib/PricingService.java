package Lib;

import Lib.Discount.*;
import java.util.*;

public class PricingService {
    private final List<Data> strategyList = new ArrayList<>();
    private static class Data {
        String sku;
        DiscountStrategy strategy;
        Data(String sku, DiscountStrategy strategy) {
            this.sku = sku;
            this.strategy = strategy;
        }
    }
    public void addStrategy(String sku, DiscountStrategy strategy) {
        for (Data data : strategyList) {
            if (data.sku.equals(sku)) {
                data.strategy = strategy;
                return;
            }
        }
        strategyList.add(new Data(sku, strategy));
    }

    public double calculateItemPrice(CartItem item) {
        String sku = item.getProduct().getProductId();
        for (Data data : strategyList) {
            if (data.sku.equals(sku)) {
                return data.strategy.calculatePrice(item);
            }
        }
        return new DefaultPricingStrategy().calculatePrice(item);
    }
}

