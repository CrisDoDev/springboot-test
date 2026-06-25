package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topping")
    private int idTopping;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "topping_name", nullable = false, unique = true, length = 100)
    private String toppingName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "status")
    private byte status = 1;

    @Column(name = "is_deleted")
    private byte isDeleted = 0;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Topping(){}
    public Topping(int idTopping, int categoryId, String toppingName, double price, String imageUrl, byte status, byte isDeleted, LocalDateTime createdAt) {
        this.idTopping = idTopping;
        this.categoryId = categoryId;
        this.toppingName = toppingName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
    }

    public int getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(int idTopping) {
        this.idTopping = idTopping;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
