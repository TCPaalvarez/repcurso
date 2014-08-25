package com.arquitecturajava.dao.jpa.sinuso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.jpa.sinuso.JPAHelper;

public class CategoriaDAOJPAImplNoGeneric  implements CategoriaDAO {

	public List<Categoria> buscarTodos() { 
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Categoria> consulta = manager.createQuery( "SELECT c FROM Categoria c", Categoria.class); 
		List<Categoria> listaDeCategorias = null; 
		listaDeCategorias = consulta.getResultList(); 
		manager.close(); 
		return listaDeCategorias; 
	} 
	public Categoria buscarPorClave(String id) { 
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Categoria> consulta = manager.createQuery("Select c from Categoria c where c.id=?1", Categoria.class); 
		consulta.setParameter(1, id); 
		Categoria categoria = null; 
		categoria = consulta.getSingleResult(); 
		manager.close(); 
		return categoria; 
	} 
}
