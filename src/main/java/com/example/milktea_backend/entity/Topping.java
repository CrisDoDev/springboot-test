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

    @Column(name = "topping_name", nullable = false, unique = true, length = 100)
    private String toppingName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "status")
    private byte status = 1;

    @Column(name = "is_deleted")
    private byte isDeleted = 0;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Topping(){}
    public Topping(int idTopping, String toppingName, double price, byte status, byte isDeleted, LocalDateTime createdAt) {
        this.idTopping = idTopping;
        this.toppingName = toppingName;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
