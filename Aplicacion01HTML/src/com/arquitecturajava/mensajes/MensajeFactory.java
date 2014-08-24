package com.arquitecturajava.mensajes;


import java.io.FileInputStream; 
import java.util.Properties; 
 
public class MensajeFactory { 
   
  public static Mensaje getMensaje(){ 
    Properties propiedades= new Properties(); 
    Mensaje mensaje=null; 
    try { 
      propiedades.load(new FileInputStream("mensaje.properties")); 
      String tipo=propiedades.getProperty("tipo"); 
      if (tipo.equals("html")) { 
        mensaje=new  MensajeHTML(); 
      }else { 
        mensaje= new MensajePlano(); 
      } 
       
    } catch (Exception e) { 
      e.printStackTrace(); 
    }  
    return mensaje; 
  } 
} 