package com.example.milktea_backend.dto;

import com.example.milktea_backend.entity.Product;
import java.util.List;

public class AdminBulkProductRequest {
    private int categoryId;
    private List<Integer> toppingIds;
    private List<Product> products;

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public List<Integer> getToppingIds() { return toppingIds; }
    public void setToppingIds(List<Integer> toppingIds) { this.toppingIds = toppingIds; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}