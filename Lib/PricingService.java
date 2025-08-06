package Lib;

import Lib.Discount.*;
import java.util.*;

public class PricingService {
    // ใช้ ArrayList เก็บคู่ของ SKU กับ Strategy
    private final List<Data> strategyList = new ArrayList<>();
    // inner class สำหรับเก็บคู่ข้อมูล
    private static class Data {
        String sku;
        DiscountStrategy strategy;
        Data(String sku, DiscountStrategy strategy) {
            this.sku = sku;
            this.strategy = strategy;
        }
    }
    public void addStrategy(String sku, DiscountStrategy strategy) {
        // ถ้ามีอยู่แล้ว ให้แทนที่ตัวเดิม
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
        return new DefaultPricingStrategy().calculatePrice(item); // ไม่พบ -> ใช้ default
    }
}
