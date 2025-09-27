package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.Dto.StoreDto;
import org.example.onlinemarketplaceapichallenge.Dto.StoreResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.StoreMapper;
import org.example.onlinemarketplaceapichallenge.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepo;
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

}
