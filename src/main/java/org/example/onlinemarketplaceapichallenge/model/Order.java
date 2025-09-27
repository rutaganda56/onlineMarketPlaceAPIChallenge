package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
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
    private Users user;
    @OneToMany
    private List<Product> product;



}
