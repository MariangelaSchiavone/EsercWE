package com.uiip.controllers;

import com.uiip.model.UtenteModel;
import com.uiip.views.UtenteView;

public class UtenteController {
	
    private UtenteModel utenteModel;
    private UtenteView utenteView;

    public UtenteController(UtenteModel utenteModel, UtenteView utenteView) {
        this.utenteModel = utenteModel;
        this.utenteView = utenteView;
    }

    public void updateView(UtenteModel utenteModel){
		utenteView.setPerson(utenteModel);
	}
	
	public void updateModel(UtenteView utenteView){
		
		this.utenteModel = utenteView.getPerson();		
	}

	public UtenteView getUtenteView() {
		return utenteView;
	}

	public void setUtenteView(UtenteView utenteView) {
		this.utenteView = utenteView;
	}

	public UtenteModel getUtenteModel() {
		return utenteModel;
	}

	public void setUtenteModel(UtenteModel utenteModel) {
		this.utenteModel = utenteModel;
	}
}
