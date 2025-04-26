package com.example.curso.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AvionDTO {
	private Long id;
	private String num_registro;
	private String tipo;
	private String codigoModelo;
	private Integer capacidad;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaPrimerVuelo;
	private Long estatus;
	private Long aerolineaId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNum_registro() {
		return num_registro;
	}
	public void setNum_registro(String num_registro) {
		this.num_registro = num_registro;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoModelo() {
		return codigoModelo;
	}
	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public LocalDate getFechaPrimerVuelo() {
		return fechaPrimerVuelo;
	}
	public void setFechaPrimerVuelo(LocalDate fechaPrimerVuelo) {
		this.fechaPrimerVuelo = fechaPrimerVuelo;
	}
	public Long getEstatus() {
		return estatus;
	}
	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}
	public Long getAerolineaId() {
		return aerolineaId;
	}
	public void setAerolineaId(Long aerolineaId) {
		this.aerolineaId = aerolineaId;
	}	
}
