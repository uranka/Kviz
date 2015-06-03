package com.jelena.kviz2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeratorPanel extends ParentPanel implements ActionListener {
	
	private Igrac i1;
	private Igrac i2;
	private JLabel lblNaPotezu = new JLabel ("");
		
	private JLabel lblPoints = new JLabel ( " 0  ");
	private JButton b = new JButton("TACNO");
	private JButton b2 = new JButton("POGRESNO");	
	
	private JLabel lblPoints2 = new JLabel (" 0  ");	
	private JLabel lblKraj = new JLabel();
	
	
	public ModeratorPanel() {
		
		setLayout(new GridLayout(6,0,10,10));
		lblPoints.setFont(new Font("Arial", Font.BOLD, 20));
		lblPoints.setForeground(Color.RED);
		lblPoints2.setFont(new Font("Arial", Font.BOLD, 20));
		lblPoints2.setForeground(Color.BLUE);
		
		b.addActionListener(this);	
		b2.addActionListener(this);
		
		add(lblNaPotezu);		
		add (lblPoints);
		add (lblPoints2);
		add(b);
		add(b2);
		add(lblKraj);
					
		i1 = new Igrac("Crveni");//negde namesti unos imena igraca
		i2 = new Igrac("Plavi");	
		i1.setNaPotezu(true); 
		lblNaPotezu.setText("Na potezu je igrac: " + i1.getIme());		
		lblPoints.setText(i1.getIme() + ": 0 ");
		lblPoints2.setText(i2.getIme() + ": 0 ");
	}
			
	//UBACI PUSTANJE JEDNOG ZVUKA KAD POGODI I DRUGOG ZVUKA KAD POGRESI
	public void actionPerformed (ActionEvent e) {		
		if (e.getActionCommand()=="TACNO") {					
			
			if (i1.getNaPotezu()==true) {            //promena igraca na potezu i DODAJ POENE
				//da samo jednom moze da doda poene 
				if (ParentPanel.stanjeIgre == 1) {
					i1.addPoeni(ParentPanel.osvojenoPoena);
					ParentPanel.stanjeIgre = 0;
					lblPoints.setText(i1.getIme() + ": "+ i1.getPoeni());
					i1.setNaPotezu(false);
					i2.setNaPotezu(true);
					lblNaPotezu.setText("Na potezu je igrac: " + i2.getIme());
				}
			}
			else {
				if (ParentPanel.stanjeIgre == 1) {
					i2.addPoeni(ParentPanel.osvojenoPoena);
					ParentPanel.stanjeIgre = 0;
					lblPoints2.setText(i2.getIme() + ": "+  i2.getPoeni());
					i2.setNaPotezu(false);
					i1.setNaPotezu(true);
					lblNaPotezu.setText("Na potezu je igrac: " + i1.getIme());
				}
			}	
			
		}
		else {              //promena igraca na potezu i GRESKA (X pored broja poena)
			if (i1.getNaPotezu()==true) {
				if (ParentPanel.stanjeIgre == 1) {
					ParentPanel.stanjeIgre = 0;
					lblPoints.setText(i1.getIme() + ": "+ i1.getPoeni() + " X");
					i1.setNaPotezu(false);
					i2.setNaPotezu(true);
					lblNaPotezu.setText("Na potezu je igrac: " + i2.getIme());
				}
			}
			else {	
				if (ParentPanel.stanjeIgre == 1) {
					ParentPanel.stanjeIgre = 0;
					lblPoints2.setText(i2.getIme() + ": "+  i2.getPoeni() + " X");
					i2.setNaPotezu(false);
					i1.setNaPotezu(true);
					lblNaPotezu.setText("Na potezu je igrac: " + i1.getIme());
				}
			}										
		}
		
		//proverava da li je kraj, kraj igre je kad su sva polja otkrivena...dodala brojac do 6
		if (ParentPanel.isEnd() == true){   //ukini slusanje dugmica, posvetli ih ili ih zasivi!!!!!
			if (i1.getPoeni() > i2.getPoeni()) lblKraj.setText("Pobednik je " + i1.getIme()); 
			if (i2.getPoeni() > i1.getPoeni()) lblKraj.setText("Pobednik je " + i2.getIme());
			if (i1.getPoeni() == i2.getPoeni()) lblKraj.setText("Nereseno"); //bolje bi bio messagebox, sa jos dodatnim pitanjem hocete li novu igru
			//b.removeActionListener(this); 
			//b2.removeActionListener(this);			
			b.setEnabled(false);//ovo usivljuje
			b2.setEnabled(false);
			lblNaPotezu.setText("Kraj");
			
		}
		
			
	}
	
	
}

