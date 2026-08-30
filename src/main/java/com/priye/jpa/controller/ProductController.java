package com.priye.jpa.controller;

import com.priye.jpa.entity.Product;
import com.priye.jpa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false,defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "5") int size)
    {
//        return productRepository.findByNameOrderByPrice("Tablet");
//        return productRepository.findAllOrderByPrice();
//        return productRepository.findByOrderByPrice();
//        return productRepository.findBy(Sort.by(sortBy));
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//        return productRepository.findBy(Sort.by(Sort.Order.by(sortBy)));
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy), // Sort by the specified field in descending order
//                Sort.Order.asc("name") // Sort by name in ascending order as a secondary sort
//        ));
//        Pageable pageable = PageRequest.of(page, size);
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return productRepository.findAll(pageable); // return page object and all page information like total pages,
//        total elements, etc. but we need only content of page
//        return productRepository.findAll(pageable).getContent(); //need to return only content of page not page object

        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByName("Tablet", pageable);
    }

}
