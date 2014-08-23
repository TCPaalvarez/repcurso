package com.arquitecturajava.dao.hibernate;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;

public class DAOHibernateFactory { 
	  public CategoriaDAO getCategoriaDAO() { 
	    return new CategoriaDAOHibernateImpl(); 
	  } 
	  public LibroDAO getLibroDAO() { 
	    return new LibroDAOHibernateImpl(); 
	  } 
} 