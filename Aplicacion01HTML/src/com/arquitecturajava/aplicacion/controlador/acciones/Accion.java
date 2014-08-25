package com.arquitecturajava.aplicacion.controlador.acciones; 

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arquitecturajava.DataBaseException;
 
public abstract class Accion { 
  public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException;  
  
  
  public Object getBean(String nombre) { 
	  ClassPathXmlApplicationContext factoria = new ClassPathXmlApplicationContext("contextoAplicacion.xml"); 
	  return factoria.getBean(nombre); 
	} 
  
  
  public static Accion getAccion(String tipo) { 
	  Accion accion = null; 
	  try { 
	      //accion = (Accion) Class.forName(getPackage()+"."+tipo+"Accion").newInstance();
		 
		  accion = (Accion) Class.forName("com.arquitecturajava.aplicacion.controlador.acciones."+tipo+"Accion").newInstance(); 
	      } catch (InstantiationException e) {           
	        e.printStackTrace(); 
	      } catch (IllegalAccessException e) { 
	        e.printStackTrace(); 
	      } catch (ClassNotFoundException e) { 
	        e.printStackTrace(); 
	      } 
	      return accion; 
	    } 
  
} 
