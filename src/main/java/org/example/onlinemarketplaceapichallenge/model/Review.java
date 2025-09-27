package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue
    @Column(name="REVIEW_ID")
    private int id;
    private int rating;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("users-reviews")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference("reviews-products")
    private Product product;


}
