package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int id;
    @Column(name = "CATEGORY_NAME")
    private String name;
    @OneToMany
    private List<Product> products;
}
