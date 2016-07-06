/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grselectronics.inventario.controller;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.grselectronics.inventario.bean.Usuario;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author retana
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static HibernateUtil instancia;
    public static HibernateUtil getInstancia(){
        return (instancia==null)?new HibernateUtil():instancia;
    }
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void add(Object obj){
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        sesion.save(obj);
        sesion.getTransaction().commit();
        sesion.close();
    }
    public void remove(Object obj){
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        sesion.delete(obj);
        sesion.getTransaction().commit();
        sesion.close();
    }
    public Object find(String id,Class<?> classs){
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        Object obj=sesion.get(classs, id);
        sesion.getTransaction().commit();
        sesion.close();
        return obj;
    }
    public Object find(int id,Class<?> classs){
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        Object obj=sesion.get(classs,id);
        sesion.getTransaction().commit();
        sesion.close();
        return obj;
    }
    public List<Object> sendQuery(String consulta){
        List<Object> resultado=new ArrayList<>();
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        resultado=sesion.createQuery(consulta).list() ;
        sesion.getTransaction().commit();
        sesion.close();
        return resultado;
    }
    public List<Object> sendSQLQuery(String consulta){
        List<Object> resultado=new ArrayList<>();
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        resultado=sesion.createSQLQuery(consulta).list() ;
        sesion.getTransaction().commit();
        sesion.close();
        return resultado;
    }
    public List<Object> autenticarUsuario(String email,String password){
        List<Object> resultado=new ArrayList<>();
        Session sesion=sessionFactory.openSession();
        sesion.beginTransaction();
        resultado=sesion.createSQLQuery("CALL sp_autenticarUsuario(:email,:pass);").addEntity(Usuario.class).setParameter("email", email).setParameter("pass", password).list() ;
        sesion.getTransaction().commit();
        sesion.close();
        return resultado;
    }
}
