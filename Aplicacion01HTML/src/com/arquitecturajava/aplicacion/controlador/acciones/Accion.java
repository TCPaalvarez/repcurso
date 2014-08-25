package com.arquitecturajava.aplicacion.controlador.acciones; 

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.arquitecturajava.DataBaseException;
 
public abstract class Accion { 
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws DataBaseException;  
	/*Clase spring clasica no valida para web 
  	public Object getBean(String nombre) { 
		ClassPathXmlApplicationContext factoria = new ClassPathXmlApplicationContext("contextoAplicacion.xml"); 
	  	return factoria.getBean(nombre); 
	} */
	public Object getBean(String nombre,HttpServletRequest request) { 
		WebApplicationContext factoria = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext()); 
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
