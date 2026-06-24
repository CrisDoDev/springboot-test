package com.example.milktea_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private int idOrderDetail;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "selected_size", nullable = false, length = 10)
    private String selectedSize;

    @Column(name = "selected_sugar", nullable = false, length = 20)
    private String selectedSugar;

    @Column(name = "selected_ice", nullable = false, length = 20)
    private String selectedIce;

    @Column(name = "price_at_order", nullable = false)
    private double priceAtOrder;

    public OrderDetail(){}
    public OrderDetail(int idOrderDetail, int orderId, int productId, int quantity, String selectedSize, String selectedSugar, String selectedIce, double priceAtOrder) {
        this.idOrderDetail = idOrderDetail;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.selectedSize = selectedSize;
        this.selectedSugar = selectedSugar;
        this.selectedIce = selectedIce;
        this.priceAtOrder = priceAtOrder;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public double getPriceAtOrder() {
        return priceAtOrder;
    }

    public void setPriceAtOrder(double priceAtOrder) {
        this.priceAtOrder = priceAtOrder;
    }
}
