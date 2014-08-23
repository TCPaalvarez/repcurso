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

public class FormularioEditarLibroAccion extends Accion { 
	@Override 
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) {
		DAOFactory factoria=DAOAbstractFactory.getInstance();
		CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
		LibroDAO libroDAO=factoria.getLibroDAO();  
		
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos(); 
		Libro libro = libroDAO.buscarPorClave(request.getParameter("isbn"));
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
    	return "FormularioEditarLibro.jsp"; 
	} 
} 


