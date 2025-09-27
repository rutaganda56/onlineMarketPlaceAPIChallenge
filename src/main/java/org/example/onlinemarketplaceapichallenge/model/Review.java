package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Review {
    @Id
    @GeneratedValue
    @Column(name="REVIEW_ID")
    private int id;
    private int rating;
    private String comment;
    @OneToOne
    private Users user;
    @OneToOne
    private Product product;


}
