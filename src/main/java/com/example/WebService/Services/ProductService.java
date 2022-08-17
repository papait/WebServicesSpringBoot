package com.example.WebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.WebService.Repositorys.ProductRepository;
import com.example.WebService.entities.Category;
import com.example.WebService.entities.Product;


@Component
public class ProductService {


	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> findAll (){
		return productRepository.findAll();
	}
	
	public Product findById (Long id) {
		Optional<Product> objt = productRepository.findById(id);
		return objt.get(); // get retornar o objto dentro do optional
	}
	
}
