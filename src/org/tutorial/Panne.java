package org.tutorial;

import java.util.Date;

public class Panne {
	private Date date;
	private String type;
	private Machine machine;
	private boolean reparee;

	/*
	 * public enum Type { Reseau, CrashDisque, ProblemeMemoire }
	 */

	public Panne(Date d, String t, Machine m, boolean b) {
		this.date = d;
		this.type = t;
		this.machine = m;
		this.reparee = b;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date d) {
		this.date = d;
	}

	public String getType() {
		return type;
	}

	public void setType(String t) {
		this.type = t;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine m) {
		this.machine = m;
	}

	public boolean isReparee() {
		return reparee;
	}

	public void setReparee(boolean b) {
		this.reparee = b;
	}

}
