package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
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
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @JsonBackReference("categories-products")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    @JsonBackReference("stores-products")
    private Store store;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference("products-orders")
    private List<Orders> order;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference("reviews-products")
    private List<Review> review;



}
