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
		SessionFactory factoriaSession =  HibernateHelper.getSessionFactory(); 
		Session session = factoriaSession.openSession(); 
		List<Categoria> listaDeCategorias = session.createQuery( " from Categoria categoria").list(); 
		session.close(); 
		return listaDeCategorias; 
	} 
	public static Categoria buscarCategoria(String id) { 
		SessionFactory factoriaSession =  HibernateHelper.getSessionFactory(); 
		Session session = factoriaSession.openSession(); 
		Categoria categoria = (Categoria) session.get(Categoria.class,id);     
		session.close(); 
		return categoria; 
	} 
} 