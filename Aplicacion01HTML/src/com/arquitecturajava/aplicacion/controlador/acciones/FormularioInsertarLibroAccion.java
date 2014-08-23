package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;

public class FormularioInsertarLibroAccion extends Accion { 
	@Override
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) { 
		DAOFactory factoria=DAOAbstractFactory.getInstance();
		CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos(); 
    	request.setAttribute("listaDeCategorias", listaDeCategorias); 
    	return "FormularioInsertarLibro.jsp"; 
	} 
} 


