package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;


public class FiltrarLibrosPorCategoriaAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		List<Categoria> listaDeCategorias = Categoria.buscarTodos(); 
		List<Libro> listaDeLibros = null; 
		if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) { 
			listaDeLibros = Libro.buscarTodos(); 
		} else { 
			Categoria categoria=Categoria.buscarCategoria(request.getParameter("categoria"));
			listaDeLibros = Libro.buscarPorCategoria(categoria); 
		} 
		request.setAttribute("listaDeCategorias", listaDeCategorias);
	    request.setAttribute("listaDeLibros", listaDeLibros); 
    	return "MostrarLibros.jsp"; 
	} 
} 