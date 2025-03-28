package org.example.ikm.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(name = "quantity", nullable = false)
    @Min(1)
    private Integer quantity;

    public void setQuantity(BigDecimal extended_quantity) {
        this.quantity = extended_quantity.intValue();
    }

    public BigDecimal getQuantity() {
        if (this.quantity == null) { return new BigDecimal(1); }
        return BigDecimal.valueOf(this.quantity);
    }
}