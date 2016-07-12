package com.grselectronics.inventario.ui;


import java.util.List;

import com.google.common.eventbus.Subscribe;
import com.grselectronics.inventario.bean.Usuario;
import com.grselectronics.inventario.controller.HibernateUtil;
import com.grselectronics.inventario.event.DashboardEventBus;
import com.grselectronics.inventario.event.VProjectEvent.BrowserResizeEvent;
import com.grselectronics.inventario.event.VProjectEvent.UserLoginRequestEvent;
import com.grselectronics.inventario.views.LoginView;
import com.grselectronics.inventario.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;


@Theme("vproject")
@Widgetset("com.grselectronics.inventario.ui.widgetset.VprojectWidgetset")
@Title("Inventarios Dashboard")
@SuppressWarnings("serial")	
public class VProjectUI extends UI {
    private final DashboardEventBus dashboardEventbus = new DashboardEventBus();
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		DashboardEventBus.register(this);
		addStyleName(ValoTheme.UI_WITH_MENU);
		//setContent(new LoginView());
		actualizarContenido();
		Page.getCurrent().addBrowserWindowResizeListener(
                new BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(
                            final BrowserWindowResizeEvent event) {
                        DashboardEventBus.post(new BrowserResizeEvent());
                    }
                });
	}
	public static DashboardEventBus getDashboardEventbus() {
        return ((VProjectUI) getCurrent()).dashboardEventbus;
    }
	private void actualizarContenido(){
		Usuario usuario=(Usuario)VaadinSession.getCurrent().getAttribute(Usuario.class.getName());
		if(usuario!=null){
			this.setContent(new MainView());
			this.removeStyleName("loginview");
			this.getNavigator().navigateTo(getNavigator().getState());
		}else{
			this.setContent(new LoginView());
			this.addStyleName("loginview");
		}
	}
	@Subscribe
	public void userLoginRequested(final UserLoginRequestEvent evt){
		List users=HibernateUtil.getInstancia().autenticarUsuario(evt.getUserEmail(),evt.getPassword());
		if(users!=null && !users.isEmpty()){
			VaadinSession.getCurrent().setAttribute(Usuario.class.getName(), (Usuario)users.get(0));
			//Notification.show("Inicio de sesión","Notificación",Notification.TYPE_TRAY_NOTIFICATION);
			actualizarContenido();
		}else{
			Notification noty=new Notification("Verifique sus credenciales","<br/>Fallo al válidar credenciales ",Notification.TYPE_ERROR_MESSAGE);
			noty.setDelayMsec(10000);
			noty.setHtmlContentAllowed(true);
			noty.setPosition(Position.BOTTOM_CENTER);
			noty.setStyleName("tray dark small closable login-help");
			noty.show(Page.getCurrent());
		}
	}
}