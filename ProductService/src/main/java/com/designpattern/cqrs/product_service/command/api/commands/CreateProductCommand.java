package com.designpattern.cqrs.product_service.command.api.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand {

	 @TargetAggregateIdentifier
	    private String productId;
	    private String name;
	    private BigDecimal price;
	    private Integer quantity;
}
