package com.arquitecturajava.dao.jpa;

import java.util.List;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO { 
 
	public List<Libro> buscarTodos() { 
		return getJpaTemplate().find("SELECT l FROM Libro l JOIN FETCH l.categoria");
	} 
	
	public  List<Libro> buscarPorCategoria(Categoria categoria) { 
		return getJpaTemplate().find("SELECT l FROM Libro l JOIN FETCH l.categoria where l.categoria=" +  categoria.getId());
	} 
}
