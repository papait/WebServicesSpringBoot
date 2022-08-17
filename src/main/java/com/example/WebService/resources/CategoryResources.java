package com.example.WebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.Services.CategoryService;
import com.example.WebService.entities.Category;




//Class desponibilidr um recurso web referente a entidade Catrgory utilizando controladores

//Recurso web implementado por um controlador rest

@RestController
@RequestMapping(value = "/category") // Nome do recurso
public class CategoryResources {

	//Pra funcionar a depend preciso registrar minha class como compoenet do spring
	@Autowired
	private CategoryService service;

// Método com retorno response que retornar reposta de requisões web

	@GetMapping ////meétodo que respode ao uma requisão do HTTP no caminho definido 
	public ResponseEntity<List<Category>> findAll(){
		List <Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //mINHA requisão vai aceitar um id dentro URL, passando um argumento por parametro para o ID
	
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //ok indica sucesso e o corpo da requisão eu passo o obj
	}
}
