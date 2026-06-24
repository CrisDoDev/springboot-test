package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail_toppings")
@IdClass(OrderDetailToppingId.class)
public class OrderDetailTopping {
    @Id
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @Id
    @Column(name = "topping_id")
    private int toppingId;

    @Column(name = "price_at_order", nullable = false)
    private double priceAtOrder;

    public OrderDetailTopping(){}
    public OrderDetailTopping(int orderDetailId, int toppingId, double priceAtOrder) {
        this.orderDetailId = orderDetailId;
        this.toppingId = toppingId;
        this.priceAtOrder = priceAtOrder;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public double getPriceAtOrder() {
        return priceAtOrder;
    }

    public void setPriceAtOrder(double priceAtOrder) {
        this.priceAtOrder = priceAtOrder;
    }
}
class OrderDetailToppingId implements Serializable {
    private int orderDetailId;
    private int toppingId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailToppingId that = (OrderDetailToppingId) o;
        return orderDetailId == that.orderDetailId && toppingId == that.toppingId;
    }

    @Override
    public int hashCode() { return Objects.hash(orderDetailId, toppingId); }
}
