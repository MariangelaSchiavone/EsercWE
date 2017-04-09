package com.uiip.views;

import com.uiip.model.TelefonoModel;

public class TelefonoView {
	
	private TelefonoModel telefono;
	
	public TelefonoView(TelefonoModel telefono){
		this.telefono = telefono;
	}
	
	public void printInfo(){
		System.out.println(telefono.toString());
	}

	public TelefonoModel getPerson() {
		return telefono;
	}

	public void setPerson(TelefonoModel telefono) {
		this.telefono = telefono;
	}
}
