package com.designpattern.cqrs.product_service.command.api.data;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {

	  @Id
	    private String productId;
	    private String name;
	    private BigDecimal price;
	    private Integer quantity;
}
