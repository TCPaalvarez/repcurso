package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;
//import com.arquitecturajava.dao.LibroDAOFactory;

public class BorrarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		DAOFactory factoria=DAOAbstractFactory.getInstance();
		LibroDAO libroDAO=factoria.getLibroDAO();  
		Libro libro = libroDAO.buscarPorClave(request.getParameter("isbn"));

		libroDAO.borrar(libro);
		return "MostrarLibros.do"; 
	} 
} 
