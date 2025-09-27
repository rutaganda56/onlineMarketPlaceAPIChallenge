package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.Dto.OrderDto;
import org.example.onlinemarketplaceapichallenge.Dto.OrderResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.OrderMapper;
import org.example.onlinemarketplaceapichallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private OrderMapper orderMapper;

    public List<OrderResponseDto> getOrders() {
        return orderRepo.findAll().stream().map(orderMapper::transformToResponseDto).collect(Collectors.toList());
    }
    public OrderResponseDto createOrder(OrderDto orderDto) {
        var order=orderMapper.transformToDto(orderDto);
        var savedOrder=orderRepo.save(order);
        return orderMapper.transformToResponseDto(savedOrder);
    }
    public void deleteOrder(int orderId) {
        orderRepo.deleteById(orderId);
    }


}
