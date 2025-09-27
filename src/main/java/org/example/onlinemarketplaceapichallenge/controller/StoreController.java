package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.example.onlinemarketplaceapichallenge.Dto.StoreDto;
import org.example.onlinemarketplaceapichallenge.Dto.StoreResponseDto;
import org.example.onlinemarketplaceapichallenge.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/getStores")
    public List<StoreResponseDto> getStores() {
        return storeService.getAllStores();
    }
    @PostMapping("/createStore")
    @ResponseStatus(HttpStatus.CREATED)
    public StoreResponseDto createStore(@Valid @RequestBody StoreDto storeDto) {
        return storeService.createStore(storeDto);
    }
    @DeleteMapping("/deleteStore/{id}")
    public void deleteStore(@PathVariable("id") int id) {
        storeService.deleteStore(id);
    }
}
