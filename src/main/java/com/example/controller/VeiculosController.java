package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Veiculo;
import com.example.repository.VeiculosRepository;

@Controller
public class VeiculosController {
	
	@Autowired
	private VeiculosRepository veiculosRepo;
	
	@GetMapping ("/veiculos")
	public ModelAndView listarVeiculos() {
		List <Veiculo> veiculos = veiculosRepo.findAll();
		ModelAndView mv = new ModelAndView("veiculos");
		mv.addObject(new Veiculo());
		mv.addObject("veiculos", veiculos);
		return mv;
	}
	
	@PostMapping ("/veiculos")
	public String salvar( Veiculo veiculo) {
		veiculosRepo.save(veiculo);
		return "redirect:/veiculos";
	}
}
