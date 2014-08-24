package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;

public class BorrarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    ServicioLibros servicioLibros= new ServicioLibrosImpl(); 
		Libro libro = servicioLibros.buscarLibroPorClave(request.getParameter("isbn"));
		servicioLibros.borrarLibro(libro);
		return "MostrarLibros.do"; 
	} 
} 
