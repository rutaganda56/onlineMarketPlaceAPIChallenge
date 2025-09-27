package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;


}
