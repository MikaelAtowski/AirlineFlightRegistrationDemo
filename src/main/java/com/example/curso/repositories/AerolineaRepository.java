package com.example.curso.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.curso.entities.Aerolinea;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
	Optional<Aerolinea> findByIata(String iata);
}
