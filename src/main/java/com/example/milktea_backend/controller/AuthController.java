package com.example.milktea_backend.controller;

import com.example.milktea_backend.entity.Cart;
import com.example.milktea_backend.entity.User;
import com.example.milktea_backend.dto.CheckResponse;
import com.example.milktea_backend.repository.CartRepository;
import com.example.milktea_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Cho phép ứng dụng Android kết nối không bị chặn
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    /**
     * API kiểm tra trùng Email thời gian thực
     * Android gọi hàm này khi người dùng đang gõ ký tự ở ô nhập Email
     */
    @GetMapping("/check-email")
    public ResponseEntity<CheckResponse> checkEmail(@RequestParam("email") String email) {
        boolean isDuplicate = userRepository.existsByEmail(email);
        return ResponseEntity.ok(new CheckResponse(isDuplicate));
    }
    /**
     * API kiểm tra trùng Số điện thoại thời gian thực
     * Android gọi hàm này khi người dùng đang gõ ký tự ở ô nhập SĐT
     */
    @GetMapping("/check-phone")
    public ResponseEntity<CheckResponse> checkPhone(@RequestParam("phone") String phone) {
        boolean isDuplicate = userRepository.existsByPhoneNumber(phone);
        return ResponseEntity.ok(new CheckResponse(isDuplicate));
    }

    /**
     * API Đồng bộ và Khởi tạo Tài khoản người dùng từ Firebase về MySQL
     * Xử lý cả 2 trường hợp: Đăng ký mới & Đăng nhập lại (Email hoặc Google Sign-In)
     */
    @PostMapping("/sync-user")
    public ResponseEntity<User> syncUser(@RequestBody User requestUser) {
        if (requestUser.getFirebaseUid() == null || requestUser.getFirebaseUid().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // 1. Kiểm tra xem người dùng này đã từng tồn tại trong MySQL chưa dựa vào firebase_uid
        Optional<User> existingUserOpt = userRepository.findByFirebaseUid(requestUser.getFirebaseUid());

        if (existingUserOpt.isPresent()) {
            // Trường hợp ĐĂNG NHẬP LẠI: Trả về thông tin cũ có sẵn kèm id_user
            return ResponseEntity.ok(existingUserOpt.get());
        }

        // 2. Trường hợp ĐĂNG KÝ MỚI hoàn toàn: Tiến hành ghi nhận vào DB
        User newUser = new User();
        newUser.setFirebaseUid(requestUser.getFirebaseUid());
        newUser.setFullName(requestUser.getFullName());
        newUser.setEmail(requestUser.getEmail());
        newUser.setPhoneNumber(requestUser.getPhoneNumber());
        newUser.setAvatarUrl(requestUser.getAvatarUrl() != null ? requestUser.getAvatarUrl() : "");

        // Áp dụng quy tắc cố định: Mặc định tài khoản mới tạo từ App là CUSTOMER (role_id = 2)
        newUser.setRoleId(2);
        newUser.setStatus((byte) 1); // 1: Tài khoản đang hoạt động bình thường
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        // Thực thi lưu Người dùng để lấy được id_user tự động tăng (Auto Increment)
        User savedUser = userRepository.save(newUser);

        // 3.Tự động mở sẵn một Giỏ hàng trống trong MySQL cho User mới này
        if (!cartRepository.existsByUserId(savedUser.getIdUser())) {
            Cart newCart = new Cart();
            newCart.setUserId(savedUser.getIdUser());
            newCart.setUpdatedAt(LocalDateTime.now());
            cartRepository.save(newCart);
        }

        // Trả về đối tượng User hoàn chỉnh kèm id_user mới sinh về cho Android lưu vào DataStore
        return ResponseEntity.ok(savedUser);
    }
}