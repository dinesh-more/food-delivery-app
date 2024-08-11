package com.more.restaurants_listing.controller;

import com.more.restaurants_listing.dto.RestaurantDTO;
import com.more.restaurants_listing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> findAllRestaurants() {
        List<RestaurantDTO> restaurantDTOList = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantDTO> addResturant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO addedResturant = restaurantService.addResturant(restaurantDTO);
        return new ResponseEntity<>(addedResturant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> findResturantById(@PathVariable Integer id) {
        return restaurantService.findResturantById(id);
    }
}
