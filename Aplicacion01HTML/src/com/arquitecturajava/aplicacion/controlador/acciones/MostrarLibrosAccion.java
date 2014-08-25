package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.aplicacion.servicios.impl.ServicioLibrosImpl;
//import com.arquitecturajava.dao.CategoriaDAO;
//import com.arquitecturajava.dao.DAOAbstractFactory;
//import com.arquitecturajava.dao.DAOFactory;
//import com.arquitecturajava.dao.CategoriaDAOFactory;
//import com.arquitecturajava.dao.LibroDAO;
//import com.arquitecturajava.dao.LibroDAOFactory;


public class MostrarLibrosAccion extends Accion { 
	@Override 
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		//SIn Principio DRY se usaban cada una pero con la FactoriaAbstract son las buenas
		//CategoriaDAO categoriaDAO = CategoriaDAOFactory.getInstance(); 
		//LibroDAO libroDAO= LibroDAOFactory.getInstance(); 
		////////////////////////////////////////////////////////////////////
		//Con principio DRY y factorias, pero sin servicios
		//DAOFactory factoria=DAOAbstractFactory.getInstance();
		//CategoriaDAO categoriaDAO= factoria.getCategoriaDAO(); 
		//LibroDAO libroDAO=factoria.getLibroDAO();  
		//List<Libro> listaDeLibros = libroDAO.buscarTodos(); 
		//List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		////////////////////////////////////////////////////////////////////
		
		//Con principio DRY y factorias spring, y  servicios no spring
		//ServicioLibros servicioLibros= new ServicioLibrosImpl(); 
		//List<Libro> listaDeLibros = servicioLibros.buscarTodosLosLibros(); 
		//List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros(); 
		////////////////////////////////////////////////////////////////////
		
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros", request); 
		List<Libro> listaDeLibros = servicio.buscarTodosLosLibros(); 
		List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros(); 
		     
		request.setAttribute("listaDeLibros", listaDeLibros); 
		request.setAttribute("listaDeCategorias", listaDeCategorias); 
		return "MostrarLibros.jsp"; 
	} 
}


