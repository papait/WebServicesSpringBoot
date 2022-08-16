package com.example.WebService.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.WebService.Repositorys.OrderRepository;
import com.example.WebService.entities.Order;
import com.example.WebService.entities.User;
@Component
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> findAll (){
		return orderRepository.findAll();
	}
	
	public Order findById (Long id) {
		Optional<Order> objt = orderRepository.findById(id);
		return objt.get(); // get retornar o objto dentro do optional
	}
	
}
