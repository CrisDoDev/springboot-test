package com.example.milktea_backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductToppingId implements Serializable {
    private int productId;
    private int toppingId;

    public ProductToppingId() {}
    public ProductToppingId(int productId, int toppingId) {
        this.productId = productId;
        this.toppingId = toppingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductToppingId that = (ProductToppingId) o;
        return productId == that.productId && toppingId == that.toppingId;
    }

    @Override
    public int hashCode() { return Objects.hash(productId, toppingId); }
}
