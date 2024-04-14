package com.sing3demons.products_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sing3demons.products_backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
