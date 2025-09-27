package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private int id;
    @Column(name = "CATEGORY_NAME")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Product products;
}
