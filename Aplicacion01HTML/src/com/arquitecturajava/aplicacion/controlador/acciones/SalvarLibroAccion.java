package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;

public class SalvarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
	    String isbn = request.getParameter("isbn"); 
	    String titulo = request.getParameter("titulo"); 
	    DAOFactory factoria=DAOAbstractFactory.getInstance();
	    CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
	    LibroDAO libroDAO=factoria.getLibroDAO();  
	    Categoria categoria = categoriaDAO.buscarPorClave(request.getParameter("categoria"));
		Libro lib=new Libro(isbn,titulo,categoria);
	    libroDAO.salvar(lib); 
	    return "MostrarLibros.do"; 
	} 
} 


