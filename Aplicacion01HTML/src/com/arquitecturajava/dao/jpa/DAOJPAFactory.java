package com.arquitecturajava.dao.jpa;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public class DAOJPAFactory  { 
	  public CategoriaDAO getCategoriaDAO() { 
	    return new CategoriaDAOJPAImpl(); 
	  } 
	  public LibroDAO getLibroDAO() { 
	    return new LibroDAOJPAImpl(); 
	  } 
} 