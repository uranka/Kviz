package com.jelena.kviz2;

public class Igrac {
	
	private String ime;
	private boolean naPotezu;
	 //niz njegovih pitanja....
	private int poeni; //ukupno osvojenih poena
	
	public Igrac (String ime) {
		this.ime = ime;	
		naPotezu = false;
		poeni = 0;
	}
	
	public String getIme() {
		return ime;
	}
	
	public boolean getNaPotezu() {
		return naPotezu;
	}
	
	public void setNaPotezu(boolean p) {
		naPotezu = p;
	}
	
	public int getPoeni() {
		return poeni;
	}
	
	public void addPoeni(int p) {
		poeni = poeni + p;
	}
	
	

}
