package com.uiip.views;

import com.uiip.model.UtenteModel;

public class UtenteView {
	
	private UtenteModel utente;
	
	public UtenteView(UtenteModel utente){
		this.utente = utente;
	}
	
	public void printInfo(){
		System.out.println(utente.toString());
	}

	public UtenteModel getPerson() {
		return utente;
	}

	public void setPerson(UtenteModel utente) {
		this.utente = utente;
	}
}
