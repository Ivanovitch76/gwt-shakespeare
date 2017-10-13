package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.reset.ResetEvent;
import be.steformations.it.client.event.reset.ResetEventManager;
import gwt.material.design.client.ui.MaterialTextBox;

public class SpeakerInput extends MaterialTextBox implements ResetEventManager{

	@UiConstructor
	public SpeakerInput(String label) {
		GWT.log("SpeakerInput.SpeakerInput()");
		this.setLabel(label);
		this.setText("hamlet");
		
		EventManager.getInstance().addHandler(ResetEvent.type, this);
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("SpeakerInput.onReset()");
		this.setText("hamlet");
		
	}

	
}
