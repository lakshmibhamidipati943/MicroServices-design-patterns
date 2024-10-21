package com.designpattern.cqrs.product_service.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.designpattern.cqrs.product_service.command.api.data.Product;
import com.designpattern.cqrs.product_service.command.api.data.ProductRepository;
import com.designpattern.cqrs.product_service.command.api.model.ProductRestModel;
import com.designpattern.cqrs.product_service.query.api.queries.GetProductsQuery;

@Component
public class ProductProjection {

	 private ProductRepository productRepository;

	    public ProductProjection(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    @QueryHandler
	    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
	        List<Product> products =
	                productRepository.findAll();

	        List<ProductRestModel> productRestModels =
	                products.stream()
	                        .map(product -> ProductRestModel
	                                .builder()
	                                .quantity(product.getQuantity())
	                                .price(product.getPrice())
	                                .name(product.getName())
	                                .build())
	                        .collect(Collectors.toList());

	        return productRestModels;
	    }
}
