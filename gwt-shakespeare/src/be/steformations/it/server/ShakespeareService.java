package be.steformations.it.server;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.steformations.it.client.event.search.SearchParams;
import be.steformations.java_xml.shakespeare.MonologueSearcher;
import be.steformations.pc.xml.shakespeare.MonologueSearcherDom;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/json/service")
public class ShakespeareService extends HttpServlet{
	private MonologueSearcher searcher;
	private com.fasterxml.jackson.databind.ObjectMapper mapper;
	
	@Override
	public void init (ServletConfig config) throws ServletException{
		System.out.println("ShakespeareService.init()");
		super.init(config);
		this.searcher = new MonologueSearcherDom(); 
		this.mapper = new com.fasterxml.jackson.databind.ObjectMapper();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ShakespeareService.doPost()");
		
		SearchParams params = this.mapper.readerFor(SearchParams.class).readValue(req.getInputStream());
		String monologue = this.searcher.getMonologue(params.getPlay(), params.getSpeaker(), params.getStart());
		System.out.println("ShakespeareService.doPost() => " + monologue);
		resp.setContentType("text/plain");
		if(monologue != null){
			resp.getWriter().write(monologue);
		} else {
			resp.getWriter().write("Pas de monologue correspondant");
		}
		
	}
	
	
	
	
}
