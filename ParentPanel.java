package com.jelena.kviz2;

import javax.swing.JPanel;

public class ParentPanel extends JPanel{
	//gde se postavljaju pocetne vrednosti, verovatno i jesu nule po difoltu, postavila ih u Test.java
	protected static int osvojenoPoena; //informacija koliko poena nosi tacan odgovor na trenutno otvoreno dugme
	protected static int brojac;
	protected static int stanjeIgre;//0 - cekan na otvaranje pitanja, 1- otvoreno pitanje, 2 - kraj=0
	//vidi da ovo stavis u neki enum
	
	public static boolean isEnd (){
		System.out.println("ParentPanel.brojac = " + ParentPanel.brojac);//kontrola
		if (ParentPanel.brojac == 6) return true;
		else return false;
	}	
	
}
