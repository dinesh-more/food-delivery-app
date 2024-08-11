package com.more.order_service.controller;

import com.more.order_service.dto.OrderDTO;
import com.more.order_service.dto.OrderRequest;
import com.more.order_service.entity.Order;
import com.more.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderRequest orderRequest) {
        OrderDTO savedOrder = orderService.saveOrder(orderRequest);
        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> fetchAllOrder() {
        return new ResponseEntity<>(orderService.fetchAllOrder(), HttpStatus.OK);
    }
}
