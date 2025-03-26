package org.example.ikm.controllers;

import jakarta.validation.Valid;
import org.example.ikm.models.Products;
import org.example.ikm.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products/listProducts";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productsService.findById(id).orElse(new Products()));
        return "products/formProducts";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Products());
        return "products/formProducts";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute Products product) {
        productsService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productsService.delete(id);
        return "redirect:/products/list";
    }
}