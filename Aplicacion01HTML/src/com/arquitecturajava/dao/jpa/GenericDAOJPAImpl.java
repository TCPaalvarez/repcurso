package com.arquitecturajava.dao.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.lang.reflect.ParameterizedType;

import com.arquitecturajava.dao.GenericDAO;


//public abstract class GenericDAOJPAImpl<T, Id extends Serializable>implements GenericDAO<T, Id> { 
public abstract class GenericDAOJPAImpl<T, Id extends Serializable>extends	JpaDaoSupport implements  GenericDAO<T, Id> {
	private Class<T> claseDePersistencia; 
	
	@SuppressWarnings("unchecked") 
	public GenericDAOJPAImpl() { 
		this.claseDePersistencia = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	} 
	@Override 
	public T buscarPorClave(Id id) { 
		return getJpaTemplate().find(claseDePersistencia, id); 
	} 
	@SuppressWarnings("unchecked") 
	public List<T> buscarTodos() { 
		return getJpaTemplate().find("select o from " + claseDePersistencia.getSimpleName() + " o");
	} 
	public void borrar(T objeto) { 
		getJpaTemplate().remove(getJpaTemplate().merge(objeto));
	} 
	public void salvar(T objeto) { 
		getJpaTemplate().merge(objeto); 
	} 
	public void insertar(T objeto) { 
		getJpaTemplate().persist(objeto); 
	} 
} 


