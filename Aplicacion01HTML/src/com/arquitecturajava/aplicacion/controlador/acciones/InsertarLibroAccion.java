package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.DataBaseException;
import com.arquitecturajava.Libro;

public class InsertarLibroAccion extends Accion{ 
	  public String ejecutar(HttpServletRequest request,  HttpServletResponse response) throws DataBaseException { 
	    String isbn = request.getParameter("isbn"); 
	    String titulo = request.getParameter("titulo"); 
	    String categoria = request.getParameter("categoria"); 
	    Libro libro = new Libro(isbn, titulo, categoria); 
	    libro.insertar(); 
	    return "MostrarLibros.do"; 
	  } 
}