package com.example.WebService.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.WebService.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name ="tb_Order_Item")
public class OrderItem  implements Serializable{

	private static final long serialVersionUID = 1L;

	//ID COMPSOTO
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem () {
		
	}

	//OrderItem Pk VOU FAZAR MANUALMENTE
	public OrderItem(Order oder, Product product,Integer quantity, Double price) {
		id.setOrder(oder);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	//Cortat associção de mão dupla
	@JsonIgnore
	public Order getOrder () {
		return id.getOrder();
	
	}
	
	public void setOrder (Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct () {
		return id.getProduct();
	
	}
	
	public void setProduct (Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
// Começar com get o nome para aparecer no JSON
	public Double getSubTotal () {
		return price* quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
