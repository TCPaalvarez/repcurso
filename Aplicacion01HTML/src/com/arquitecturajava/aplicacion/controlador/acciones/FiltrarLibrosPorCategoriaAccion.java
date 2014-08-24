package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;


public class FiltrarLibrosPorCategoriaAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    ServicioLibros servicioLibros= new ServicioLibrosImpl(); 
		List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros(); 
		List<Libro> listaDeLibros = null; 
		if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
			listaDeLibros = servicioLibros.buscarTodosLosLibros(); 
		} else { 
			listaDeLibros = servicioLibros.buscarLibrosPorCategoria(request.getParameter("categoria")); 
		} 
		request.setAttribute("listaDeCategorias", listaDeCategorias);
	    request.setAttribute("listaDeLibros", listaDeLibros); 
    	return "MostrarLibros.jsp"; 
	} 
} 
