package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.Dto.OrderDto;
import org.example.onlinemarketplaceapichallenge.Dto.OrderResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Orders;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Orders transformToDto(OrderDto dto) {
        Orders order = new Orders();
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
    public OrderResponseDto transformToResponseDto(Orders order) {
        return new OrderResponseDto(order.getOrderId(), order.getStatus());
    }
}
