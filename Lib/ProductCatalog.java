package Lib;

import java.util.*;

public class ProductCatalog {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null || findById(product.getProductId()) != null) return;
        products.add(product);
    }

    public Product findById(String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) return p;
        }
        return null;
    }
}
