package com.br.pizzaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pizzaria.models.PizzariaModel;
import com.br.pizzaria.repositories.PizzariaRepository;

@Service
public class PizzariaService {
	
	@Autowired
	PizzariaRepository pizzariaRepository;
	
	public void adcionandoPizza(PizzariaModel pizzariaModel) {
		pizzariaRepository.save(pizzariaModel);
	}
	
	public Iterable<PizzariaModel> exibirPizzas(){
		return pizzariaRepository.findAll();
	}

}
