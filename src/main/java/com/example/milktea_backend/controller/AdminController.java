package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Product;
import com.example.milktea_backend.entity.ProductTopping;
import com.example.milktea_backend.entity.Topping;
import com.example.milktea_backend.repository.ProductRepository;
import com.example.milktea_backend.repository.OrderRepository;
import com.example.milktea_backend.repository.ToppingRepository;
import com.example.milktea_backend.repository.ProductToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private ProductToppingRepository productToppingRepository;

    /**
     * Nguyễn Tuấn Kiệt
     * Thực hiện lấy phân tích doanh thu.
     * Dùng cho trang chủ Admin
     * @return
     */
    @GetMapping("/dashboard/analytics")
    public ResponseEntity<Map<String, Object>> getAdminAnalytics() {
        Map<String, Object> analyticsData = new HashMap<>();
        Double todayRevenue = orderRepository.calculateTodayRevenue();
        Long newOrders = orderRepository.countTodayNewOrders();
        double dailyTarget = 3000000.0;
        double progress = (todayRevenue / dailyTarget) * 100;
        if (progress > 100.0) {
            progress = 100.0;
        }
        analyticsData.put("todayRevenue", todayRevenue);
        analyticsData.put("newOrders", newOrders.doubleValue());
        analyticsData.put("progress", progress);

        return ResponseEntity.ok(analyticsData);
    }

    /**
     * Nguyễn Tuấn Kiệt
     * lấy tất cả sản phẩm (thức uống) mà không bị xóa ở trang Admin.
     * Dùng cho trang Quản lý Sản phẩm
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAdminAllProducts() {
        return ResponseEntity.ok(productRepository.findByIsDeleted((byte) 0));
    }

    /**
     * Nguyễn Tuấn Kiệt
     * cập nhật trạng thái cho một sản phẩm (on/off cho Admin).
     * Dùng cho trang Quản lý Sản phẩm.
     * @param productId
     * @param status
     * @return
     */
    @PutMapping("/products/{id}/status")
    public ResponseEntity<Void> updateProductStatus(@PathVariable("id") int productId, @RequestParam("status") byte status) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setStatus(status);
            productRepository.save(product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Nguyễn Tuấn Kiệt
     * lấy tất cả topping đang có.
     * Dùng cho Thêm Sản phẩm (Quản lý Sản phẩm)
     * @return
     */
    @GetMapping("/toppings")
    public ResponseEntity<List<Topping>> getActiveToppings() {
        List<Topping> toppings = toppingRepository.findByIsDeleted((byte) 0);
        return ResponseEntity.ok(toppings);
    }

    /**
     * Nguyễn Tuấn Kiệt
     * Thêm nhiều sản phẩm một lần.
     * Dùng cho Thêm Sản Phẩm (Quản lý Sản phẩm)
     * @param request
     * @return
     */
    @PostMapping("/products/bulk")
    public ResponseEntity<String> addBulkProducts(@RequestBody com.example.milktea_backend.dto.AdminBulkProductRequest request) {
        try {
            List<Product> productsToSave = request.getProducts();
            int categoryId = request.getCategoryId();
            List<Integer> toppingIds = request.getToppingIds();
            if (productsToSave == null || productsToSave.isEmpty()) {
                return ResponseEntity.badRequest().body("Danh sách sản phẩm trống!");
            }
            for (Product product : productsToSave) {
                product.setCategoryId(categoryId);
                product.setStatus((byte) 1);
                product.setIsDeleted((byte) 0);
                product.setCreatedAt(LocalDateTime.now());
                product.setUpdatedAt(LocalDateTime.now());
                Product savedProduct = productRepository.save(product);
                if (toppingIds != null && !toppingIds.isEmpty()) {
                    for (Integer toppingId : toppingIds) {
                        ProductTopping pt = new ProductTopping(savedProduct.getIdProduct(), toppingId);
                        productToppingRepository.save(pt);
                    }
                }
            }
            return ResponseEntity.ok("Đã thêm thành công " + productsToSave.size() + " món ăn vào hệ thống!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi hệ thống khi thêm sản phẩm: " + e.getMessage());
        }
    }

}