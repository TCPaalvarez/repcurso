package com.arquitecturajava.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;

import com.arquitecturajava.aplicacion.bo.HibernateHelper;
import com.arquitecturajava.dao.GenericDAO;

public abstract class GenericDAOHibernateImpl<T, Id extends Serializable> implements 
    GenericDAO<T, Id> { 
  private Class<T> claseDePersistencia; 
  @SuppressWarnings("unchecked") 
  public GenericDAOHibernateImpl() { 
	  this.claseDePersistencia=(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  } 
  @Override 
  public T buscarPorClave(Id id) { 
	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
	Session session = factoriaSession.openSession(); 
    T objeto = null; 
    try { 
      objeto = (T) session.get(claseDePersistencia, id); 
      return objeto; 
    } finally { 
    	session.close(); 
    } 
  } 
  @Override 
  public List<T> buscarTodos() { 
	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
	Session session = factoriaSession.openSession(); 
    List<T> listaDeObjetos = null; 
    try { 
	    Query consulta= session.createQuery("from " + claseDePersistencia.getSimpleName()+ " " + claseDePersistencia.getSimpleName().toLowerCase() ); 
	    listaDeObjetos= consulta.list(); 
	    return listaDeObjetos; 
    } finally { 
    	session.close(); 
    } 
  } 

  public void borrar(T objeto) { 
	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
	Session session = factoriaSession.openSession(); 
	Transaction transaccion = null; 
    try { 
    	transaccion = session.beginTransaction();
	    session.delete(objeto);     
	    transaccion.commit();     
      } catch (HibernateException e) { 
    	  transaccion.rollback();
        throw e; 
      } finally { 
    	  session.close(); 
      } 
    } 
    
  public void salvar(T objeto) { 
    	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
    	Session session = factoriaSession.openSession(); 
    	Transaction transaccion = null; 
      try { 
      	transaccion = session.beginTransaction();
  	    session.saveOrUpdate(objeto);     
  	    transaccion.commit();     
      } catch (HibernateException e) { 
    	  transaccion.rollback();
        throw e; 
      } finally { 
    	session.close(); 
      } 
    } 
    public void insertar(T objeto) { 
    	SessionFactory factoriaSession=HibernateHelper.getSessionFactory(); 
    	Session session = factoriaSession.openSession(); 
    	Transaction transaccion = null; 
      try { 
      	transaccion = session.beginTransaction();
  	    session.saveOrUpdate(objeto);     
  	    transaccion.commit();     
      } catch (HibernateException e) { 
    	  transaccion.rollback();
        throw e; 
      } finally { 
    	session.close(); 
      } 
    } 
} 
