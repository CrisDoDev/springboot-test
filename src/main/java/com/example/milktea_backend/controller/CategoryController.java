package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Category;
import com.example.milktea_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Nguyễn Tuấn Kiệt
     * lấy danh mục đang có.
     * Dùng cho trang chủ Khách hàng.
     * @return
     */
    @GetMapping
    public List<Category> getActiveCategories() {
        return categoryRepository.findByIsDeleted((byte) 0);
    }
}