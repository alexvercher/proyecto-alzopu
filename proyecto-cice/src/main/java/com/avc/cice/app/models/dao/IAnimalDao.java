package com.avc.cice.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.avc.cice.app.models.entity.Animal;

public interface IAnimalDao extends CrudRepository<Animal, Long>{
	
}
