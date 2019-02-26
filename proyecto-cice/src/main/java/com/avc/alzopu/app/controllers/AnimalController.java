package com.avc.alzopu.app.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.avc.alzopu.app.models.entity.Animal;
import com.avc.alzopu.app.service.IAnimalService;


@Controller
@SessionAttributes("animal")
public class AnimalController {

	@Autowired
	private IAnimalService animalService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de animales");
		model.addAttribute("animales", animalService.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de Animal");
		model.put("animal", new Animal());
		return "form";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value ="id") Long id, Map<String, Object> model) {
		Optional<Animal> animal =  null;
		
		if (id > 0) {
			animal = animalService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		
		model.put("titulo", "Editar animal");
		model.put("animal", animal);
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Animal animal,  BindingResult result, SessionStatus status) {
		
		if (result.hasErrors()){
			return "form";
		}
		
		animalService.save(animal);
		status.setComplete();
		return "redirect:/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value ="id") Long id, Map<String, Object> model) {

		if (id > 0) {
			animalService.delete(id);
		}
		
		return "redirect:/listar";
	}
}
