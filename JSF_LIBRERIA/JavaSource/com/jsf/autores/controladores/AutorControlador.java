package com.jsf.autores.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.jsf.autores.entidades.Autor;
import com.jsf.autores.entidades.Nacionalidad;
import com.jsf.autores.servicios.ServicioAutores;
import com.jsf.autores.servicios.ServicioNacionalidad;
@SessionScoped
@ManagedBean
public class AutorControlador {
	private Autor autor;
	private int nacioseleccionada;
	private List<Autor> autores ;
	private List<Nacionalidad> nacionalidades;
	private Nacionalidad nacionalidad;
	private boolean ingresar;
	private boolean actualizar;
	private boolean codigoDesable;
	private boolean eliminar;
	private int  autoreseleccionado;
	
	/*Constrcutor*/
	public AutorControlador(){
		
		nacionalidades = ServicioNacionalidad.recuperarTodos();
		autor = new Autor();
		autores = new  ArrayList<Autor> ();
		autores = ServicioAutores.recuperarTodos();
		codigoDesable = false;
		ingresar = false;
		actualizar = false;
		eliminar= false;
	}
	/*Metodos*/
	public void onEdit(RowEditEvent event) {  
		//actualizar();
        FacesMessage msg = new FacesMessage("Autor Editado");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Car Cancelled");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
	public void insertarAutor (){
		
		try {
			List<Autor> autores = ServicioAutores.recuperarTodos();
			System.out.println("Autorrr" + autor.getNombre());
			System.out.println("Autorrr" + autores.size());
			
			for (Autor autores1 : autores){
				System.out.println(autores1.getNombre());
			}
			autor.setNacionalidad(ServicioNacionalidad.buscarNacionalidad(nacioseleccionada));
			
			ServicioAutores.insertar(autor);
			autor = new Autor();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se inserto Exitosamente", "Autor!"));  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El registro ya existe", "Autor"));
		}
		
	}
	
	public void seleccionar (){
		nacionalidad = ServicioNacionalidad.buscarNacionalidad(autor.getNacionalidad().getId());
		nacioseleccionada =nacionalidad.getId();
		codigoDesable = true;
		ingresar = true;
		
	}
	public void seleccionar2 (){
		System.out.println("llego, aqui debo buscar por ID el autor y mostrar");
		
	}
	
	public void actualizar (){
		System.out.println("NACIONALIDAD"+nacioseleccionada);
		autor.setNacionalidad(ServicioNacionalidad.buscarNacionalidad(nacioseleccionada));
		try {
			ingresar = true;
			codigoDesable = true;			
			ServicioAutores.actualizar(autor);
			autor = new Autor();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			autor = new Autor();
		}
	}
	
	public void eliminar (){
		
		try {
			
			ServicioAutores.eliminar(autor);
			autor = new Autor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*Getters & Setters*/
	
	public List<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(List<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	public int getNacioseleccionada() {
		return nacioseleccionada;
	}

	public void setNacioseleccionada(int nacioseleccionada) {
		this.nacioseleccionada = nacioseleccionada;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public boolean isIngresar() {
		return ingresar;
	}

	public void setIngresar(boolean ingresar) {
		this.ingresar = ingresar;
	}

	public boolean isActualizar() {
		return actualizar;
	}

	public void setActualizar(boolean actualizar) {
		this.actualizar = actualizar;
	}

	public boolean isCodigoDesable() {
		return codigoDesable;
	}

	public void setCodigoDesable(boolean codigoDesable) {
		this.codigoDesable = codigoDesable;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public int getAutoreseleccionado() {
		return autoreseleccionado;
	}

	public void setAutoreseleccionado(int autoreseleccionado) {
		this.autoreseleccionado = autoreseleccionado;
	}

}
