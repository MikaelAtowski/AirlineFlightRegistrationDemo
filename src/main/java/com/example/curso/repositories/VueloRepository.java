package com.example.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curso.entities.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
