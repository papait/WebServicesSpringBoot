package com.example.WebService.config;
//Class especiifca de configuração

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.WebService.Repositorys.UserRepository;
import com.example.WebService.entities.User;

@Configuration
@Profile ("testador") //Condiguração especifica do perfil de testador
public class TestConfig implements CommandLineRunner {
	
	
	//Injeção de dependencia fraca acoplamento
	// propio framework faz
	@Autowired
	private UserRepository userRepository;

	//Metodo implementado da interface que todos os códigos dentro dele vão ser executados quando a app iniciar
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Objeto que acessa os dados do BD
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

	
}
