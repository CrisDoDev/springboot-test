package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Tìm sản phẩm theo danh mục và trạng thái hoạt động
    List<Product> findByCategoryIdAndStatusAndIsDeleted(int categoryId, byte status, byte isDeleted);

    // SQL tính số sao trung bình của sản phẩm công khai (status = 1)
    @Query(value = "SELECT COALESCE(AVG(rating_stars), 5.0) FROM reviews " +
            "WHERE product_id = :productId AND status = 1", nativeQuery = true)
    Double findAverageRatingByProductId(@Param("productId") int productId);

    // SQL quét chiến dịch giảm giá: Tìm số tiền giảm của sản phẩm
    // thỏa mãn điều kiện chiến dịch đang kích hoạt (status=1) và trong thời gian hiệu lực
    @Query(value = "SELECT ci.discount_value FROM campaign_items ci " +
            "JOIN product_campaigns pc ON ci.campaign_id = pc.id_campaign " +
            "WHERE ci.product_id = :productId " +
            "AND pc.status = 1 AND pc.is_deleted = 0 " +
            "AND NOW() BETWEEN pc.start_date AND pc.end_date LIMIT 1", nativeQuery = true)
    Double findActiveDiscountByProductId(@Param("productId") int productId);




}