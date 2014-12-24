package com.jsf.autores.servicios;

import java.util.ArrayList;
import java.util.List;
import com.jsf.autores.entidades.Rol;

public class ServicioRol {

	private static List<Rol> roles;

	private static void cargarRoles() {

		if (roles == null) {
			roles = new ArrayList<Rol>();
			roles.add(new Rol(1, "Administrador"));
			roles.add(new Rol(2, "Vendedor"));
		}
	}

	public static void insertar(Rol rol) throws Exception {
		cargarRoles();
		if (buscarRol(rol.getId()) == null) {
			roles.add(rol);
		} else {
			throw new Exception("El Rol ya existe, no se agrega");
		}
	}

	public static void actualizar(Rol rol) throws Exception {
		cargarRoles();
		Rol modificado = buscarRol(rol.getId());
		if (modificado != null) {
			modificado.setId(rol.getId());
			modificado.setNombreRol(rol.getNombreRol());
		} else {
			throw new Exception("No existe el ROL que desea modificar");
		}
	}

	public static void eliminar(Rol rol) throws Exception {
		Rol encontrado = buscarRol(rol.getId());
		if (encontrado != null) {
			roles.remove(encontrado);
		} else {
			throw new Exception("No existe el ROL que desea eliminar ");
		}
	}

	public static Rol buscarRol(int id) {
		cargarRoles();
		for (Rol rol : roles) {
			if (rol.getId() == id) {
				return rol;
			}
		}
		return null;
	}

	public static List<Rol> recuperarTodos() {
		cargarRoles();
		return roles;
	}

}
