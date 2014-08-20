package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;

public class FormularioEditarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		List<Categoria> listaDeCategorias = Categoria.buscarTodos(); 
		Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
    	return "FormularioEditarLibro.jsp"; 
	} 
} 