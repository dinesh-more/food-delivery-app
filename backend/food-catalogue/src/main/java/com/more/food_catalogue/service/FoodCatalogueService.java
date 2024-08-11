package com.more.food_catalogue.service;

import com.more.food_catalogue.dto.FoodCataloguePage;
import com.more.food_catalogue.dto.FoodItemDTO;
import com.more.food_catalogue.dto.Restaurant;
import com.more.food_catalogue.entity.FoodItem;
import com.more.food_catalogue.mapper.FoodItemMapper;
import com.more.food_catalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    private final FoodItemRepository foodItemRepository;
    private final RestClient restClient;
    private final RestTemplate restTemplate;

    @Autowired
    public FoodCatalogueService(FoodItemRepository foodItemRepository, RestClient restClient, RestTemplate restTemplate) {
        this.foodItemRepository = foodItemRepository;
        this.restClient = restClient;
        this.restTemplate = restTemplate;
    }


    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(savedFoodItem);
    }

    public FoodCataloguePage fetchResturantDetailsWithFoodMenu(Integer resturantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(resturantId);
        Restaurant restaurant = fetchResturantDetails(resturantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private List<FoodItem> fetchFoodItemList(Integer resturantId) {
        return foodItemRepository.findByResturantId(resturantId);
    }

    /*private Restaurant fetchResturantDetails(Integer resturantId) {
        return restClient
                .get()
                .uri("http://RESTAURANT-SERVICE/restaurant/{resturantId}", resturantId)
                .retrieve()
                .body(Restaurant.class);
    }*/

    private Restaurant fetchResturantDetails(Integer resturantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/"+resturantId, Restaurant.class);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        return new FoodCataloguePage(foodItemList, restaurant);
    }
}
