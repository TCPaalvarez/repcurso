package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;


public class FiltrarLibrosPorCategoriaAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		DAOFactory factoria=DAOAbstractFactory.getInstance();
		CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
		LibroDAO libroDAO=factoria.getLibroDAO();  
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos(); 
		List<Libro> listaDeLibros = null; 
		if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
			listaDeLibros = libroDAO.buscarTodos(); 
		} else { 
			Categoria categoria=categoriaDAO.buscarPorClave(request.getParameter("categoria"));
			listaDeLibros = libroDAO.buscarPorCategoria(categoria); 
		} 
		request.setAttribute("listaDeCategorias", listaDeCategorias);
	    request.setAttribute("listaDeLibros", listaDeLibros); 
    	return "MostrarLibros.jsp"; 
	} 
} 
