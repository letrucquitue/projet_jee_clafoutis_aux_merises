package org.tutorial;

public class Machine {
	private String nom;
	private String type;

	/*
	 * public enum Type { Serveur, PareFeux, Routeur}
	 */

	public Machine(String n, String t) {
		this.nom = n;
		this.type = t;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		this.type = t;
	}

}
