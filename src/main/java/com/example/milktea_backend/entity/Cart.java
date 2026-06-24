package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private int idCart;

    @Column(name = "user_id", nullable = false, unique = true)
    private int userId;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Cart(){}
    public Cart(int idCart, int userId, LocalDateTime updatedAt) {
        this.idCart = idCart;
        this.userId = userId;
        this.updatedAt = updatedAt;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
