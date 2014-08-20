package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import org.hibernate.HibernateException;


public class PrincipalCOC {

	
	public static void main(String[] args) { 
		  try { 
			    List<Categoria> categoria = Categoria.buscarTodos();
				Libro lib=new Libro("3","PruebaCOC",categoria.get(0));
				lib.insertar();
		  }catch(HibernateException e) { 
		    System.out.println(e.getMessage());        
		  }finally { 
				List <Libro> llibro=  Libro.buscarTodos();
				for(Libro l: llibro) { 
					System.out.println("----Todos Libros:" + l.getIsbn()+"---"+l.getTitulo()+"---"+l.getCategoria().getDescripcion()); 
				} 

		  } 
	}
}
