package com.example.WebService.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.WebService.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //Garantir que o meu instnat JSON SAI NO FORMATO SIO
	private Instant moment;
	
	
	private Integer orderStatus;
	
	@ManyToOne //Constraint
	@JoinColumn (name = "client_id") //Criando a coluno com o a CHAVE
	private User client; //Montar o relacionamento JPA, tranformar em foreign key
	
	
	@OneToMany (mappedBy = "id.order") //id.order pq é o id order
	private Set <OrderItem> items = new HashSet<>();
	
	@OneToOne (mappedBy = "order", cascade = CascadeType.ALL) //one to one, mapeando as relações para terem o mesmo ID
	private Payment payment;
	

	public Order () {
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus ,User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public OrderStatus getOrderStatus () {
		return OrderStatus.valueof(orderStatus); //Converter OderStatus
	}
	
	public void setOrderStatus (OrderStatus orderStatus) {
		if (orderStatus != null) {
		this.orderStatus = orderStatus.getCode(); //Converter Integer
		}
	}
	
	public Set<OrderItem> getItems (){
		return items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Double getTotal () {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}
		 return sum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	};
	
	
	
}
