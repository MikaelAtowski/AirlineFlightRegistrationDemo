package com.example.curso.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class VueloDTO {
	private Long id;
	private String codigo;
	private Long avionId;
	private Long OrigenId;
	private Long DestinoId;
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate FechaSalida;
	private Long estatusId;
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
	public Long getAvionId() {
		return avionId;
	}
	public void setAvionId(Long avionId) {
		this.avionId = avionId;
	}
	public Long getOrigenId() {
		return OrigenId;
	}
	public void setOrigenId(Long origenId) {
		OrigenId = origenId;
	}
	public Long getDestinoId() {
		return DestinoId;
	}
	public void setDestinoId(Long destinoId) {
		DestinoId = destinoId;
	}
	public LocalDate getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(LocalDate fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public Long getEstatusId() {
		return estatusId;
	}
	public void setEstatusId(Long estatusId) {
		this.estatusId = estatusId;
	}
}
