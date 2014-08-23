package com.arquitecturajava.dao;

import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;

public class DAOHibernateFactory implements DAOFactory {
	
	  public CategoriaDAO getCategoriaDAO() { 
		    return new CategoriaDAOHibernateImpl(); 
		  } 
		  public LibroDAO getLibroDAO() { 
		    return new LibroDAOHibernateImpl(); 
		  } 
	
}
