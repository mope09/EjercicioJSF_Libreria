package com.jsf.autores.entidades;

import javax.validation.constraints.NotNull;

public class Nacionalidad {
	@NotNull(message = "Se requiere un ID")
	private int id;
	@NotNull(message = "Se requiere un Pais")
	private String pais;
	@NotNull(message = "Se requiere un Gentilicio")
	private String gentilicio;

	public Nacionalidad() {
		super();
	}

	public Nacionalidad(int id, String pais, String gentilicio) {
		super();
		this.id = id;
		this.pais = pais;
		this.gentilicio = gentilicio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getGentilicio() {
		return gentilicio;
	}

	public void setGentilicio(String gentilicio) {
		this.gentilicio = gentilicio;
	}
}