package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;

import gwt.material.design.client.ui.MaterialButton;

public class SearchButton extends MaterialButton{

	@UiConstructor
	public SearchButton(String text) {
		GWT.log("SearchButton.SearchButton()");
		this.setText(text);
	}
	
}
