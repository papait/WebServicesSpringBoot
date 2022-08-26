package com.example.WebService.Services.exeptions;

public class ResourceNotFoundExcepetion extends RuntimeException {


	private static final long serialVersionUID = 1L; //RUntime expetion o compilador n obriga a tratar

	public ResourceNotFoundExcepetion (Object id) { // construtor recebe um ID lança uma ResourceNotfound COM UM TEXTO
		super("Resource not found. ID " +id);
	}
}
