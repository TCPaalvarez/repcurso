package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.DataBaseException;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;

public class InsertarLibroAccion extends Accion{ 
	  public String ejecutar(HttpServletRequest request,  HttpServletResponse response) throws DataBaseException { 
	    String isbn = request.getParameter("isbn"); 
	    String titulo = request.getParameter("titulo"); 
	    ServicioLibros servicioLibros= new ServicioLibrosImpl(); 
	    Categoria categoria = servicioLibros.buscarCategoriaPorClave(request.getParameter("categoria"));
	    Libro libro = new Libro(isbn, titulo, categoria); 
	    servicioLibros.salvarLibro(libro); 
	    return "MostrarLibros.do"; 
	  } 
}


