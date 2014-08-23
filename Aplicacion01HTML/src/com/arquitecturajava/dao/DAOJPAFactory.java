package com.arquitecturajava.dao;

import com.arquitecturajava.dao.jpa.CategoriaDAOJPAImpl;
import com.arquitecturajava.dao.jpa.LibroDAOJPAImpl;

public class DAOJPAFactory implements DAOFactory {

	 public CategoriaDAO getCategoriaDAO() { 
	    return new CategoriaDAOJPAImpl(); 
	 } 
	 public LibroDAO getLibroDAO() { 
	    return new LibroDAOJPAImpl(); 
	 } 	
} 
