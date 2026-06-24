package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "promotion_id")
    private Integer promotionId;

    @Column(name = "total_product_price", nullable = false)
    private double totalProductPrice;

    @Column(name = "shipping_fee", nullable = false)
    private double shippingFee;

    @Column(name = "discount_price")
    private double discountPrice = 0;

    @Column(name = "final_total", nullable = false)
    private double finalTotal;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus = "PENDING";

    @Column(name = "order_status", length = 50)
    private String orderStatus = "ORDERED";

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Order(){}
    public Order(int idOrder, int userId, Integer addressId, Integer promotionId, double totalProductPrice, double shippingFee, double discountPrice, String paymentMethod, double finalTotal, String paymentStatus, String orderStatus, String shippingAddress, Double latitude, Double longitude, String note, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.idOrder = idOrder;
        this.userId = userId;
        this.addressId = addressId;
        this.promotionId = promotionId;
        this.totalProductPrice = totalProductPrice;
        this.shippingFee = shippingFee;
        this.discountPrice = discountPrice;
        this.paymentMethod = paymentMethod;
        this.finalTotal = finalTotal;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.shippingAddress = shippingAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public double getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(double totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
