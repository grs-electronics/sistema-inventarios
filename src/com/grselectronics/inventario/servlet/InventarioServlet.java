package com.grselectronics.inventario.servlet;

import javax.servlet.ServletException;

import com.grselectronics.inventario.session.InventarioSessionListener;
import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
public class	 InventarioServlet extends VaadinServlet	{
	@Override
	protected void servletInitialized() throws ServletException {
		super.servletInitialized();
        getService().addSessionInitListener(new InventarioSessionListener());		
	}
}
