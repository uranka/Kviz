package com.jelena.kviz2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends ParentPanel implements ActionListener {	
	
	
public MyPanel() {
	setLayout(new GridLayout(3,0,10,10));//3 vrste
	//baza pitanja i odgovora
	String[] sbq = {"Koji je glavni grad Srbije?", "Koji je glavni grad Crne Gore?",
			"Koji je glavni grad Hrvatske?","Koji je glavni grad Makedonije?", 
			"Koji je glavni grad Slovenije?", "Koji je glavni grad Bugarske?", 
			"Koji je glavni grad Albanije?", "Koji je glavni grad Madjarske?", 
			"Koji je glavni grad Austrije?", "Koji je glavni grad Francuske?"};
	String[] sba = {"Beograd", "Podgorica",
			"Zagreb","Skoplje",
			"Ljubljana", "Sofija",
			"Tirana", "Budimpesta", 
			"Bec", "Pariz"};

	
	//daje 6 razlicita slucajna broja na opsegu 0,...9 (pitanje 1, .. pitanje10)
	//slucajno smucka listu brojeva 0, 1,..9 i prikaze privih 6
	//time dobijam 6 razlicitih slucajnih brojeva odabranih od brojeva 0, 1,..9
	ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<10; i++) { 
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list); //shuffle randomly permutes the specified list 
	        for (int i=0; i<6; i++) {
	            System.out.println(list.get(i));
	        }
		
	//matrica slucajnih brojeva
	//Random rn = new Random();
	int[][] n = new int[3][2];
	int i =0;
	for(int row=0;row<3; row++) //3 vrste, 2 kolone dugmadi
	{
		for(int col=0;col<2;col++)
		{				
			//n[row][col] = rn.nextInt(10);
			n[row][col] = list.get(i); i++;
		}		
	}
	
	//pitanja
	String[][] sq = new String[3][2];
	for(int row=0;row<3; row++) //3 vrste, 2 kolone dugmadi
	{
		for(int col=0;col<2;col++)
		{	
			sq[row][col] = sbq [n[row][col]] ;
		}
	}
	//odgovori
	String[][] sa = new String[3][2];
	for(int row=0;row<3; row++) //3 vrste, 2 kolone dugmadi
	{
		for(int col=0;col<2;col++)
		{	
			sa[row][col] = sba [n[row][col]] ;
		}
	}

	
	
	for(int row=0;row<3; row++) //3 vrste, 2 kolone dugmadi
	{
		for(int col=0;col<2;col++)
		{			
			MyButton btn = new MyButton(100+100*row, sq[row][col], sa[row][col]);	//bez veze samo da budu razliciti poeni, treba to povezati sa tezinom pitanja ili pitanja na grupe laka srednaj i teska
			add (btn);
			btn.addActionListener(this);
		}
	}		
}


public void actionPerformed (ActionEvent e) {
	
	MyButton btnClicked = (MyButton) e.getSource(); // koje dugme je kliknuto vraca getSource		
	
	
	if (btnClicked.clicked == false){
		btnClicked.setText(btnClicked.getQuestion());
		btnClicked.clicked = true;
		ParentPanel.stanjeIgre = 1;
		ParentPanel.osvojenoPoena = btnClicked.getAmount();
		System.out.println("ParentPanel.osvojenoPoena="+ParentPanel.osvojenoPoena);//kontrola
		
		ParentPanel.brojac++;
	}
	else {
		btnClicked.setText(btnClicked.getAnswer());
	}	
}


}

