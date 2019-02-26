package com.avc.alzopu.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.avc.alzopu.app.models.entity.Animal;

public interface IAnimalDao extends CrudRepository<Animal, Long>{
	
}
