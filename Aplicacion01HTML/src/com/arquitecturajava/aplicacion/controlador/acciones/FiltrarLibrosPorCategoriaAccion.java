package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;


public class FiltrarLibrosPorCategoriaAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request); 
		List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros(); 
		List<Libro> listaDeLibros = null; 
		if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
			listaDeLibros = servicio.buscarTodosLosLibros(); 
		} else { 
			listaDeLibros = servicio.buscarLibrosPorCategoria(request.getParameter("categoria")); 
		} 
		request.setAttribute("listaDeCategorias", listaDeCategorias);
	    request.setAttribute("listaDeLibros", listaDeLibros); 
    	return "MostrarLibros.jsp"; 
	} 
} 
