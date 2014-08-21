package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.arquitecturajava.aplicacion.bo.Libro;

public class BorrarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
		libro.borrar();
		return "MostrarLibros.do"; 
	} 
} 
