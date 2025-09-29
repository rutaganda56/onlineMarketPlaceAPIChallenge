package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.ReviewDto;
import org.example.onlinemarketplaceapichallenge.dto.ReviewResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.ReviewMapper;
import org.example.onlinemarketplaceapichallenge.model.Product;
import org.example.onlinemarketplaceapichallenge.model.Users;
import org.example.onlinemarketplaceapichallenge.repository.ProductRepository;
import org.example.onlinemarketplaceapichallenge.repository.ReviewRepository;
import org.example.onlinemarketplaceapichallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ReviewMapper reviewMapper;

    public ReviewResponseDto addReview(ReviewDto reviewDto) {
        var review = reviewMapper.transformToDto(reviewDto);
        var savedReview=reviewRepo.save(review);
        return reviewMapper.transformToResponseDto(savedReview);
    }
    public List<ReviewResponseDto> getAllReviews() {
        return reviewRepo.findAll().stream().map(reviewMapper::transformToResponseDto).collect(Collectors.toList());
    }
    public ReviewResponseDto updateReview(int id, ReviewDto reviewDto) {
        var existingReview = reviewRepo.findById(id).orElse(null);
        Users user = userRepo.findById(id).orElse(null);
        assert user != null;
        user.setId(reviewDto.userId());
        Product product = productRepo.findById(reviewDto.productId()).orElse(null);
        assert product != null;
        product.setId(reviewDto.productId());
        assert existingReview != null;
        existingReview.setRating(reviewDto.rating());
        existingReview.setComment(reviewDto.comment());
        existingReview.setUser(user);
        existingReview.setProduct(product);
        var updatedReview=reviewRepo.save(existingReview);
        return reviewMapper.transformToResponseDto(updatedReview);




    }
    public void deleteReview(int reviewId) {
        reviewRepo.deleteById(reviewId);
    }

}
