package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "STORE_ID")
    private int storeId;
    @Column(name = "STORE_NAME")
    private String storeName;
    @Column(name = "STORE_ADDRESS")
    private String storeAddress;
    @Column(name = "CONTACT_NUMBER")
    private String contact;
    @Column(name = "CREATION_DATE")
    @CreationTimestamp
    private LocalDateTime creationDate;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private Users user;
    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;

}
