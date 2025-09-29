package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.OrderDto;
import org.example.onlinemarketplaceapichallenge.dto.OrderResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.OrderMapper;
import org.example.onlinemarketplaceapichallenge.model.Orders;
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


    public OrderResponseDto updateOrder(int id, OrderDto orderDto) {
        var existingOrder=orderRepo.findById(id).orElse(new Orders());
        existingOrder.setQuantity(orderDto.quantity());
        existingOrder.setPrice(orderDto.price());
        existingOrder.setShippingMethod(orderDto.shippingMethod());
        existingOrder.setStatus(orderDto.status());
        Orders updatedOrder=orderRepo.save(existingOrder);

        return new OrderResponseDto(updatedOrder.getOrderId(), updatedOrder.getStatus());
    }
}
