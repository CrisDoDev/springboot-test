package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Transient
    private String userName;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "rating_stars", nullable = false)
    private int ratingStars;

    @Column(name = "admin_reply", columnDefinition = "TEXT")
    private String adminReply;

    @Column(name = "replied_at")
    private LocalDateTime repliedAt;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "status")
    private byte status = 1;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Review(){}
    public Review(int idReview, int userId, int productId, int orderId, int ratingStars, String adminReply, LocalDateTime repliedAt, String comment, byte status, LocalDateTime createdAt) {
        this.idReview = idReview;
        this.userId = userId;
        this.productId = productId;
        this.orderId = orderId;
        this.ratingStars = ratingStars;
        this.adminReply = adminReply;
        this.repliedAt = repliedAt;
        this.comment = comment;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getAdminReply() {
        return adminReply;
    }

    public void setAdminReply(String adminReply) {
        this.adminReply = adminReply;
    }

    public LocalDateTime getRepliedAt() {
        return repliedAt;
    }

    public void setRepliedAt(LocalDateTime repliedAt) {
        this.repliedAt = repliedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
