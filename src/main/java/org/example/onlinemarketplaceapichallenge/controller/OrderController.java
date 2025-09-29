package org.example.onlinemarketplaceapichallenge.controller;

import org.example.onlinemarketplaceapichallenge.dto.OrderDto;
import org.example.onlinemarketplaceapichallenge.dto.OrderResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Orders;
import org.example.onlinemarketplaceapichallenge.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getOrders")
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getOrders();
    }
    @PostMapping("/createOrder")
    public OrderResponseDto createOrder(OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }
    @PutMapping("/updateOrder/{id}")
    public OrderResponseDto updateOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id,orderDto);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        var errors=new HashMap<String,String>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            var fieldName= ((FieldError) error).getField();
            var errorMsg=error.getDefaultMessage();
            errors.put(fieldName,errorMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
