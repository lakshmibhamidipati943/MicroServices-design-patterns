package com.designpatterns.OrderService.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.designpatterns.CommonService.events.OrderCancelledEvent;
import com.designpatterns.CommonService.events.OrderCompletedEvent;
import com.designpatterns.OrderService.command.api.data.Order;
import com.designpatterns.OrderService.command.api.data.OrderRepository;

@Component
public class OrderEventsHandler {

	 private OrderRepository orderRepository;

	    public OrderEventsHandler(OrderRepository orderRepository) {
	        this.orderRepository = orderRepository;
	    }

	    @EventHandler
	    public void on(OrderCreatedEvent event) {
	        Order order = new Order();
	        BeanUtils.copyProperties(event,order);
	        orderRepository.save(order);
	    }

	    @EventHandler
	    public void on(OrderCompletedEvent event) {
	        Order order
	                = orderRepository.findById(event.getOrderId()).get();

	        order.setOrderStatus(event.getOrderStatus());

	        orderRepository.save(order);
	    }

	    @EventHandler
	    public void on(OrderCancelledEvent event) {
	        Order order
	                = orderRepository.findById(event.getOrderId()).get();

	        order.setOrderStatus(event.getOrderStatus());

	        orderRepository.save(order);
	    }
}
