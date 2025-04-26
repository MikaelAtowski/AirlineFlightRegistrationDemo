package com.example.curso.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AEROLINEA")
public class Aerolinea {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="AEROLINEA_SEQ")
	@SequenceGenerator(name="AEROLINEA_SEQ",sequenceName = "AEROLINEA_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="IATA")
	private String iata;
	
	@Column(name="ESTATUS_ID")
	private Long estatus;
	
	@Column(name="PAIS")
	private String pais;
	
	@Column(name="FECHA_FUNDACION")
	@JsonFormat(shape=Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaFundacion;

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
