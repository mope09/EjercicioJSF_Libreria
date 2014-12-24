package com.jsf.autores.servicios;

import java.util.ArrayList;
import java.util.List;
import com.jsf.autores.entidades.Categoria;

public class ServicioCategorias {

	private static List<Categoria> categorias;

	private static void cargarCategorias() {
		if (categorias == null) {
			categorias = new ArrayList<Categoria>();
			categorias.add(new Categoria(100, "Libro", "Horror"));
			categorias.add(new Categoria(200, "Revista", "Ficcion"));
		}
	}

	public static void insertar(Categoria categoria) throws Exception {
		cargarCategorias();
		if (buscarCategoria(categoria.getId()) == null) {
			categorias.add(categoria);
		} else {
			throw new Exception("La Categoria ya existe, no se agrega");
		}
	}

	public static void actualizar(Categoria categoria) throws Exception {
		cargarCategorias();
		Categoria modificado = buscarCategoria(categoria.getId());
		if (modificado != null) {
			modificado.setId(categoria.getId());
			modificado.setNombre(categoria.getNombre());
			modificado.setDescripcion(categoria.getDescripcion());
		} else {
			throw new Exception("No existe la categoria que desea modificar");
		}
	}

	public static void eliminar(Categoria categoria) throws Exception {
		Categoria encontrado = buscarCategoria(categoria.getId());
		if (encontrado != null) {
			categorias.remove(encontrado);
		} else {
			throw new Exception("No existe la categoria que desea eliminar ");
		}
	}

	public static Categoria buscarCategoria(int id) {
		cargarCategorias();
		for (Categoria cat : categorias) {
			if (cat.getId() == id) {
				return cat;
			}
		}
		return null;
	}

	public static List<Categoria> recuperarTodos() {
		cargarCategorias();
		return categorias;
	}

}
