package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OurHistory extends JFrame implements ActionListener
{
	JButton btnAvailableBooks,btnSoldBooks;
	OurHistory()
	{
		this.setVisible(true);
		this.setSize(2000,2000);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		btnAvailableBooks = new JButton("Available Books");
		btnAvailableBooks.setBackground(Color.WHITE);
		btnAvailableBooks.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnAvailableBooks.setBounds(734, 247, 221, 49);
		btnAvailableBooks.setFocusable(false);
		getContentPane().add(btnAvailableBooks);
		btnAvailableBooks.addActionListener(this);
		
		btnSoldBooks = new JButton("Sold Books");
		btnSoldBooks.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnSoldBooks.setBackground(Color.WHITE);
		btnSoldBooks.setBounds(734, 380, 221, 49);
		btnSoldBooks.setFocusable(false);
		getContentPane().add(btnSoldBooks);
		btnSoldBooks.addActionListener(this);
		
		
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,0,2000,2000);
		getContentPane().add(l);
		this.getContentPane().add(l);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnAvailableBooks)
		{
			this.dispose();
			new AvailableBooksTable();
		}
		else if(e.getSource()==btnSoldBooks)
		{
			this.dispose();
			new SoldBooksTable();
		}
		
	}
}
