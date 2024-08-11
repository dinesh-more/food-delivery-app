package com.more.food_catalogue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private String itemDescription;
    private Boolean isVeg;
    private Number price;
    private Integer resturantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quntity;
}
