package com.example.WebService.entities;
// Anottaion serve instruir pro jpa converter modelo relacional 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity; // Preferencia pra especificafica  e não a implementação
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Essa interface transforma o sobjetos em cadeia de bits, para serem utilzaidos melhores na rede
@Entity
@Table (name = "tb_user") 
public class User implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) // cOLOCA ID AUTOMATICO
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore 
	//Tirar o LOOP pq Order chama user e user chama uma lista orders
	//Quando voce carrega um objt ORDER automaticamente o client associado e carregado, pq é um padrão do JPA.  muitos para 1, já o oposto não ocorre
	// lazy loadins
	//Serrialização JKSON
	
	@OneToMany (mappedBy = "client") //o atributo esta mapeado do outro lado por client
	private List <Order> orders =  new ArrayList<>();

	public User() { // Fremeworkd pede um construtor vazio

	}

	public User(Long id, String name, String email, String phone, String password) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders (){
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
