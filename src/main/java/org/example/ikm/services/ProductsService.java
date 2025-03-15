package org.example.ikm.services;

import org.example.ikm.models.Products;
import org.example.ikm.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id);
    }

    public void save(Products products) {
        productsRepository.save(products);
    }

    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}