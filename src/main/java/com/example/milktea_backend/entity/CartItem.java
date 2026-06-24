package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart_item")
    private int idCartItem;

    @Column(name = "cart_id", nullable = false)
    private int cartId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity", nullable = false)
    private int quantity = 1;

    @Column(name = "selected_size", nullable = false, length = 10)
    private String selectedSize = "Size M";

    @Column(name = "selected_sugar", nullable = false, length = 20)
    private String selectedSugar = "100% Đường";

    @Column(name = "selected_ice", nullable = false, length = 20)
    private String selectedIce = "100% Đá";

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CartItem(){}
    public CartItem(int idCartItem, int cartId, int productId, int quantity, String selectedSize, String selectedSugar, String selectedIce, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idCartItem = idCartItem;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.selectedSize = selectedSize;
        this.selectedSugar = selectedSugar;
        this.selectedIce = selectedIce;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(int idCartItem) {
        this.idCartItem = idCartItem;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    public String getSelectedSugar() {
        return selectedSugar;
    }

    public void setSelectedSugar(String selectedSugar) {
        this.selectedSugar = selectedSugar;
    }

    public String getSelectedIce() {
        return selectedIce;
    }

    public void setSelectedIce(String selectedIce) {
        this.selectedIce = selectedIce;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
