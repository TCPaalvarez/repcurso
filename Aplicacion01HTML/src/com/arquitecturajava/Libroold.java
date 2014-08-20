/*package com.arquitecturajava;

import java.sql.ResultSet;

public class Libroold{ 
	  public static ResultSet buscarTodasLasCategorias() { 
	    String consultaSQL = "select distinct(categoria) from Libros"; 
	    DataBaseHelper helper = new DataBaseHelper(); 
	    ResultSet rs = helper.seleccionarRegistros(consultaSQL); 
	    return rs; 
	  } 
	  public static  void insertar(String isbn, String titulo, String categoria) { 
	    String consultaSQL = "insert into Libros (isbn,titulo,categoria) values "; 
	    consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')"; 
	    DataBaseHelper helper = new DataBaseHelper(); 
	    helper.modificarRegistro(consultaSQL); 
	  } 
	  public static  ResultSet buscarTodos() { 
	    String consultaSQL = "select isbn,titulo,categoria from Libros"; 
	    DataBaseHelper helper = new DataBaseHelper(); 
	    ResultSet rs = helper.seleccionarRegistros(consultaSQL); 
	    return rs; 
	  }
	  
	  public static  void editar(String isbn, String titulo, String categoria) {} 
	  public static  void borrar(String isbn)  {}
	  
} 

*/