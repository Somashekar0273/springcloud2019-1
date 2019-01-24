package com.springcloud.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.product.entity.Product;
import com.springcloud.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
@RefreshScope
@ConfigurationProperties
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${welcome.message}")
	private String message;
	
	
	@RequestMapping("/welcome")
	public String welcomeMessage() {
		return message;
	}
	
	@RequestMapping("/all")
	public List getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productService.getProductByCode(code);
	}

}
