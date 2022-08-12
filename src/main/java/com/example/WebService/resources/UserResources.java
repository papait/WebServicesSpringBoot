package com.example.WebService.resources;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebService.entities.User;

//Class desponibilidr um recurso web referente a entidade USER utilizando controladores


//Recurso web implementado por um controlador

@RestController
@RequestMapping(value = "/users")//Nome do recurso
public class UserResources {
	
// Método com retorno response que retornar reposta de requisões web
	
	@GetMapping ////meétodo que respode ao uma requisão do HTTP no caminho definido 
	public ResponseEntity<User> findAll(){
	User u = new User(1L, "Maria", "maria@geamil.com", "000000000000", "12345");
	return ResponseEntity.ok().body(u) //body corpo da resposta
;	}
}
