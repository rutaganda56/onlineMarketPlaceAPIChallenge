package org.example.onlinemarketplaceapichallenge.mapper;

import org.example.onlinemarketplaceapichallenge.dto.ReviewDto;
import org.example.onlinemarketplaceapichallenge.dto.ReviewResponseDto;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Review;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.springframework.stereotype.Service;

@Service
public class ReviewMapper {
    public Review transformToDto(ReviewDto dto){
        Review review = new Review();
        review.setRating(dto.rating());
        review.setComment(dto.comment());
        Users user = new Users();
        user.setId(dto.userId());
        review.setUser(user);
        Product product = new Product();
        product.setId(dto.productId());
        review.setProduct(product);
        return review;
    }
    public ReviewResponseDto transformToResponseDto(Review review){
        return new ReviewResponseDto(review.getRating(), review.getComment());
    }
}
