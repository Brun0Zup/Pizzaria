package com.br.pizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.pizzaria.models.PizzariaModel;
import com.br.pizzaria.services.PizzariaService;

@Controller
public class PizzariaController {

	@Autowired
	private PizzariaService pizzariaService;

	@GetMapping("/")
	public ModelAndView exibirPizzas() {
		ModelAndView modelAnsView = new ModelAndView("pizzaria.html");
		return modelAnsView;
	}

	@GetMapping("/cardapio")
	public ModelAndView cardapio() {
		ModelAndView modelAndView = new ModelAndView("cardapio.html"); // menu cardapio em inglês
		modelAndView.addObject("pizzas", pizzariaService.exibirPizzas());
		return modelAndView;
	}

	@GetMapping("/newpizza")
	public ModelAndView newPizza() {
		ModelAndView modelAndView = new ModelAndView("newpizza.html");
		return modelAndView;
	}

	@PostMapping("/newpizza")
	public String novaPizza(PizzariaModel pizzaModel) {
		pizzariaService.adcionandoPizza(pizzaModel);
		return "/newpizza";
	}
	
	

}