package com.criticaster.reviewer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @GetMapping
    public ResponseEntity<String> getRestaurants() {
        return ResponseEntity.ok("Список ресторанов");
    }

    @PreAuthorize("hasRole('ROLE_OWNER')")
    @PostMapping
    public ResponseEntity<String> getRestaurantForOwner() {
        return ResponseEntity.ok("Страница ресторанов для владельцев");
    }

    /*@PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping
    public ResponseEntity<String> getRestaurantForCustomer() {
        return ResponseEntity.ok("Страница ресторанов для клиентов");
    }*/

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/reviews")
    public ResponseEntity<String> getReviews() {
        return ResponseEntity.ok("Отзывы доступны только авторизованным пользователям");
    }
}
