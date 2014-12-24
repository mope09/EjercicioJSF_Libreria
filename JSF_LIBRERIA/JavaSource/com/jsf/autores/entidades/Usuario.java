package com.jsf.autores.entidades;
public class Usuario {
	private int codigo;
	private String login;
	private String password;
	private Rol rol;

	public Usuario() {

	}

	public Usuario(int codigo, String login, String password, Rol rol) {
		super();
		this.codigo = codigo;
		this.login = login;
		this.password = password;
		this.rol = rol;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
