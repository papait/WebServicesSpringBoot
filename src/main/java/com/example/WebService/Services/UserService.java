package com.example.WebService.Services;
//Essa class que faz o meio de campo, implementa os metodos e regras de negocio

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.example.WebService.Repositorys.UserRepository;
import com.example.WebService.Services.exeptions.DataBaseException;
import com.example.WebService.Services.exeptions.ResourceNotFoundExcepetion;
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
		return objt.orElseThrow(()-> new ResourceNotFoundExcepetion(id)); //Meétodo pra tentar dar o Get, mas se não funcionar THROW um excption
	}
	
	public User insert (User obj) {
		return userrepository.save(obj);
	}
	
	public void delete (Long id) {
		try {
		userrepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExcepetion(id); //Capturei a execcção do JPA EmptyResult e lancei a minha propria execão
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage()); //Lançada execção da minha camada de serviço
		}
	}
	
	public User update (Long id, User obj) {
		try{
		User entity = userrepository.getOne(id); //Metodo prepara o objt monitorado pelo JPA para eu trabar com ele, sem mudar alguma operação com BACNo
		updateData (entity, obj);
		return userrepository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExcepetion(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
	}
}
