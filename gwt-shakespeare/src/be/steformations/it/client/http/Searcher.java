package be.steformations.it.client.http;

import java.nio.ByteBuffer;

import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpParser.RequestHandler;
import org.eclipse.jetty.http.HttpVersion;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.search.SearchEvent;
import be.steformations.it.client.event.search.SearchEventManager;
import be.steformations.it.client.event.search.SearchParams;

public class Searcher implements SearchEventManager, RequestCallback {

	private RequestBuilder requestBuilder;
	private SearchParamsObjectMapper mapper;
	
	public Searcher() {
		super();
		String url = Window.Location.getPath().replaceAll("/index.html", "");
		url += "/json/service";
		this.requestBuilder = new RequestBuilder(RequestBuilder.POST, url);
		this.mapper = GWT.create(SearchParamsObjectMapper.class);
		EventManager.getInstance().addHandler(SearchEvent.type, this);
		this.requestBuilder.setCallback(this);
	}
	
	@Override
	public void onSearch(SearchEvent event) {
		SearchParams params = event.getParams();
		GWT.log("Searcher.onSearch() => " + params);
		String json = this.mapper.write(params);
		this.requestBuilder.setRequestData(json);
		try{
			this.requestBuilder.send();
		} catch(Exception e){
			Window.alert(e.getMessage());
		}
		
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		GWT.log("Searcher.onResponseReceived()");
		String monologue = response.getText();
		Window.alert(monologue);
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
		GWT.log("Searcher.onError()");
		
	}



}
