package com.example.WebService.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.WebService.entities.Category;


@Component //Não é necassario pq já e herdado do Jpa repostory que é componente do spring
public interface CategoryRepository extends JpaRepository<Category, Long> { //JPA Repository
																	//Não precisa  da implemetação da interface, ja que o Spring JPA já tem uma implementação  propria

}
