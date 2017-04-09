package com.uiip.controllers;

import com.uiip.model.TelefonoModel;
import com.uiip.views.TelefonoView;

public class TelefonoController {
	private TelefonoView telefonoView;
	private TelefonoModel telefonoModel;
	
	public TelefonoController(TelefonoView telefonoView, TelefonoModel telefonoModel){		
		this.telefonoView = telefonoView;
		this.telefonoModel = telefonoModel;		
	}
		
	public void updateView(TelefonoModel telefonoModel){
		telefonoView.setPerson(telefonoModel);
	}
	
	public void updateModel(TelefonoView telefonoView){
		
		this.telefonoModel = telefonoView.getPerson();		
	}

	public TelefonoView getTelefonoView() {
		return telefonoView;
	}

	public void setTelefonoView(TelefonoView telefonoView) {
		this.telefonoView = telefonoView;
	}

	public TelefonoModel getTelefonoModel() {
		return telefonoModel;
	}

	public void setTelefonoModel(TelefonoModel telefonoModel) {
		this.telefonoModel = telefonoModel;
	}
}
