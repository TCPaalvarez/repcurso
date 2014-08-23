package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.HibernateHelper;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO { 
 
	public List<Libro> buscarTodos() { 
		SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
		Session session = factoriaSession.openSession(); 
	    List<Libro> listaDeLibros = session.createQuery("from Libro libro  right join fetch libro.categoria").list(); 
		return listaDeLibros;
	} 
	
  public  List<Libro> buscarPorCategoria(Categoria categoria) { 
	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
	Session session = factoriaSession.openSession(); 

    Query consulta = session.createQuery(" from Libro libro right join fetch libro.categoria where libro.categoria=:categoria"); 
    consulta.setString("categoria",categoria.getId()); 
	
    List<Libro> listaDeLibros = null;
    try { 
    	listaDeLibros = consulta.list(); 
    } finally { 
    	session.close(); 
    } 
    return listaDeLibros; 
  } 
}
