package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Kiểm tra xem User này đã có giỏ hàng tổng chưa
    boolean existsByUserId(int userId);
}