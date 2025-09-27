package org.example.onlinemarketplaceapichallenge.service;

import org.example.onlinemarketplaceapichallenge.dto.ReviewDto;
import org.example.onlinemarketplaceapichallenge.dto.ReviewResponseDto;
import org.example.onlinemarketplaceapichallenge.mapper.ReviewMapper;
import org.example.onlinemarketplaceapichallenge.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepo;
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
    public void deleteReview(int reviewId) {
        reviewRepo.deleteById(reviewId);
    }

}
