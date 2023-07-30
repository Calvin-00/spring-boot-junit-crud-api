package com.springBoot.junitcrud.repository;

import com.springBoot.junitcrud.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {
}
