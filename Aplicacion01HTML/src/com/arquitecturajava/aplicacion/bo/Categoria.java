package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	public Categoria() { 
		super(); 
	} 
	public Categoria(String id, String descripcion) { 
		super(); 
		this.id = id; 
		this.descripcion = descripcion; 
	} 	
} 