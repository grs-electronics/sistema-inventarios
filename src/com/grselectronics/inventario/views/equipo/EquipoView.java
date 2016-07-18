package com.grselectronics.inventario.views.equipo;


import java.util.Locale;

import org.vaadin.gridutil.cell.GridCellFilter;
import org.vaadin.gridutil.converter.SimpleStringConverter;
import org.vaadin.gridutil.renderer.BooleanRenderer;
import org.vaadin.gridutil.renderer.EditButtonValueRenderer;
import org.vaadin.gridutil.renderer.EditDeleteButtonValueRenderer;
import org.vaadin.gridutil.renderer.IndicatorRenderer;

import com.google.gwt.aria.client.Property;
import com.grselectronics.inventario.bean.Equipo;
import com.grselectronics.inventario.controller.HibernateUtil;
import com.grselectronics.inventario.event.DashboardEventBus;
import com.vaadin.client.renderers.ClickableRenderer.RendererClickEvent;
import com.vaadin.client.renderers.DateRenderer;
import com.vaadin.data.hbnutil.HbnContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ClickableRenderer.RendererClickListener;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings({ "serial", "unchecked" })
public class EquipoView extends Panel implements View{
	public static final String EDIT_ID = "dashboard-edit";
	public static final String TITLE_ID = "dashboard-title";
	private final VerticalLayout root;
	private Label titleLabel;
	private CssLayout dashboardPanels;
	public EquipoView() {
		addStyleName(ValoTheme.PANEL_BORDERLESS);
		setSizeFull();
		DashboardEventBus.register(this);
		root = new VerticalLayout();
		root.setSizeFull();
		root.setMargin(true);
		root.addStyleName("dashboard-view");
		setContent(root);
		Responsive.makeResponsive(root);
		root.addComponent(buildHeader());
		root.addComponent(buildSparklines());
		Component content = buildContent();
		root.addComponent(content);
		root.setExpandRatio(content, 1);
	}
	private Component buildSparklines() {
		CssLayout sparks = new CssLayout();
		sparks.addStyleName("sparks");
		sparks.setWidth("100%");
		Responsive.makeResponsive(sparks);
		return sparks;
	}
	private Component buildHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);
        titleLabel = new Label("Equipo");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);
        return header;
    }
	private GridCellFilter filter;

	private Component buildContent() {
        dashboardPanels = new CssLayout();
        dashboardPanels.addStyleName("dashboard-panels");
        Responsive.makeResponsive(dashboardPanels);
        Grid grid=genGrid();
        
        
        dashboardPanels.addComponent(grid);
        return dashboardPanels;
    }
	
	private void setColumnRenderes(final Grid grid) {
		
	}
	private Grid genGrid() {
		// init Grid
		final Grid grid = new Grid();
		grid.setSizeFull();

		// init Container
		
		grid.setContainerDataSource(new HbnContainer<Equipo>(Equipo.class, HibernateUtil.getInstancia().getSessionFactory()));
		grid.setColumns();
		/*initFilter(grid);
		initFooterRow(grid, container);
		initExtraHeaderRow(grid);

		initColumnAlignments(grid);*/
		return grid;
	}
	private void initFilter(final Grid grid){
		this.filter=new GridCellFilter(grid);
		this.filter.setNumberFilter("id");
		
	}
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}