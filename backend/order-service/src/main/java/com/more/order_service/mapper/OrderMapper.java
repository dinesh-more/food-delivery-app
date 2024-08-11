package com.more.order_service.mapper;

import com.more.order_service.dto.OrderDTO;
import com.more.order_service.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

    List<Order> mapOrderDTOListToOrderList(List<OrderDTO> orderDTOList);
    List<OrderDTO> mapOrderListToOrderDTOList(List<Order> orderList);

}
