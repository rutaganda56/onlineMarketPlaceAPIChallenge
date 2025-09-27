package org.example.onlinemarketplaceapichallenge.controller;

import org.example.onlinemarketplaceapichallenge.Dto.ReviewDto;
import org.example.onlinemarketplaceapichallenge.Dto.ReviewResponseDto;
import org.example.onlinemarketplaceapichallenge.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/getAllReviews")
    public List<ReviewResponseDto> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @PostMapping("/createReview")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponseDto AddReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable("id") int id) {
        reviewService.deleteReview(id);
    }
}
