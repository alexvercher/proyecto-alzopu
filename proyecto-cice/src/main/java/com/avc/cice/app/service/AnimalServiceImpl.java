package com.avc.cice.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avc.cice.app.models.dao.IAnimalDao;
import com.avc.cice.app.models.entity.Animal;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalDao animalDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Animal> findAll() {
		return (List<Animal>) animalDao.findAll();
	}

	@Override
	@Transactional
	public void save(Animal animal) {
		animalDao.save(animal);
	}

	@Override
	@Transactional(readOnly=true)		
	public Optional<Animal> findOne(Long id) {
		return animalDao.findById(id);
	}

	@Override
	@Transactional	
	public void delete(Long id) {
		animalDao.deleteById(id);
	}

	
}
