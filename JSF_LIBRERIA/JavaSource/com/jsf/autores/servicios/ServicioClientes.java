package com.jsf.autores.servicios;

import java.util.ArrayList;
import java.util.List;

import com.jsf.autores.entidades.Cliente;

public class ServicioClientes {
	private static List<Cliente> clientes;

	private static void cargarClientes() {
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
			clientes.add(new Cliente(1, "1719629162", "Esteban", "Baez",
					"La Gasca", ServicioNacionalidad.buscarNacionalidad(1)));
			clientes.add(new Cliente(2, "1720201569", "Emilio", "Montenegro",
					"La Mañosca", ServicioNacionalidad.buscarNacionalidad(2)));
		}
	}

	public static void insertar(Cliente cliente) throws Exception {
		cargarClientes();
		if (buscarCliente(cliente.getCodigoC()) == null) {
			clientes.add(cliente);
		} else {
			throw new Exception("El Cliente ya existe, no se agrega");
		}
	}

	public static void actualizar(Cliente cliente) throws Exception {
		cargarClientes();
		Cliente modificado = buscarCliente(cliente.getCodigoC());
		if (modificado != null) {
			modificado.setCedula(cliente.getCedula());
			modificado.setApellido(cliente.getApellido());
			modificado.setDireccion(cliente.getDireccion());
			modificado.setNacionalidad(cliente.getNacionalidad());
			modificado.setNombre(cliente.getNombre());
			System.out.println("Cliente Modificado");
		} else {
			throw new Exception("No existe el Cliente que desea modificar");
		}
	}

	public static void eliminar(Cliente cliente) throws Exception {
		Cliente encontrado = buscarCliente(cliente.getCodigoC());
		if (encontrado != null) {
			clientes.remove(encontrado);
		} else {
			throw new Exception("No existe el cliente que desea eliminar ");
		}
	}

	public static Cliente buscarCliente(int codigo) {
		cargarClientes();
		for (Cliente cli : clientes) {
			if (cli.getCodigoC() == codigo) {
				return cli;
			}
		}
		return null;
	}

	public static List<Cliente> recuperarTodos() {
		cargarClientes();
		return clientes;
	}

}
