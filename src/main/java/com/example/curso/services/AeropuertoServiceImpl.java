package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.entities.Aeropuerto;
import com.example.curso.repositories.AeropuertoRepository;


@Service
public class AeropuertoServiceImpl implements IService<Aeropuerto> {
	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Aeropuerto> getAll() {
		return (List<Aeropuerto>) aeropuertoRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Aeropuerto> getById(Long id) {
		return aeropuertoRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Aeropuerto save(Aeropuerto item) {
		return aeropuertoRepository.save(item);
	}

	@Transactional
	@Override
	public Optional<Aeropuerto> deleteById(Long id) {
		Optional<Aeropuerto> aeropuertoOptional = aeropuertoRepository.findById(id); 
		if(aeropuertoOptional.isPresent()) {
			aeropuertoRepository.deleteById(id);
			return aeropuertoOptional;
		}
	return null;
	}
}
