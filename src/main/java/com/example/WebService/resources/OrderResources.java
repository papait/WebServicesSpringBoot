package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.Services.OrderService;
import com.example.WebService.entities.Order;
import com.example.WebService.entities.User;



//Class desponibilidr um recurso web referente a entidade USER utilizando controladores

//Recurso web implementado por um controlador

@RestController
@RequestMapping(value = "/orders") // Nome do recurso
public class OrderResources {

	//Pra funcionar a depend preciso registrar minha class como compoenet do spring
	@Autowired
	private OrderService service;

// Método com retorno response que retornar reposta de requisões web

	@GetMapping ////meétodo que respode ao uma requisão do HTTP no caminho definido 
	public ResponseEntity<List<Order>> findAll(){
		List <Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //mINHA requisão vai aceitar um id dentro URL, passando um argumento por parametro para o ID
	
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //ok indica sucesso e o corpo da requisão eu passo o obj
	}
}
