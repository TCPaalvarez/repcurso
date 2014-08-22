package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity 
@Table(name = "Categoria") 
public class CategoriaHibernate { 
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
		String categoriaId= ((CategoriaHibernate)o).getId(); 
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
	public static List<CategoriaHibernate> buscarTodos() { 
		SessionFactory factoriaSession =  HibernateHelper.getSessionFactory(); 
		Session session = factoriaSession.openSession(); 
		List<CategoriaHibernate> listaDeCategorias = session.createQuery( " from Categoria categoria").list(); 
		session.close(); 
		return listaDeCategorias; 
	} 
	public static CategoriaHibernate buscarCategoria(String id) { 
		SessionFactory factoriaSession =  HibernateHelper.getSessionFactory(); 
		Session session = factoriaSession.openSession(); 
		CategoriaHibernate categoria = (CategoriaHibernate) session.get(CategoriaHibernate.class,id);     
		session.close(); 
		return categoria; 
	} 
} 