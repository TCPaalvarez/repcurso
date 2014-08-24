package com.arquitecturajava.aplicacion.servicios;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;

public interface ServicioLibros { 
	  public void salvarLibro(Libro libro);  
	  public void borrarLibro(Libro libro);  
	  public List<Libro> buscarTodosLosLibros();  
	  public List<Categoria> buscarCategoriasLibros(); 
	  public Libro buscarLibroPorClave(String isbn); 
	  public Categoria buscarCategoriaPorClave(String id); 
	  public List<Libro> buscarLibrosPorCategoria(String categoria); 
	} 
