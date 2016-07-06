package com.grselectronics.inventario.event;

import java.io.Serializable;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.grselectronics.inventario.ui.VProjectUI;

public class DashboardEventBus implements SubscriberExceptionHandler, Serializable{
	private final EventBus eventBus=new EventBus(this);
	public static void post(final Object object){
		VProjectUI.getDashboardEventbus().eventBus.post(object);
	}
	
 public static void register(final Object object) {
        VProjectUI.getDashboardEventbus().eventBus.register(object);
    }

    public static void unregister(final Object object) {
    	VProjectUI.getDashboardEventbus().eventBus.unregister(object);
    }
	@Override
	public void handleException(Throwable exception, SubscriberExceptionContext context) {
	}
}
