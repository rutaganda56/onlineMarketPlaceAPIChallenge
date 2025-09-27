package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "full_name")
    private String fullName;
    private String username;
    private String password;
    @Column(name = "USER_ROLE")
    private String role;
    private String email;
    @Column(name = "phone_number")
    private String phone;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Store store;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> order;
    @OneToMany(mappedBy = "user")
    private List<Review> review;

}
