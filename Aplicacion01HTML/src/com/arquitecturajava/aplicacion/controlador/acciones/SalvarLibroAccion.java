package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;

public class SalvarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    String isbn = request.getParameter("isbn"); 
	    String isbnold = request.getParameter("isbnold"); 
	    String titulo = request.getParameter("titulo"); 
	    
	    ServicioLibros servicioLibros= new ServicioLibrosImpl(); 
	    Libro lib=servicioLibros.buscarLibroPorClave(isbnold);
	    Categoria categoria = servicioLibros.buscarCategoriaPorClave(request.getParameter("categoria"));
	    lib.setCategoria(categoria);
	    lib.setIsbn(isbn);
	    lib.setTitulo(titulo);
	    servicioLibros.salvarLibro(lib); 
	    return "MostrarLibros.do"; 
	} 
} 

