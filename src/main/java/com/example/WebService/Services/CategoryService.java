package com.example.WebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.WebService.Repositorys.CategoryRepository;
import com.example.WebService.Repositorys.OrderRepository;
import com.example.WebService.entities.Category;
import com.example.WebService.entities.Order;
import com.example.WebService.entities.User;
@Component
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


	public List<Category> findAll (){
		return categoryRepository.findAll();
	}

	public Category findById (Long id) {
		Optional<Category> objt = categoryRepository.findById(id);
		return objt.get(); // get retornar o objto dentro do optional
	}
}

