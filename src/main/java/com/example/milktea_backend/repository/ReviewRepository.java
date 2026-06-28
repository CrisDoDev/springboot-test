package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // Chỉ lấy các review công khai (status = 1) của sản phẩm này
    List<Review> findByProductIdAndStatusOrderByCreatedAtDesc(int productId, byte status);
}