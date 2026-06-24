package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    /**
     * Nguyễn Tuấn Kiệt
     * Dùng cho Thêm Sản phẩm (Quản lý Sản Phẩm)
     * @param isDeleted
     * @return
     */
    List<Topping> findByIsDeleted(byte isDeleted);
}