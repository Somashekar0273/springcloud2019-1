package com.springcloud.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcloud.product.entity.Product;
import com.springcloud.product.repository.ProductRepository;

@Repository("productDao")
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;

	public List getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getProductByCode(String code) {
		// TODO Auto-generated method stub
		return productRepository.findByProductCode(code);
	}

}
