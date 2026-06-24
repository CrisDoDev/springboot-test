package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_toppings")
@IdClass(ProductToppingId.class)
public class ProductTopping {
    @Id
    @Column(name = "product_id")
    private int productId;

    @Id
    @Column(name = "topping_id")
    private int toppingId;

    public ProductTopping(){}
    public ProductTopping(int productId, int toppingId) {
        this.productId = productId;
        this.toppingId = toppingId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }
}
