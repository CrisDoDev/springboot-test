package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Review;
import com.example.milktea_backend.repository.ReviewRepository;
import com.example.milktea_backend.repository.UserRepository; // ĐÃ THÊM: Để tra cứu tên người dùng
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Lấy toàn bộ bình luận sạch của sản phẩm kèm Tên Thật của khách hàng
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProduct(@PathVariable("productId") int productId) {
        List<Review> activeReviews = reviewRepository.findByProductIdAndStatusOrderByCreatedAtDesc(productId, (byte) 1);
        for (Review r : activeReviews) {
            userRepository.findById(r.getUserId()).ifPresent(user -> {
                r.setUserName(user.getFullName()); // Đắp họ tên thật từ bảng users vào
            });

            if (r.getUserName() == null || r.getUserName().trim().isEmpty()) {
                r.setUserName("Khách hàng Oasis");
            }
        }

        return ResponseEntity.ok(activeReviews);
    }
}