package com.arquitecturajava.dao;

import java.util.List;
import com.arquitecturajava.aplicacion.bo.Categoria;

public interface CategoriaDAO {
	  public abstract List<Categoria> buscarTodos(); 
	  public abstract Categoria buscarPorClave(String id);

}
