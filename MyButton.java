package com.jelena.kviz2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {
	
	private String question;
	private String answer;
	public boolean clicked = false;
	int amount;
	
	public MyButton(String s) {
		super(s);
		setBackground(Color.GREEN);
		setFont(new Font("Arial", Font.BOLD, 40));
	}
	public MyButton (int vrednost, String q, String a) { //vezuje za dugme ponudjenu sumu, pitanje, odgovor;
		super(Integer.toString(vrednost));
		amount = vrednost;
		Color myColor = new Color (193, 255, 193);  //http://cloford.com/resources/colours/500col.htm
		setBackground(myColor);
		setFont(new Font("Arial", Font.BOLD, 12));
		question = q;
		answer = a;	
		setPreferredSize(new Dimension(300, 100));
	}
	
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	public int getAmount(){
		return amount;
	}
	


}


