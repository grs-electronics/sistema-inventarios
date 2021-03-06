package com.grselectronics.inventario.views;

import com.grselectronics.inventario.views.dashboard.DashboardView;
import com.grselectronics.inventario.views.equipo.EquipoView;
import com.grselectronics.inventario.views.general.GeneralView;
import com.grselectronics.inventario.views.inventario.InventarioView;
import com.grselectronics.inventario.views.reporteria.ReporteriaView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum DashboardViewType {
	DASHBOARD(
			"dashboard",DashboardView.class, FontAwesome.HOME,true), 
	GENERAL(
			"General",GeneralView.class, FontAwesome.GEARS,true),
	EQUIPO(
			"Equipo",EquipoView.class, FontAwesome.BARCODE,true),
	INVENTARIO(
			"Inventario",InventarioView.class, FontAwesome.INBOX,true),
	REPORTERIA(
			"Reporteria",ReporteriaView.class, FontAwesome.BAR_CHART,true);
	private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;
    private DashboardViewType(final String viewName,
            final Class<? extends View> viewClass, final Resource icon,
            final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }
    public boolean isStateful() {
        return stateful;
    }
    public String getViewName() {
        return viewName;
    }
    public Class<? extends View> getViewClass() {
        return viewClass;
    }
    public Resource getIcon() {
        return icon;
    }
    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }    
}
