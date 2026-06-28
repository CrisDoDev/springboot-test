package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Product;
import com.example.milktea_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        List<Product> products = productRepository.findByStatusAndIsDeleted((byte) 1, (byte) 0);
        for (Product p : products) {
            enrichProductData(p);
        }
        return products;
    }
    /**
     *API lấy danh sách sản phẩm lọc theo mã Danh mục
     *
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
        List<Product> products = productRepository.findByCategoryIdAndStatusAndIsDeleted(categoryId, (byte) 1, (byte) 0);
        for (Product p : products) {
            enrichProductData(p); // Đắp sao trung bình và giá giảm vào
        }
        return ResponseEntity.ok(products);
    }

    /**
     * API lấy chi tiết thông tin của 1 sản phẩm cụ thể
     *
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) {
        return productRepository.findById(productId)
                .map(product -> {
                    enrichProductData(product);
                    return ResponseEntity.ok(product);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Hàm phụ trợ dùng chung để tính toán data khuyến mãi và review
    private void enrichProductData(Product product) {
        // 1. Tính toán điểm sao trung bình
        Double avgStars = productRepository.findAverageRatingByProductId(product.getIdProduct());
        product.setRatingStars(avgStars != null ? Math.round(avgStars * 10) / 10.0 : 5.0);

        // 2. Tính giá tiền sau giảm giá
        Double discount = productRepository.findActiveDiscountByProductId(product.getIdProduct());
        if (discount != null && discount > 0) {
            product.setFinalPrice(product.getBasePrice() - discount);
        } else {
            product.setFinalPrice(product.getBasePrice()); // Không giảm thì giá cuối bằng giá gốc
        }
    }
}