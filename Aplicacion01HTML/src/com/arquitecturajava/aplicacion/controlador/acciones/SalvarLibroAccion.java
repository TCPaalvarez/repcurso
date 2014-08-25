package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class SalvarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    String isbn = request.getParameter("isbn"); 
	    String isbnold = request.getParameter("isbnold"); 
	    String titulo = request.getParameter("titulo"); 
	    
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request); 
	    Libro lib=servicio.buscarLibroPorClave(isbnold);
	    Categoria categoria = servicio.buscarCategoriaPorClave(request.getParameter("categoria"));
	    lib.setCategoria(categoria);
	    lib.setIsbn(isbn);
	    lib.setTitulo(titulo);
	    servicio.salvarLibro(lib); 
	    return "MostrarLibros.do"; 
	} 
} 

