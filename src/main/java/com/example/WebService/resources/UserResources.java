package com.example.WebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.WebService.Services.UserService;
import com.example.WebService.entities.User;



//Class desponibilidr um recurso web referente a entidade USER utilizando controladores

//Recurso web implementado por um controlador

@RestController
@RequestMapping(value = "/users") // Nome do recurso
public class UserResources {

	//Pra funcionar a depend preciso registrar minha class como compoenet do spring
	@Autowired
	private UserService service;

// Método com retorno response que retornar reposta de requisões web

	@GetMapping ////meétodo que respode ao uma requisão do HTTP no caminho definido 
	public ResponseEntity<List<User>> findAll(){
		List <User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //mINHA requisão vai aceitar um id dentro URL, passando um argumento por parametro para o ID
	
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //ok indica sucesso e o corpo da requisão eu passo o obj (Retornar a resposta da requisão)
	}
	
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj){ //Para que esse objt que chegar no modo JSON na hr requisição, e esse JSON vai ser deserializado para obj USER java
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //
		return ResponseEntity.created(uri).body(obj) ;
													//Creatd espera um objt URI
												// Padrão HTTP retornar um 201 É ESPERADO QUE A RESPOTA CONTENHa HEADERS COM O RECURSO QUE VC INSERIU (caminho )
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) { //Para id ser reconhecido como uma variavel da minha URL
		service.delete(id);
		return ResponseEntity.noContent().build(); //Responsa sem corpo
	}
}
