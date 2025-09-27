package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private int id;
    @Column(name = "PRODUCT_NAME")
    private String name;
    @Column(name = "PRODUCT_PRICE")
    private String price;
    @Column(name = "STATUS")
    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;



}
