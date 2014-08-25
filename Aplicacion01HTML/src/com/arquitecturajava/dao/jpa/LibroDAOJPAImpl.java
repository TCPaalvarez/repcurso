package com.arquitecturajava.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO { 
 
	public List<Libro> buscarTodos() { 
	  	EntityManager manager =  getEntityManagerFactory().createEntityManager(); 
	     
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class); 
		return  consulta.getResultList(); 
	} 
	
  public  List<Libro> buscarPorCategoria(Categoria categoria) { 
	  	EntityManager manager =  getEntityManagerFactory().createEntityManager(); 
   
    TypedQuery<Libro> consulta = manager.createQuery("Select l from Libro l where l.categoria=?1",Libro.class); 
    consulta.setParameter(1, categoria.getId()); 
    List<Libro> listaDeLibros = null; 
    try { 
      listaDeLibros = consulta.getResultList(); 
    } finally { 
      manager.close(); 
    } 
    return listaDeLibros; 
  } 
}
