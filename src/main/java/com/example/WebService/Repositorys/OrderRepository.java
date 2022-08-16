package com.example.WebService.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.WebService.entities.Order;

@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

}
