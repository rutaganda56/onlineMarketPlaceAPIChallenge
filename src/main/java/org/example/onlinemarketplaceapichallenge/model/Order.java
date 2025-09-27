package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    private int quantity;
    private long price;
    private String shippingMethod;
    private Date orderDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;



}
