package com.example.milktea_backend.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cart_item_toppings")
@IdClass(CartItemToppingId.class)
public class CartItemTopping {
    @Id
    @Column(name = "cart_item_id")
    private int cartItemId;

    @Id
    @Column(name = "topping_id")
    private int toppingId;

    public CartItemTopping(){}
    public CartItemTopping(int cartItemId, int toppingId) {
        this.cartItemId = cartItemId;
        this.toppingId = toppingId;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }
}
class CartItemToppingId implements Serializable {
    private int cartItemId;
    private int toppingId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemToppingId that = (CartItemToppingId) o;
        return cartItemId == that.cartItemId && toppingId == that.toppingId;
    }

    @Override
    public int hashCode() { return Objects.hash(cartItemId, toppingId); }
}