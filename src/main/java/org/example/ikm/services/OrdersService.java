package org.example.ikm.services;

import org.example.ikm.models.Orders;
import org.example.ikm.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    public void save(Orders order) {
        ordersRepository.save(order);
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}