package com.more.order_service.entity;

import com.more.order_service.dto.FoodItemDTO;
import com.more.order_service.dto.Restaurant;
import com.more.order_service.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {

    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private Restaurant restaurantDetails;
    private UserDTO userDetails;
}
