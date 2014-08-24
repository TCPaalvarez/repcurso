package com.arquitecturajava.mensajes;

public class Principal { 
	public static void main(String[] args) { 
		Mensaje mensaje= MensajeFactory.getMensaje(); 
		mensaje.hola(); 
	} 
} 