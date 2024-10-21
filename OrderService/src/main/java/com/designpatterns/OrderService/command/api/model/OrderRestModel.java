package com.designpatterns.OrderService.command.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRestModel {

	private String productId;
	private String useId;
	private String addressId;
	private Integer quantity;
}
