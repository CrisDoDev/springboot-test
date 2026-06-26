package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Kiểm tra tồn tại email dưới MySQL để phục vụ Real-time check
    boolean existsByEmail(String email);

    // Kiểm tra tồn tại số điện thoại dưới MySQL để phục vụ Real-time check
    boolean existsByPhoneNumber(String phoneNumber);

    // Tìm kiếm User theo mã định danh Firebase UID duy nhất
    Optional<User> findByFirebaseUid(String firebaseUid);
}