package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class BorrarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros"); 
		Libro libro = servicio.buscarLibroPorClave(request.getParameter("isbn"));
		servicio.borrarLibro(libro);
		return "MostrarLibros.do"; 
	} 
} 
