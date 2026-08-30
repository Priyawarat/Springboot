package com.priye.jpa.repository;

import com.priye.jpa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Normal Sorting
    List<Product> findByNameOrderByPrice(String name);
    List<Product> findByOrderByPrice();

    //Using Sorting class Object
    List<Product> findBy(Sort sort);

    //Pagiantion
    Page<Product> findAll(Pageable pageable);
//    List<Product> findByName(String name,  Pageable pageable, Sort sort);
    List<Product> findByName(String name,  Pageable pageable);
    List<Product> findByNameContainingIgnoreCase(String name,  Pageable pageable);

}
