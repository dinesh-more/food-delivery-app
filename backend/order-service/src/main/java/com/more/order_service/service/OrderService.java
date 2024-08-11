package com.more.order_service.service;

import com.more.order_service.dto.OrderDTO;
import com.more.order_service.dto.OrderRequest;
import com.more.order_service.dto.UserDTO;
import com.more.order_service.entity.Order;
import com.more.order_service.mapper.OrderMapper;
import com.more.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private SequenceGeneratorService sequenceGeneratorService;
    private RestTemplate restTemplate;

    @Autowired
    public OrderService(OrderRepository orderRepository, SequenceGeneratorService sequenceGeneratorService, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.restTemplate = restTemplate;
    }

    public OrderDTO saveOrder(OrderRequest orderRequest) {
        //CREATE ORDER ID
        Integer orderId = sequenceGeneratorService.generateNextOrderId();

        //FETCH USER DETAILS BY USERID
        UserDTO userDetails = fetchUserDetailsByUserId(orderRequest.getUserId());

        Order order = new Order(orderId, orderRequest.getFoodItemList(), orderRequest.getRestaurant(), userDetails);

        Order savedOrder = orderRepository.save(order);

        return OrderMapper.INSTANCE.mapOrderToOrderDTO(savedOrder);
    }

    private UserDTO fetchUserDetailsByUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-INFO/users/"+userId, UserDTO.class);
    }

    public List<OrderDTO> fetchAllOrder() {
        return OrderMapper.INSTANCE.mapOrderListToOrderDTOList(orderRepository.findAll());
    }
}
