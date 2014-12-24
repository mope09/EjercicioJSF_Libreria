package com.jsf.autores.servicios;

import java.util.ArrayList;
import java.util.List;

import com.jsf.autores.entidades.Autor;

public class ServicioAutores {

	private static List<Autor> autores;

	private static void cargarAutores() {
		if (autores == null) {
			autores = new ArrayList<Autor>();
			autores.add(new Autor(1, "Martin", "Romero", ServicioNacionalidad
					.buscarNacionalidad(1)));
			autores.add(new Autor(2, "Francisco", "Montenegro",
					ServicioNacionalidad.buscarNacionalidad(2)));
		}
	}

	public static void insertar(Autor autor) throws Exception {
		cargarAutores();
		if ((buscarAutor(autor.getCodigo()) == null)) {
			autores.add(autor);
		} else {
			throw new Exception("El Autor ya existe, no se agrega");
		}
	}

	public static void actualizar(Autor autor) throws Exception {
		cargarAutores();
		Autor modificado = buscarAutor(autor.getCodigo());
		if (modificado != null) {
			modificado.setNombre(autor.getNombre());
			modificado.setApellido(autor.getApellido());
			modificado.setNacionalidad(autor.getNacionalidad());
		} else {
			throw new Exception("No existe el Autor que desea modificar");
		}
	}

	public static void eliminar(Autor autor) throws Exception {
		Autor encontrado = buscarAutor(autor.getCodigo());
		if (encontrado != null) {
			autores.remove(encontrado);
		} else {
			throw new Exception("No existe el Autor que desea eliminar ");
		}
	}

	public static Autor buscarAutor(int codigo) {
		cargarAutores();
		for (Autor aut : autores) {
			if (aut.getCodigo() == codigo) {
				return aut;
			}
		}
		return null;
	}

	public static List<Autor> recuperarTodos() {
		cargarAutores();
		return autores;
	}
}
