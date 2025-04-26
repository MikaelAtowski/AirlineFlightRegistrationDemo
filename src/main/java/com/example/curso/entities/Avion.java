package com.example.curso.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avion")
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVION_SEQ")
	@SequenceGenerator(name = "AVION_SEQ", sequenceName = "AVION_SEQ", allocationSize = 1)

	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NUM_REGISTRO")
	private String num_registro;
	
	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "CODIGO_MODELO")
	private String codigoModelo;
	
	@Column(name = "CAPACIDAD")
	private Integer capacidad;
	
	@Column(name = "FECHA_PRIMER_VUELO")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaPrimerVuelo;
	
	@Column(name = "ESTATUS_ID")
	private Long estatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AEROLINEA_ID")
	private Aerolinea aerolineaId;

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

	public Aerolinea getAerolineaId() {
		return aerolineaId;
	}

	public void setAerolineaId(Aerolinea aerolineaId) {
		this.aerolineaId = aerolineaId;
	}
}
