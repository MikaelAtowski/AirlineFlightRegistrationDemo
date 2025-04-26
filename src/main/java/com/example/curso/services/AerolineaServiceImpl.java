package com.example.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.curso.dto.AerolineaDTO;
import com.example.curso.entities.Aerolinea;
import com.example.curso.repositories.AerolineaRepository;


@Service
public class AerolineaServiceImpl implements IService<Aerolinea> {
	@Autowired
	private AerolineaRepository aerolineaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Aerolinea> getAll() {
		return (List<Aerolinea>) aerolineaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Aerolinea> getById(Long id) {
		return aerolineaRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Aerolinea save(Aerolinea item) {
		return aerolineaRepository.save(item);
	}

	@Transactional
	@Override
	public Optional<Aerolinea> deleteById(Long id) {
		Optional<Aerolinea> aerolineaOptional = aerolineaRepository.findById(id); 
		if(aerolineaOptional.isPresent()) {
			aerolineaRepository.deleteById(id);
			return aerolineaOptional;
		}
	return null;
	}
	
	public List<AerolineaDTO> listarAerolineasDTO(List<Aerolinea> aerolineas){
		return aerolineas.stream()
				.map(aerolinea -> new AerolineaDTO(
						aerolinea.getId(),
						aerolinea.getNombre(),
						aerolinea.getIata(),
						aerolinea.getEstatus(),
						aerolinea.getPais(),
						aerolinea.getFechaFundacion()
						))
				.collect(Collectors.toList());
	}
	
	public Optional<Aerolinea> buscarPorIata(String iata){
		return aerolineaRepository.findByIata(iata);
	}
}
