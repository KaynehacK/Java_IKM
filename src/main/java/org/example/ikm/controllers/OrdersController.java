package org.example.ikm.controllers;

import org.example.ikm.models.*;
import org.example.ikm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/list")
    public String listOrders(Model model) {
        model.addAttribute("orders", ordersService.findAll());
        return "orders/listOrders";
    }

    @GetMapping("/new")
    public String newOrder(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("products", productsService.findAll());
        return "orders/formOrders";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", ordersService.findById(id).orElse(new Orders()));
        model.addAttribute("users", usersService.findAll());
        model.addAttribute("products", productsService.findAll());
        return "orders/formOrders";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Orders order) {
        ordersService.save(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        ordersService.delete(id);
        return "redirect:/orders/list";
    }
}