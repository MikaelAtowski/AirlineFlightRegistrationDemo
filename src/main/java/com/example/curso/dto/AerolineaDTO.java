package com.example.curso.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AerolineaDTO {
	private Long id;
	private String nombre;
	private String iata;
	private Long estatus;
	private String pais;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaFundacion;
	
	public AerolineaDTO() {
		
	}

	public AerolineaDTO(Long id, String nombre, String iata, Long estatus, String pais, LocalDate fechaFundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.iata = iata;
		this.estatus = estatus;
		this.pais = pais;
		this.fechaFundacion = fechaFundacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	
	
}
