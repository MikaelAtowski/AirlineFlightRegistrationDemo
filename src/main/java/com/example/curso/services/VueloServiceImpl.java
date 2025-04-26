package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.dto.VueloDTO;
import com.example.curso.entities.Aeropuerto;
import com.example.curso.entities.Avion;
import com.example.curso.entities.Vuelo;
import com.example.curso.exceptions.ResourceNotFoundException;
import com.example.curso.repositories.AeropuertoRepository;
import com.example.curso.repositories.AvionRepository;
import com.example.curso.repositories.VueloRepository;

@Service
public class VueloServiceImpl implements IService<Vuelo>{
	
	@Autowired
	private VueloRepository vueloRepository;
	
	@Autowired
	private AvionRepository avionRepository;
	
	@Autowired
	private AeropuertoRepository aeropuertoRepository;
	
	@Override
	public List<Vuelo> getAll(){
		return (List<Vuelo>) vueloRepository.findAll();
	}
	
	@Override
	public Optional<Vuelo> getById(Long id){
		return vueloRepository.findById(id);
	}
	
	@Override
	public Vuelo save(Vuelo item) {
		return vueloRepository.save(item);
	}
	
	public Vuelo save(VueloDTO item) {
		Avion avion = avionRepository.findById(item.getAvionId())
				.orElseThrow(() -> new ResourceNotFoundException("Avion"));
		Aeropuerto origen = aeropuertoRepository.findById(item.getOrigenId())
				.orElseThrow(() -> new ResourceNotFoundException("Aeropuerto"));
		Aeropuerto destino = aeropuertoRepository.findById(item.getDestinoId())
				.orElseThrow(() -> new ResourceNotFoundException("Aeropuerto"));
		Vuelo vueloDb = new Vuelo();
		vueloDb.setCodigo(item.getCodigo());
		vueloDb.setAvion(avion);
		vueloDb.setOrigen(origen);
		vueloDb.setDestino(destino);
		vueloDb.setFechaSalida(item.getFechaSalida());
		vueloDb.setEstatus(item.getEstatusId());
		return vueloRepository.save(vueloDb);
	}
	
	public Vuelo update(VueloDTO item, Long id) {
		Optional<Vuelo> optionalVuelo = vueloRepository.findById(id);
		if(optionalVuelo.isPresent()) {
			Avion avion = avionRepository.findById(item.getAvionId())
					.orElseThrow(() -> new ResourceNotFoundException("Avion"));
			Aeropuerto origen = aeropuertoRepository.findById(item.getOrigenId())
					.orElseThrow(() -> new ResourceNotFoundException("Aeropuerto"));
			Aeropuerto destino = aeropuertoRepository.findById(item.getDestinoId())
					.orElseThrow(() -> new ResourceNotFoundException("Aeropuerto"));
			Vuelo vueloDb = new Vuelo();
			vueloDb.setId(id);
			vueloDb.setCodigo(item.getCodigo());
			vueloDb.setAvion(avion);
			vueloDb.setOrigen(origen);
			vueloDb.setDestino(destino);
			vueloDb.setFechaSalida(item.getFechaSalida());
			vueloDb.setEstatus(item.getEstatusId());
			return vueloRepository.save(vueloDb);
		}
		return null;
	}
	
	@Override
	public Optional<Vuelo> deleteById(Long id){
		Optional<Vuelo> vueloOptional = vueloRepository.findById(id);
		if(vueloOptional.isPresent()) {
			vueloRepository.deleteById(id);
			return vueloOptional;
		}
		return null;
	}
}
