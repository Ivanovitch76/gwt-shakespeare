package be.steformations.it.client.event.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent;

public class SearchEvent extends GwtEvent<SearchEventManager>{

	public final static GwtEvent.Type<SearchEventManager> type = new GwtEvent.Type<SearchEventManager>();	
	
	private SearchParams params;
	
	public SearchEvent(SearchParams params) {
		super();
		this.params = params;
	}
	
	public SearchParams getParams() {
		return params;
	}

	@Override
	public GwtEvent.Type<SearchEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(SearchEventManager handler) {
		GWT.log("SearchEvent.dispatch() => " + handler);
		handler.onSearch(this);
		
	}

}
