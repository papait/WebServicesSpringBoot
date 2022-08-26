package com.example.WebService.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.jaxws.SimpleHttpServerJaxWsServiceExporter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.WebService.Services.exeptions.DataBaseException;
import com.example.WebService.Services.exeptions.ResourceNotFoundExcepetion;

//Class responsavel para o tratemtno manual do erro
@ControllerAdvice //Vai interceptar a exption para que o objt da ResourceExption execute um tratamento
public class ResourceExpetionHandler {

	@ExceptionHandler(ResourceNotFoundExcepetion.class) //Anootarion para apontar o metodo para executar qualquer excption do tipo ResourceNotFoundExcepetion 
	public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundExcepetion e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND; //exceção 400
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err); //Responsa com corpo personalizado status com corpo da responsta ERR
	}
	
	@ExceptionHandler(DataBaseException.class) //Anootarion para apontar o metodo para executar qualquer excption do tipo ResourceNotFoundExcepetion 
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
		String error = "DataBase error";
		HttpStatus status = HttpStatus.BAD_REQUEST; //exceção 400
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err); //Responsa com corpo personalizado status com corpo da responsta ERR
	}
}
