package org.example.onlinemarketplaceapichallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
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

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public Store() {
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", contact='" + contact + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
