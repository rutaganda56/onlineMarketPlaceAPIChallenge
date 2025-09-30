package org.example.onlinemarketplaceapichallenge.controller;

import jakarta.validation.Valid;
import org.example.onlinemarketplaceapichallenge.dto.ReviewDto;
import org.example.onlinemarketplaceapichallenge.dto.ReviewResponseDto;
import org.example.onlinemarketplaceapichallenge.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("api/review/reviews")
    public List<ReviewResponseDto> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @PostMapping("api/review/createReview")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponseDto AddReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }
    @PutMapping("api/review/{id}")
    public ReviewResponseDto updateReview(@PathVariable("id") int id,@Valid @RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(id, reviewDto);
    }
    @DeleteMapping("api/review/deleteReview/{id}")
    public void deleteReview(@PathVariable("id") int id) {
        reviewService.deleteReview(id);
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
