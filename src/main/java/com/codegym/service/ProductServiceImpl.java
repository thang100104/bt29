package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products = new LinkedHashMap<>();

    static {
        products.put(1, new Product(1, "iPhone 15", 21990000, "Điện thoại Apple", "Apple"));
        products.put(2, new Product(2, "Galaxy S24", 19990000, "Điện thoại Samsung", "Samsung"));
        products.put(3, new Product(3, "MacBook Air M2", 25990000, "Laptop mỏng nhẹ", "Apple"));
        products.put(4, new Product(4, "Redmi Note 13", 4990000, "Điện thoại tầm trung", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        int newId = products.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        product.setId(newId);
        products.put(newId, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        product.setId(id);
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String keyword) {
        String value = keyword == null ? "" : keyword.trim().toLowerCase();
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(value)) {
                result.add(product);
            }
        }
        return result;
    }
}
