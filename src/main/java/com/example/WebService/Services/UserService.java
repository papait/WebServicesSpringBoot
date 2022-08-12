package com.example.WebService.Services;
//Essa class que faz o meio de campo, implementa os metodos e regras de negocio

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.WebService.Repositorys.UserRepository;
import com.example.WebService.entities.User;

//Registrando class como componenet spring e vai ser injetado automatico com autowired
@Component
public class UserService {

	@Autowired// Injetando depe
	private UserRepository userrepository;
	// Opeerção na cmada de serviço e repassa a chamada para a cmada repository
	public List<User> findAll() {
		return userrepository.findAll();
	}
	
	public User findById (Long id) {
		Optional<User> objt = userrepository.findById(id);
		return objt.get(); // get retornar o objto dentro do optional
	}
}
