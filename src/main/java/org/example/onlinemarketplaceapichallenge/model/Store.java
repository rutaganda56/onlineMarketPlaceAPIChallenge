package org.example.onlinemarketplaceapichallenge.model;

import jakarta.persistence.*;

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
    private Date creationDate;
    @OneToOne()
    private Users user;
    @OneToMany
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
