package com.br.pizzaria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.pizzaria.models.PizzariaModel;

@Repository
public interface PizzariaRepository extends CrudRepository<PizzariaModel, Integer>{

}
