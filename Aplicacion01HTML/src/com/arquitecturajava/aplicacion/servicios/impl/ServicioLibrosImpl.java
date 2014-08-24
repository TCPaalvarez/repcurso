package com.arquitecturajava.aplicacion.servicios.impl;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;

public class ServicioLibrosImpl implements ServicioLibros { 
	 
	  private LibroDAO libroDAO=null; 
	  private CategoriaDAO categoriaDAO=null; 
	  public ServicioLibrosImpl() { 
	    DAOFactory factoria= DAOAbstractFactory.getInstance(); 
	    libroDAO= factoria.getLibroDAO(); 
	    categoriaDAO=factoria.getCategoriaDAO(); 
	  } 
	   
	  public void salvarLibro(Libro libro) { 
	    libroDAO.salvar(libro); 
	  } 
	  public void borrarLibro(Libro libro) { 
	    libroDAO.borrar(libro); 
	  } 
	  public List<Libro> buscarTodosLosLibros() { 
	    return libroDAO.buscarTodos(); 
	  } 
	  public List<Categoria> buscarCategoriasLibros() { 
	    return categoriaDAO.buscarTodos(); 
	  } 
	 
	  public Libro buscarLibroPorClave(String isbn) { 
	    return libroDAO.buscarPorClave(isbn); 
	  } 
	  public Categoria buscarCategoriaPorClave(String id) { 
	    return categoriaDAO.buscarPorClave(id); 
	  } 
	  public List<Libro> buscarLibrosPorCategoria(String id) { 
	    Categoria categoria= categoriaDAO.buscarPorClave(id); 
	    return libroDAO.buscarPorCategoria(categoria); 
	  } 
	} 
