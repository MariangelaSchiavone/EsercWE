package com.uiip.model;

public class UtenteModel {
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	private String telefono;
	private TelefonoModel telefonoModel;
	
	public UtenteModel(String nome, String cognome, String email, String indirizzo, String telefono,
			TelefonoModel telefonoModel) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.telefonoModel = telefonoModel;
	}
	
	public UtenteModel() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TelefonoModel getTelefonoModel() {
		return telefonoModel;
	}

	public void setTelefonoModel(TelefonoModel telefonoModel) {
		this.telefonoModel = telefonoModel;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome = ").append(nome).append("\n")
                .append("Cognome = ").append(cognome).append("\n")
                .append("Email = ").append(email).append("\n")
                .append("Indirizzo = ").append(indirizzo).append("\n")
                .append("Numero di telefono = ").append(telefono).append("\n")
                .append("Modello = ").append(telefonoModel.getModello());
        return sb.toString();
    }

}
