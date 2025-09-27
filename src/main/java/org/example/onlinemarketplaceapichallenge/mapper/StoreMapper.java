package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.StoreDto;
import org.example.onlinemarketplaceapichallenge.Dto.StoreResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Store;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.stereotype.Service;

@Service
public class StoreMapper {
    public Store transformToDto(StoreDto dto) {
        Store store = new Store();
        store.setStoreName(dto.storeName());
        store.setStoreAddress(dto.storeAddress());
        store.setContact(dto.Contact());
        Users user = new Users();
        user.setId(dto.userId());
        store.setUser(user);
        return store;
    }
    public StoreResponseDto transformToResponseDto(Store store) {
        return new StoreResponseDto(store.getStoreName());
    }
}
