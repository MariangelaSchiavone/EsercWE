package com.uiip.model;

public class TelefonoModel {
	private String modello;
	private String size;
	private int weight;
	private String marca;
	
	
	
	public TelefonoModel() {}

	public TelefonoModel(String modello, String size, int weight, String marca) {
		super();
		this.modello = modello;
		this.size = size;
		this.weight = weight;
		this.marca = marca;
	}
	
	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
        sb.append("Modello = ").append(modello).append("\n")
                .append("Size = ").append(size).append("\n")
                .append("Weight = ").append(weight).append("\n")
                .append("Marca = ").append(marca);
        return sb.toString();
	}

}
