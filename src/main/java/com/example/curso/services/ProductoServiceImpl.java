package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.entities.Producto;
import com.example.curso.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements IService<Producto>{
	

	@Autowired
	private ProductoRepository productoRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Producto> getAll() {
	    return (List<Producto>) productoRepository.findAll();

   	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Producto> getById(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public Producto save(Producto item) {
		return productoRepository.save(item);
	}

	@Override
	public Optional<Producto> deleteById(Long id) {
		Optional<Producto> produOptional = productoRepository.findById(id);
		if (produOptional.isPresent()) {
			productoRepository.deleteById(id);
			return produOptional;
		}
		return null;

	}

}
