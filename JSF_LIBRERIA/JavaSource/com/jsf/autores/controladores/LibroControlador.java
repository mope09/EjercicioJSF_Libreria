package com.jsf.autores.controladores;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsf.autores.entidades.Autor;
import com.jsf.autores.entidades.Categoria;
import com.jsf.autores.entidades.Libro;
import com.jsf.autores.servicios.ServicioAutores;
import com.jsf.autores.servicios.ServicioCategorias;
import com.jsf.autores.servicios.ServicioLibros;

@ManagedBean
@SessionScoped
public class LibroControlador {
	
	private  List<Libro> libros;
	private  List<Autor> autores;
	private  List<Categoria> categorias;	
	private Libro libro;
	
	private int categoriaSeleccionada;
	
	private int autorSeleccionado;
	
	private Libro libroS;
	private Libro [] librosS;
	/*COnstrcutor*/
	
	

	public LibroControlador(){
		libros = ServicioLibros.recuperarTodos();
		autores = ServicioAutores.recuperarTodos();
		categorias = ServicioCategorias.recuperarTodos();
		libro = new Libro();
		//libroS = new Libro();
	}
	
	/*Metodos*/
	
	public void insertarLibro (){
		
		
		try {
			libro.setCategoria(ServicioCategorias.buscarCategoria(categoriaSeleccionada));
			libro.setAutor(ServicioAutores.buscarAutor(autorSeleccionado));
			ServicioLibros.insertar(libro);
			libro = new Libro();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void seleccionar (){
		
		Categoria categoriaSeleccionada2= ServicioCategorias.buscarCategoria(libro.getCategoria().getId());		
		categoriaSeleccionada = categoriaSeleccionada2.getId();		
		Autor autorSeleccionado2 = ServicioAutores.buscarAutor(libro.getAutor().getCodigo());
		autorSeleccionado = autorSeleccionado2.getCodigo();
		System.out.println("LLEGO");
	}
	
	public void actualizar(){
		try {
			libro.setCategoria(ServicioCategorias.buscarCategoria(categoriaSeleccionada));
			libro.setAutor(ServicioAutores.buscarAutor(autorSeleccionado));
			ServicioLibros.actualizar(libro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar(){
		try {
			ServicioLibros.eliminar(libro);
			libro = new Libro();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*Getters & Setters*/
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public int getCategoriaSeleccionada() {
		return categoriaSeleccionada;
	}

	public void setCategoriaSeleccionada(int categoriaSeleccionada) {
		this.categoriaSeleccionada = categoriaSeleccionada;
	}

	public int getAutorSeleccionado() {
		return autorSeleccionado;
	}

	public void setAutorSeleccionado(int autorSeleccionado) {
		this.autorSeleccionado = autorSeleccionado;
	}

	
	public Libro getLibroS() {
		return libroS;
	}

	public void setLibroS(Libro libroS) {
		this.libroS = libroS;
	}

	public Libro[] getLibrosS() {
		return librosS;
	}

	public void setLibrosS(Libro[] librosS) {
		this.librosS = librosS;
	}

}
