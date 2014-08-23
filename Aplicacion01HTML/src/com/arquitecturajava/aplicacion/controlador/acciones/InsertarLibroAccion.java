package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.DataBaseException;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;

public class InsertarLibroAccion extends Accion{ 
	  public String ejecutar(HttpServletRequest request,  HttpServletResponse response) throws DataBaseException { 
	    String isbn = request.getParameter("isbn"); 
	    String titulo = request.getParameter("titulo"); 
	    DAOFactory factoria=DAOAbstractFactory.getInstance();
	    CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
	    LibroDAO libroDAO=factoria.getLibroDAO();  
	    Categoria categoria = categoriaDAO.buscarPorClave(request.getParameter("categoria"));
	    Libro libro = new Libro(isbn, titulo, categoria); 
	    libroDAO.salvar(libro); 
	    return "MostrarLibros.do"; 
	  } 
}
