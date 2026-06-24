package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Nguyễn Tuấn Kiệt
     * Tính tổng doanh thu của các đơn hàng đã hoàn thành (COMPLETED) trong ngày hôm nay
     * Dùng cho trang chủ Admin.
     * @return
     */
    @Query(value = "SELECT COALESCE(SUM(final_total), 0) FROM orders " +
            "WHERE DATE(created_at) = CURDATE() AND order_status = 'COMPLETED'",
            nativeQuery = true)
    Double calculateTodayRevenue();

    /**
     * Nguyẽn Tuấn Kiệt
     * Đếm số lượng đơn hàng mới vừa đặt (ORDERED) đang chờ xử lý trong ngày hôm nay
     * Dùng cho trang chủ Admin.
     * @return
     */
    @Query(value = "SELECT COUNT(*) FROM orders " +
            "WHERE DATE(created_at) = CURDATE() AND order_status = 'ORDERED'",
            nativeQuery = true)
    Long countTodayNewOrders();
}