package com.avc.alzopu.app.service;

import java.util.List;
import java.util.Optional;

import com.avc.alzopu.app.models.entity.Animal;

public interface IAnimalService {

	public List<Animal> findAll();

	public void save (Animal animal);
	
	public Optional<Animal> findOne(Long id);
	
	public void delete(Long id);
}
