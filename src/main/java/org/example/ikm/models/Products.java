package org.example.ikm.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price; // ? Тип данных

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Orders> orders;
}