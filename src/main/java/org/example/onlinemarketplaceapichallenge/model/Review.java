package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    @Column(name="REVIEW_ID")
    private int id;
    private int rating;
    private String comment;

}
