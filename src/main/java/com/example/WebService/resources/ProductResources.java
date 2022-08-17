package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.Services.ProductService;
import com.example.WebService.Services.UserService;
import com.example.WebService.entities.Product;
import com.example.WebService.entities.User;



//Class desponibilidr um recurso web referente a entidade USER utilizando controladores

//Recurso web implementado por um controlador

@RestController
@RequestMapping(value = "/products") // Nome do recurso
public class ProductResources {

	//Pra funcionar a depend preciso registrar minha class como compoenet do spring
	@Autowired
	private ProductService service;

// Método com retorno response que retornar reposta de requisões web

	@GetMapping ////meétodo que respode ao uma requisão do HTTP no caminho definido 
	public ResponseEntity<List<Product>> findAll(){
		List <Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //mINHA requisão vai aceitar um id dentro URL, passando um argumento por parametro para o ID
	
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //ok indica sucesso e o corpo da requisão eu passo o obj
	}
}
