package com.grselectronics.inventario.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;

import com.grselectronics.inventario.controller.HibernateUtil;
import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.external.org.slf4j.LoggerFactory;

public class HibernateServletFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(HibernateServletFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		 logger.debug("Destroying HibernateServletFilter");
	        final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        
	        if (session.getTransaction().isActive())
	        {
	            logger.debug("Committing the final active transaction");
	            session.getTransaction().commit();
	        }

	        if (session.isOpen())
	        {
	            logger.debug("Closing the final open session");
	            session.close();
	        }
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	        try
	        {
	            logger.debug("Starting a database transaction");
	            session.beginTransaction();
	            
	            chain.doFilter(request, response);
	            
	            logger.debug("Committing the active database transaction");
	            session.getTransaction().commit();
	        }
	        catch (StaleObjectStateException e)
	        {
	            logger.error(e.toString());

	            if (session.getTransaction().isActive())
	            {
	                logger.debug("Rolling back the active transaction");
	                session.getTransaction().rollback();
	            }
	            
	            throw e;
	        }
	        catch (Throwable e)
	        {
	            logger.error(e.toString());
	            
	            if (session.getTransaction().isActive())
	            {
	                logger.debug("Rolling back the active transaction");
	                session.getTransaction().rollback();
	            }
	            
	            throw new ServletException(e);
	        }
	    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.debug("Initializing HibernateServletFilter");
	}

}
