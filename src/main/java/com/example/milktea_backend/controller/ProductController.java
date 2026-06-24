package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Product;
import com.example.milktea_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Nguyễn Tuấn Kiệt
     * lấy các sản phẩm bán chạy nhất.
     * Dùng cho trang chủ Khách hàng.
     * @return
     */
    @GetMapping("/bestsellers")
    public List<Product> getBestSellerProducts() {
        return productRepository.findByStatusAndIsDeleted((byte) 1, (byte) 0);
    }
}