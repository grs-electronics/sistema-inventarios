package com.grselectronics.inventario.views;

import com.grselectronics.inventario.ui.DashboardNavigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class MainView extends HorizontalLayout	{
	public MainView(){
		this.setSizeFull();
		this.addStyleName("mainview");
		addComponent(new DashboardMenu());
		
		ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);

       new DashboardNavigator(content);
	}
}
