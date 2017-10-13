package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.reset.ResetEvent;
import be.steformations.it.client.event.reset.ResetEventManager;
import be.steformations.it.client.result.ResultEvent;
import be.steformations.it.client.result.ResultEventManager;
import gwt.material.design.client.ui.MaterialLabel;

public class Output extends MaterialLabel implements ResetEventManager, ResultEventManager{
	public Output() {
		GWT.log("Output.Output()");
		
		EventManager.getInstance().addHandler(ResetEvent.type, this);
		EventManager.getInstance().addHandler(ResultEvent.type, this);
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("Output.onReset()");
		this.setText("");
	}

	@Override
	public void onResult(ResultEvent event) {
		GWT.log("Output.onResult()");
		this.setText(event.getMonologue());
		
	}
}
