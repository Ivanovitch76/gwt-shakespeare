package be.steformations.it.client.result;

import com.google.gwt.event.shared.EventHandler;

public interface ResultEventManager extends EventHandler {

	void onResult(ResultEvent event);
}
