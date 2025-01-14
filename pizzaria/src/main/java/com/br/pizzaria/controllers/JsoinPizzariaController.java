package com.br.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pizzaria.models.PizzariaModel;
import com.br.pizzaria.services.PizzariaService;

@RestController
@RequestMapping("/pizza")
public class JsoinPizzariaController {

	@Autowired
	PizzariaService pizzariaService;
	
	@GetMapping("/exibirPizzas")
	public ResponseEntity pegarPizzas() {
		if (pizzariaService.qtdPizzas() > 0) {
			return ResponseEntity.ok(pizzariaService.exibirPizzas());
		}
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PizzariaModel> pegarPizzasId(@PathVariable int id){
		PizzariaModel pizzariaModel = pizzariaService.pegarPizzaPeloId(id);
		if(pizzariaModel == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pizzariaModel);
	}
	
	

	@PostMapping("/criar")
	public ResponseEntity<PizzariaModel> criarPizza(@RequestBody PizzariaModel pizzariaModel){
		pizzariaService.adcionandoPizza(pizzariaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(pizzariaModel);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<PizzariaModel> atualizarPizza(@PathVariable int id, @PathVariable PizzariaModel pizzariaModel){
		pizzariaService.atualizarPizza(id, pizzariaModel);
		return ResponseEntity.ok(pizzariaModel);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity apagarPizza(@PathVariable int id) {
		pizzariaService.apagarPizza(id);
		return ResponseEntity.ok().build();
	}
	
}
