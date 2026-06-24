package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    /**
     * Nguyễn Tuấn Kiệt
     * Dùng cho trang chủ Khách hàng.
     * @param isDeleted
     * @return
     */
    List<Category> findByIsDeleted(byte isDeleted);
}