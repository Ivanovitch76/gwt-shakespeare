package be.steformations.it.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class EventManager {
	
	private static EventManager instance = new EventManager(); // pour avoir une seule instance lors de laq transaction
	private HandlerManager handlerManager;
	
	public static EventManager getInstance(){
		return instance;
	}
	
	private EventManager(){
		super();
		GWT.log("EventManager.EventManager()");
		this.handlerManager = new HandlerManager(this);
	}

	public <H extends EventHandler> HandlerRegistration addHandler(Type<H> type, H handler) {
		GWT.log("EventManager.addHandler(" + handler.getClass().getName() +")");
		return handlerManager.addHandler(type, handler);
	}

	public void fireEvent(GwtEvent<?> event) {
		GWT.log("EventManager.fireEvent(" + event.getClass().getName() +")");
		handlerManager.fireEvent(event);
	}
	
	
}
