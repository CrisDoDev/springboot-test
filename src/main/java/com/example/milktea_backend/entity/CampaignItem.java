package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "campaign_items")
@IdClass(CampaignItemId.class)
public class CampaignItem {
    @Id
    @Column(name = "campaign_id")
    private int campaignId;

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "discount_value", nullable = false)
    private double discountValue;

    public CampaignItem(){}
    public CampaignItem(int campaignId, int productId, double discountValue) {
        this.campaignId = campaignId;
        this.productId = productId;
        this.discountValue = discountValue;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }
}
class CampaignItemId implements Serializable {
    private int campaignId;
    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CampaignItemId that = (CampaignItemId) o;
        return campaignId == that.campaignId && productId == that.productId;
    }

    @Override
    public int hashCode() { return Objects.hash(campaignId, productId); }
}
