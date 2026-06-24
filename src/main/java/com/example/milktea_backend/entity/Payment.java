package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private int idPayment;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "transaction_code", length = 100)
    private String transactionCode;

    @Column(name = "response_code", length = 50)
    private String responseCode;

    @Column(name = "payment_gateway_note", columnDefinition = "TEXT")
    private String paymentGatewayNote;

    @Column(name = "payment_status", length = 50)
    private String paymentStatus = "PENDING";

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Payment(){}
    public Payment(int idPayment, int orderId, String paymentMethod, double amount, String transactionCode, String responseCode, String paymentGatewayNote, String paymentStatus, LocalDateTime paidAt, LocalDateTime createdAt) {
        this.idPayment = idPayment;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.transactionCode = transactionCode;
        this.responseCode = responseCode;
        this.paymentGatewayNote = paymentGatewayNote;
        this.paymentStatus = paymentStatus;
        this.paidAt = paidAt;
        this.createdAt = createdAt;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getPaymentGatewayNote() {
        return paymentGatewayNote;
    }

    public void setPaymentGatewayNote(String paymentGatewayNote) {
        this.paymentGatewayNote = paymentGatewayNote;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
