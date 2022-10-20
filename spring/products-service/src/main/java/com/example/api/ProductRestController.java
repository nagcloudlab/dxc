package com.example.api;

import com.example.entity.Product;
import com.example.entity.Review;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin(origins ="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/products")
public class ProductRestController {

    private final ProductRepository productRepository;

    @GetMapping
    public Flux<Product> getProduct(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}/reviews")
    public Flux<Review> getReviews(Long id){
        Review[] reviews = {
                new Review("1","Nag",5,"good one")
        };
        return  Flux.fromArray(reviews);
    }


}
