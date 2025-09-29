package org.example.onlinemarketplaceapichallenge.service;

import jakarta.validation.Valid;
import org.example.onlinemarketplaceapichallenge.dto.StoreDto;
import org.example.onlinemarketplaceapichallenge.dto.StoreResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.StoreMapper;
import org.example.onlinemarketplaceapichallenge.model.Store;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.repository.StoreRepository;
import org.example.onlinemarketplaceapichallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private StoreMapper storeMapper;

    public List<StoreResponseDto> getAllStores() {
        return storeRepo.findAll().stream().map(storeMapper::transformToResponseDto).collect(Collectors.toList());
    }
    public StoreResponseDto createStore(StoreDto storeDto) {
        var store=storeMapper.transformToDto(storeDto);
        var savedStore=storeRepo.save(store);
        return storeMapper.transformToResponseDto(savedStore);
    }
    public void deleteStore(int storeId) {
        storeRepo.deleteById(storeId);
    }

    public StoreResponseDto updateStore(int id, StoreDto storeDto) {
        var savedStore=storeRepo.findById(id).orElse(new Store());
        savedStore.setStoreName(storeDto.storeName());
        savedStore.setStoreAddress(storeDto.storeAddress());
        savedStore.setContact(storeDto.contact());
        Users user=userRepo.findById(storeDto.userId()).orElse(new Users());
        savedStore.setUser(user);
        var updatedStore=storeRepo.save(savedStore);
        return storeMapper.transformToResponseDto(updatedStore);


    }
}
