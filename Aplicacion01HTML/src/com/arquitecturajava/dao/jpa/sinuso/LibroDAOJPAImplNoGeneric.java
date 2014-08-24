


package com.arquitecturajava.dao.jpa.sinuso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.jpa.JPAHelper;

public class LibroDAOJPAImplNoGeneric implements LibroDAO { 
	
	 public void insertar(Libro libro) { 
	    EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	    EntityManager manager = factoriaSession.createEntityManager(); 
	    EntityTransaction tx = null; 
	    try { 
	      tx=manager.getTransaction(); 
	      tx.begin();           
	      manager.merge(libro); 
	      tx.commit(); 
	    } catch (PersistenceException e) { 
	      manager.getTransaction().rollback(); 
	      throw e; 
	    } finally { 
	      manager.close(); 
	    } 
	  }   
	  public void borrar(Libro libro) { 
	    EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	    EntityManager manager = factoriaSession.createEntityManager(); 
	    EntityTransaction tx = null; 
	    try { 
	      tx=manager.getTransaction(); 
	      tx.begin();           
	      manager.remove(manager.merge(libro)); 
	      tx.commit(); 
	    } catch (PersistenceException e) { 
	      manager.getTransaction().rollback(); 
	      throw e; 
	    } finally { 
	      manager.close(); 
	    }
	  } 
	  public void salvar(Libro libro) { 
	    EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	    EntityManager manager = factoriaSession.createEntityManager(); 
	    EntityTransaction tx = null; 
	    try { 
	      tx=manager.getTransaction(); 
	      tx.begin();           
	      manager.merge(libro); 
	      tx.commit(); 
	    } catch (PersistenceException e) { 
	      manager.getTransaction().rollback(); 
	      throw e; 
	    } finally { 
	        manager.close(); 
	      } 
	    } 
	    public  List<Libro> buscarTodos() { 
	      EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	      EntityManager manager = factoriaSession.createEntityManager(); 
	      TypedQuery<Libro> consulta = manager.createQuery( 
	          "Select l from Libro l", Libro.class); 
	      List<Libro> listaDeLibros = null; 
	      try { 
	        listaDeLibros = consulta.getResultList(); 
	      } finally { 
	        manager.close(); 
	      } 
	      return listaDeLibros; 
	    } 
	    public  Libro buscarPorClave(String isbn) { 
	   
	      EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	      EntityManager manager = factoriaSession.createEntityManager(); 
	      TypedQuery<Libro> consulta = manager.createQuery( 
	          "Select l from Libro l where l.isbn=?1", Libro.class); 
	      consulta.setParameter(1, isbn); 
	      Libro libro = null; 
	      try { 
	        libro = consulta.getSingleResult(); 
	      } finally { 
	        manager.close(); 
	      } 
	      return libro; 
	    } 
	    public  List<Libro> buscarPorCategoria(Categoria categoria) { 
	      EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
	      EntityManager manager = factoriaSession.createEntityManager(); 
	      TypedQuery<Libro> consulta = manager.createQuery( 
	          "Select l from Libro l where l.categoria=?1", Libro.class); 
	      consulta.setParameter(1, categoria); 
	      List<Libro> listaDeLibros = null; 
	      try { 
	        listaDeLibros = consulta.getResultList(); 
	      } finally { 
	        manager.close(); 
	      } 
	      return listaDeLibros; 
	    } 
	
}
