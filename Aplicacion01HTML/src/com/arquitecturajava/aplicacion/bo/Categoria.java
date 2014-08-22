package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity 
@Table(name = "Categoria") 
public class Categoria { 
	@Id 
	private String id; 
	private String descripcion; 
	@OneToMany 
    @JoinColumn(name = "categoria") 	
	private List<Libro> listaDeLibros; 
	public int hashCode() { 
		return id.hashCode(); 
	} 
	@Override 
	public boolean equals (Object o) { 
		String categoriaId= ((Categoria)o).getId(); 
		return id.equals(categoriaId); 
	} 
	public String getId() { 
		return id; 
	} 
	public void setId(String id) { 
		this.id = id; 
	} 
	public String getDescripcion() { 
		return descripcion; 
	} 
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion; 
	} 
	public List<Libro> getListaDeLibros() { 
		return listaDeLibros; 
	} 
	public void setListaDeLibros(List<Libro> listaDeLibros) { 
	    this.listaDeLibros = listaDeLibros; 
	} 
	
	public static List<Categoria> buscarTodos() { 
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory(); 
		EntityManager manager = factoriaSession.createEntityManager(); 
		TypedQuery<Categoria> consulta = manager.createQuery( "SELECT c FROM Categoria c", Categoria.class); 
		List<Categoria> listaDeCategorias = null; 
		listaDeCategorias = consulta.getResultList(); 
		manager.close(); 
		return listaDeCategorias; 
	} 
	public static Categoria buscarCategoria(String id) { 
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