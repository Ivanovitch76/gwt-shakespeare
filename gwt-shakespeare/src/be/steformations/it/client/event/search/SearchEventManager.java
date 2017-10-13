package be.steformations.it.client.event.search;

import com.google.gwt.event.shared.EventHandler;

import be.steformations.it.client.event.reset.ResetEvent;

public interface SearchEventManager extends EventHandler{
	
	public void onSearch(SearchEvent event);

}
