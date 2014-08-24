package com.arquitecturajava.mensajes;

public class MensajeHTML implements Mensaje { 
	  @Override 
	  public void hola() { 
	    System.out.println("<html>hola</html>"); 
	  } 
} 