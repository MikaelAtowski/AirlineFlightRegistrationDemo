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
@Table(name = "Vuelo")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VUELO_SEQ")
	@SequenceGenerator(name = "VUELO_SEQ", sequenceName = "VUELO_SEQ", allocationSize = 1)
	
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CODIGO")
	private String codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AVION_ID", referencedColumnName =   "ID")
	private Avion avion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORIGEN_ID", referencedColumnName = "ID")
	private Aeropuerto origen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DESTINO_ID", referencedColumnName = "ID")
	private Aeropuerto destino;
	
	@Column(name = "FECHA_SALIDA")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate fechaSalida;
	
	@Column(name = "ESTATUS_ID")
	private Long estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}	
}
