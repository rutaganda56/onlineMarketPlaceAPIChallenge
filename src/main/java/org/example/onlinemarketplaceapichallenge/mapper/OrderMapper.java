package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.OrderDto;
import org.example.onlinemarketplaceapichallenge.Dto.OrderResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Order;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order transformToDto(OrderDto dto) {
        Order order = new Order();
        order.setQuantity(dto.quantity());
        order.setPrice(dto.price());
        order.setShippingMethod(dto.shippingMethod());
        order.setStatus(dto.status());
        Users user = new Users();
        user.setId(dto.userId());
        Product product = new Product();
        product.setId(dto.productId());
        order.setUser(user);
        order.setProduct(product);
        return order;
    }
    public OrderResponseDto transformToResponseDto(Order order) {
        return new OrderResponseDto(order.getOrderId(), order.getStatus());
    }
}
