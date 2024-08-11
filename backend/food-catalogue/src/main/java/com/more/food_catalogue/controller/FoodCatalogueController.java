package com.more.food_catalogue.controller;

import com.more.food_catalogue.dto.FoodCataloguePage;
import com.more.food_catalogue.dto.FoodItemDTO;
import com.more.food_catalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/foodcatalogue")
public class FoodCatalogueController {

    private FoodCatalogueService foodCatalogueService;

    @Autowired
    public FoodCatalogueController(FoodCatalogueService foodCatalogueService) {
        this.foodCatalogueService = foodCatalogueService;
    }

    @PostMapping
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO savedFoodItem = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/{resturantId}")
    public ResponseEntity<FoodCataloguePage> fetchResturantDetailsWithFoodMenu(@PathVariable Integer resturantId) {
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchResturantDetailsWithFoodMenu(resturantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
