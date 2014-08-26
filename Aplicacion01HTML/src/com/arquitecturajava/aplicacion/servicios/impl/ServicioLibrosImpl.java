package com.arquitecturajava.aplicacion.servicios.impl;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
//Imports antes de spring
//import com.arquitecturajava.dao.DAOAbstractFactory;
//import com.arquitecturajava.dao.DAOFactory;


public class ServicioLibrosImpl implements ServicioLibros { 
	 
	private LibroDAO libroDAO=null; 
	private CategoriaDAO categoriaDAO=null; 
	public LibroDAO getLibroDAO() { 
		return libroDAO; 
	} 
	 
	public void setLibroDAO(LibroDAO libroDAO) { 
		this.libroDAO = libroDAO; 
	} 
	 
	public CategoriaDAO getCategoriaDAO() { 
		return categoriaDAO; 
	} 
	 
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) { 
		this.categoriaDAO = categoriaDAO; 
	} 
	
	public ServicioLibrosImpl() { 
		//Constructor antes de usar Spring
		//DAOFactory factoria= DAOAbstractFactory.getInstance(); 
		//libroDAO= factoria.getLibroDAO(); 
		//categoriaDAO=factoria.getCategoriaDAO();
		//////////////////////////////7
	
		//Ya no hace falta codigo de spring tras meterlo como propiedas inyectadas en el contextoActuacio
		//ClassPathXmlApplicationContext factoria = new ClassPathXmlApplicationContext("contextoAplicacion.xml"); 
		//libroDAO= (LibroDAO)factoria.getBean("libroDAO"); 
		//categoriaDAO=(CategoriaDAO)factoria.getBean("categoriaDAO"); 
	} 
	@Transactional 
	public void salvarLibro(Libro libro) { 
		libroDAO.salvar(libro); 
	} 
	@Transactional 
	public void borrarLibro(Libro libro) { 
		libroDAO.borrar(libro); 
	} 
	@Transactional 
	public List<Libro> buscarTodosLosLibros() { 
		return libroDAO.buscarTodos(); 
	} 
	@Transactional 
	public List<Categoria> buscarCategoriasLibros() { 
		return categoriaDAO.buscarTodos(); 
	} 
	@Transactional 
	public Libro buscarLibroPorClave(String isbn) { 
		return libroDAO.buscarPorClave(isbn); 
	} 
	@Transactional 
	public Categoria buscarCategoriaPorClave(String id) { 
		return categoriaDAO.buscarPorClave(id); 
	} 
	@Transactional 
	public List<Libro> buscarLibrosPorCategoria(String id) { 
		Categoria categoria= categoriaDAO.buscarPorClave(id); 
		return libroDAO.buscarPorCategoria(categoria); 
	} 
} 
