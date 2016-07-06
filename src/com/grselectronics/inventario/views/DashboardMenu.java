package com.grselectronics.inventario.views;

import com.google.common.eventbus.Subscribe;
import com.grselectronics.inventario.bean.Usuario;
import com.grselectronics.inventario.component.ProfilePreferencesWindow;
import com.grselectronics.inventario.event.DashboardEventBus;
import com.grselectronics.inventario.event.VProjectEvent.ProfileUpdatedEvent;
import com.grselectronics.inventario.event.VProjectEvent.UserLoggedOutEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;


@SuppressWarnings({ "serial", "unchecked" })
public final class DashboardMenu extends CustomComponent{
	public static final String ID = "dashboard-menu";
    public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
    public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
    private static final String STYLE_VISIBLE = "valo-menu-visible";
    private Label notificationsBadge;
    private Label reportsBadge;
    private MenuItem settingsItem;
    public DashboardMenu(){
    	this.setPrimaryStyleName("valo-menu");
    	setId(ID);
    	setSizeUndefined();
    	DashboardEventBus.register(this);
    	setCompositionRoot(buildContent());
    }
    private Component buildContent() {
        final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName("no-vertical-drag-hints");
        menuContent.addStyleName("no-horizontal-drag-hints");
        menuContent.setWidth(null);
        menuContent.setHeight("100%");

        menuContent.addComponent(buildTitle());
       // menuContent.addComponent(buildUserMenu());
        //menuContent.addComponent(buildToggleButton());
        //menuContent.addComponent(buildMenuItems());

        return menuContent;
    }
    private Component buildTitle() {
        Label logo = new Label("GRS Inventario <strong>Dashboard</strong>",
                ContentMode.HTML);
        logo.setSizeUndefined();
        HorizontalLayout logoWrapper = new HorizontalLayout(logo);
        logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        logoWrapper.addStyleName("valo-menu-title");
        return logoWrapper;
    }
    private Usuario getCurrentUser() {
        return (Usuario) VaadinSession.getCurrent().getAttribute(
                Usuario.class.getName());
    }
    @Subscribe
    public void updateUserName(final ProfileUpdatedEvent event) {
        Usuario user = getCurrentUser();
        settingsItem.setText(user.getNombre());
    }
    private Component buildUserMenu() {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        final Usuario user= getCurrentUser();
        settingsItem = settings.addItem("", new ThemeResource(
                "img/profile-pic-300px.jpg"), null);
        updateUserName(null);
        settingsItem.addItem("Editar Perfil", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
                ProfilePreferencesWindow.open(user, false);
            }
        });
        settingsItem.addItem("Preferencias", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
                ProfilePreferencesWindow.open(user, true);
            }
        });
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", new Command() {
            @Override
            public void menuSelected(final MenuItem selectedItem) {
                DashboardEventBus.post(new UserLoggedOutEvent());
            }
        });
        return settings;
    }
}
