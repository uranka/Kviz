package com.jelena.kviz2;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame { 
	MyPanel p ;//premestene ovde da budu podaci clanovi klase Test
	ModeratorPanel pm;
	
	
	
	public Test() {
		super ("KVIZ");
		inic();		
	}
	private void inic() {
		Container contentPane = this.getContentPane();
		p = new MyPanel();
		contentPane.add(p, BorderLayout.WEST);	
		pm = new ModeratorPanel();
		contentPane.add(pm, BorderLayout.EAST);	
		
		setSize(1000,300);
		setVisible(true);
		ParentPanel.osvojenoPoena=0;
		ParentPanel.brojac=0;
		//ParentPanel.stanjeIgre = 0; 
	}
	
	
	

	public static void main(String[] args) {
		Test t = new Test();
	}

}
