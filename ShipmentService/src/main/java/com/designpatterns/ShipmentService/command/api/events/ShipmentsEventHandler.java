package com.designpatterns.ShipmentService.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.designpatterns.CommonService.events.OrderShippedEvent;
import com.designpatterns.ShipmentService.command.api.data.Shipment;
import com.designpatterns.ShipmentService.command.api.data.ShipmentRepository;

@Component
public class ShipmentsEventHandler {

	 private ShipmentRepository shipmentRepository;

	    public ShipmentsEventHandler(ShipmentRepository shipmentRepository) {
	        this.shipmentRepository = shipmentRepository;
	    }

	    @EventHandler
	    public void on(OrderShippedEvent event) {
	        Shipment shipment
	                = new Shipment();
	        BeanUtils.copyProperties(event,shipment);
	        shipmentRepository.save(shipment);
	    }
}
