package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PrincipalJPA {

	
	public static void main (String args[]) {     
	    EntityManagerFactory emf= Persistence.createEntityManagerFactory("arquitectura"); 
	    EntityManager em=emf.createEntityManager(); 
	    TypedQuery<Libro> consulta= em.createQuery("Select l from Libro l",Libro.class); 
	    List<Libro> lista= consulta.getResultList(); 
	    for(Libro l: lista) {   
		      System.out.println(l.getTitulo() + "-" +l.getIsbn() + "-" + l.getCategoria().getDescripcion()); 
	    } 
	    
	    //Como crear un libro Java persistence //COmo ya tenemos creado EntityManagerFactory y EntityManager
	    Categoria categoria =null;

	    TypedQuery<Categoria> consultacat= em.createQuery("Select c from Categoria c ",Categoria.class); 
	    List<Categoria> categorialist= consultacat.getResultList(); 
	    
	    for(Categoria c: categorialist) {   
		     if (c.getDescripcion().equals("programacion"))
		    	 categoria=c;
	    } 

	    
	    
	    Libro libro= new Libro ("20","java",categoria); 
	    EntityTransaction tx = null; 
	    tx=em.getTransaction(); 
	    tx.begin();           
	    em.merge(libro); 
	    tx.commit(); 
	    //em.close(); 
	    
	    
	    consulta= em.createQuery("Select l from Libro l",Libro.class); 
	    lista= consulta.getResultList(); 
	    for(Libro l: lista) {   
	      System.out.println(l.getTitulo() + "-" +l.getIsbn() + "-" + l.getCategoria().getDescripcion()); 
	    } 
	    em.close();
	} 
	
}
