package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Nguyễn Tuấn Kiệt
     * Dùng cho trang chủ Khách hàng.
     * @param status
     * @param isDeleted
     * @return
     */
    List<Product> findByStatusAndIsDeleted(byte status, byte isDeleted);

    /**
     * Nguyễn Tuấn Kiệt
     * Dùng cho trang chủ Admin
     * @param isDeleted
     * @return
     */
    List<Product> findByIsDeleted(byte isDeleted);
}