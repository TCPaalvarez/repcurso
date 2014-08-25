package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class FormularioInsertarLibroAccion extends Accion { 
	@Override
  	public String ejecutar(HttpServletRequest request,   HttpServletResponse response) { 
		ServicioLibros servicio = (ServicioLibros) getBean("servicioLibros"); 
		List<Categoria> listaDeCategorias = servicio.buscarCategoriasLibros(); 
    	request.setAttribute("listaDeCategorias", listaDeCategorias); 
    	return "FormularioInsertarLibro.jsp"; 
	} 
} 


