package com.arquitecturajava.aplicacion.bo;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PrincipalHibernate {

	public static void main(String[] args) { 
	  Session session=null; 
	  Transaction transaccion =null; 
	  try { 
		//Ejemplo insert
	    SessionFactory factoria = new Configuration().configure().buildSessionFactory(); 
	    session = factoria.openSession(); 
	    transaccion = session.beginTransaction();
	    //Se comenta por qeu se ha llevado las funciones a las implemetacion de las factorias, pero valdria con volver a meter aqui las funciones
	    //El problema es qeu las funciones de Hibernate y las de JPA son diferentes, de ahi que se haya cambiado todo
	    //List<Categoria> categoria = Categoria.buscarTodos();
	    //Libro lib= new Libro("2","java",categoria.get(0)); 
	    //session.saveOrUpdate(lib); 
	    transaccion.commit();     
	
		//Ejemplo seleccionar todos, pero hibernate hace una query por cada getcategoria.getdescripcion ademas de  la de los libros
	    Query consulta= session.createQuery("from Libro libro"); 
	    List<Libro> lista= consulta.list(); 
	    for(Libro l: lista) { 
	        System.out.println("----Todos Libros:" + l.getIsbn()+"---"+l.getTitulo()+"---"+l.getCategoria().getDescripcion()); 
	    } 
	    
		//Ejemplo seleccionar todos, y que hibernate haga nada mas qeu una sola select por todos los libros
	    List<Libro> listaDeLibros = session.createQuery("from Libro libro  right join fetch libro.categoria").list(); 
	    for(Libro l: listaDeLibros) { 
	        System.out.println("----Todos Libros:" + l.getIsbn()+"---"+l.getTitulo()+"---"+l.getCategoria().getDescripcion()); 
	    } 

	    
	  	    
		//Ejemplo seleccionar  un Libro
	    Libro libro=(Libro) session.get(Libro.class,"1");     
	    System.out.println("----titulo:"+libro.getTitulo()); 
	    
	    
	    //Ejemplo Borrar Libro:
	    Libro librob=(Libro) session.get(Libro.class,"1"); 
	    session.delete(librob);     
	    
	    
	    //Ejemplo filtrar Libro
	    Query consultaF = session.createQuery(" from Libro libro where libro.categoria=:categoria"); 
	    consultaF.setString("categoria", "programacion"); 
        List<Libro> listalib = consultaF.list(); 
        for (Libro l : listalib) { 
	        System.out.println("---Lista Filtrada:"+l.getIsbn()+"---"+l.getTitulo()+"---"+l.getCategoria()); 
        } 
	    
	    
	    
	  }catch(HibernateException e) { 
	    System.out.println(e.getMessage());        
	  }finally { 
	    session.close(); 
	  } 
}
	
}
