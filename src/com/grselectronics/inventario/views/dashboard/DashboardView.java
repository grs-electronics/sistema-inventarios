package com.grselectronics.inventario.views.dashboard;

import com.grselectronics.inventario.event.DashboardEventBus;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class DashboardView extends Panel implements View {
	public static final String EDIT_ID = "dashboard-edit";
	public static final String TITLE_ID = "dashboard-title";

	private Label titleLabel;
	private CssLayout dashboardPanels;
	private final VerticalLayout root;
	private Window notificationsWindow;

	public DashboardView() {
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

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

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

        titleLabel = new Label("Dashboard");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);
        return header;
    }
	
	private Component buildContent() {
        dashboardPanels = new CssLayout();
        dashboardPanels.addStyleName("dashboard-panels");
        Responsive.makeResponsive(dashboardPanels);

        return dashboardPanels;
    }
	 
}
