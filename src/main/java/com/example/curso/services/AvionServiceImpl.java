package com.example.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.dto.AvionDTO;
import com.example.curso.entities.Aerolinea;
import com.example.curso.entities.Avion;
import com.example.curso.repositories.AerolineaRepository;
import com.example.curso.repositories.AvionRepository;

@Service
public class AvionServiceImpl implements IService<Avion> {
	@Autowired
	private AvionRepository avionRepository;
	
	@Autowired
	private AerolineaRepository aerolineaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Avion> getAll() {
		return (List<Avion>) avionRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Avion> getById(Long id) {
		return avionRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Avion save(Avion item) {
		return avionRepository.save(item);
	}
	
	@Transactional
	public Avion save(AvionDTO item) {
		Aerolinea aerolinea = aerolineaRepository.findById(item
				.getAerolineaId()).orElseThrow(() -> 
				new RuntimeException("Aerolinea no encontrada!"));
		Avion avion = new Avion();
		avion.setNum_registro(item.getNum_registro());
		avion.setTipo(item.getTipo());
		avion.setCodigoModelo(item.getCodigoModelo());
		avion.setCapacidad(item.getCapacidad());
		avion.setFechaPrimerVuelo(item.getFechaPrimerVuelo());
		avion.setEstatus(item.getEstatus());
		avion.setAerolineaId(aerolinea);
		return avionRepository.save(avion);
	}
	
	@Transactional
	public Avion update(AvionDTO avion, Long id) {
		Optional<Avion> optionalAvion = avionRepository.findById(id);
		if(optionalAvion.isPresent()) {
			Aerolinea aerolinea = aerolineaRepository.findById(avion.getAerolineaId()).orElseThrow(()
					-> new RuntimeException("Aerolinea no encontrada!"));
			Avion avionDb = optionalAvion.get();
			avionDb.setId(id);
			avionDb.setTipo(avion.getTipo());
			avionDb.setCodigoModelo(avion.getCodigoModelo());
			avionDb.setCapacidad(avion.getCapacidad());
			avionDb.setFechaPrimerVuelo(avion.getFechaPrimerVuelo());
			avionDb.setEstatus(avion.getEstatus());
			avionDb.setAerolineaId(aerolinea);
			return avionRepository.save(avionDb);
		}
		return null;
	}
	
	@Override
	@Transactional
	public Optional<Avion> deleteById(Long id){
		Optional<Avion> avionOptional = avionRepository.findById(id);
		if(avionOptional.isPresent()) {
			avionRepository.deleteById(id);
			return avionOptional;
		}
		return null;
	}
}
