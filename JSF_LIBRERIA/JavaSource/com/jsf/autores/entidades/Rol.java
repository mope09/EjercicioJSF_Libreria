package com.jsf.autores.entidades;
public class Rol {
	private int id;
	private String nombreRol;

	public Rol() {

	}

	public Rol(int id, String nombreRol) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

}
