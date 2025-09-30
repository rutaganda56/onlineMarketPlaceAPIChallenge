package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.validation.Valid;
import org.example.onlinemarketplaceapichallenge.dto.StoreDto;
import org.example.onlinemarketplaceapichallenge.dto.StoreResponseDto;
import org.example.onlinemarketplaceapichallenge.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("api/store/stores")
    public List<StoreResponseDto> getStores() {
        return storeService.getAllStores();
    }
    @PostMapping("api/store/createStore")
    @ResponseStatus(HttpStatus.CREATED)
    public StoreResponseDto createStore(@Valid @RequestBody StoreDto storeDto) {
        return storeService.createStore(storeDto);
    }
    @PutMapping("api/store/{id}")
    public StoreResponseDto updateStore(@PathVariable int id, @Valid @RequestBody StoreDto storeDto) {
        return storeService.updateStore(id,storeDto);
    }
    @DeleteMapping("api/store/deleteStore/{id}")
    public void deleteStore(@PathVariable("id") int id) {
        storeService.deleteStore(id);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
