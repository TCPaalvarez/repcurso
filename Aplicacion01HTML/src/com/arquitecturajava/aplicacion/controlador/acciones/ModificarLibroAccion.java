package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;

public class ModificarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    String isbn = request.getParameter("isbn"); 
	    String titulo = request.getParameter("titulo"); 
	    Categoria categoria = Categoria.buscarCategoria(request.getParameter("categoria"));
		Libro lib=new Libro(isbn,titulo,categoria);
		lib.salvar(); 
	    return "MostrarLibros.jsp"; 	} 
} 
