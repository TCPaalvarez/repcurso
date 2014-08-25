package com.arquitecturajava.aplicacion.servicios;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public interface ServicioLibros {
	
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libroDAO) ;
	public CategoriaDAO getCategoriaDAO();    
	public void setCategoriaDAO(CategoriaDAO categoriaDAO); 
	
	public void salvarLibro(Libro libro);  
	public void borrarLibro(Libro libro);  
	public List<Libro> buscarTodosLosLibros();  
	public List<Categoria> buscarCategoriasLibros(); 
	public Libro buscarLibroPorClave(String isbn); 
	public Categoria buscarCategoriaPorClave(String id); 
	public List<Libro> buscarLibrosPorCategoria(String categoria); 
	  
} 
