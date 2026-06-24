package com.example.milktea_backend.repository;

import com.example.milktea_backend.entity.ProductTopping;
import com.example.milktea_backend.entity.ProductToppingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToppingRepository extends JpaRepository<ProductTopping, ProductToppingId> {

}