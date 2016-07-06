package com.grselectronics.inventario.ui;

import com.grselectronics.inventario.event.DashboardEventBus;
import com.grselectronics.inventario.event.VProjectEvent.BrowserResizeEvent;
import com.grselectronics.inventario.event.VProjectEvent.CloseOpenWindowsEvent;
import com.grselectronics.inventario.event.VProjectEvent.PostViewChangeEvent;
import com.grselectronics.inventario.views.DashboardViewType;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class DashboardNavigator extends Navigator{
	
	public DashboardNavigator(final ComponentContainer container) {
        super(UI.getCurrent(), container);

        /*String host = getUI().getPage().getLocation().getHost();
        if (TRACKER_ID != null && host.endsWith("demo.vaadin.com")) {
            initGATracker(TRACKER_ID);
        }*/
        initViewChangeListener();
        //initViewProviders();

    }
	 private void initViewChangeListener() {
	        addViewChangeListener(new ViewChangeListener() {

	            @Override
	            public boolean beforeViewChange(final ViewChangeEvent event) {
	                // Since there's no conditions in switching between the views
	                // we can always return true.
	                return true;
	            }

	            @Override
	            public void afterViewChange(final ViewChangeEvent event) {
	                DashboardViewType view = DashboardViewType.getByViewName(event
	                        .getViewName());
	                // Appropriate events get fired after the view is changed.
	                DashboardEventBus.post(new PostViewChangeEvent(view));
	                DashboardEventBus.post(new BrowserResizeEvent());
	                DashboardEventBus.post(new CloseOpenWindowsEvent());

	              /*  if (tracker != null) {
	                    // The view change is submitted as a pageview for GA tracker
	                    tracker.trackPageview("/dashboard/" + event.getViewName());
	                }*/
	            }
	        });
	    }
	 
}
