package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.SwingConstants;


public class MyFrame extends JFrame implements ActionListener
{
	JButton SellerButton;
	JButton BuyerButton;
	JButton SellerLogin;
	JButton BuyerLogin;
	JPanel SellerPanel;
	JPanel BuyerPanel;
	JButton seeOurHistoryBtn;
MyFrame()
   {
	
	SellerLogin=new JButton("Seller Login");
	SellerLogin.setBackground(Color.white);
	SellerLogin.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
	SellerLogin.setBounds(621, 58, 222,23);
	SellerLogin.setFocusable(false);
	
	BuyerLogin = new JButton("Buyer Login");
	BuyerLogin.setBackground(Color.white);
	BuyerLogin.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
	BuyerLogin.setFocusable(false);
	BuyerLogin.setBounds(621, 116, 222, 23);
	
	SellerButton = new JButton("Seller Registration");
	SellerButton.setBackground(Color.white);
	SellerButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
	SellerButton.setBounds(584, 204, 304, 31);
	SellerButton.setFocusable(false);
	
	BuyerButton = new JButton("Buyer Registration");
	BuyerButton.setBackground(Color.white);
	BuyerButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
	BuyerButton.setBounds(584,282,304,31);
	BuyerButton.setFocusable(false);
	
	SellerButton.addActionListener(this);
	BuyerButton.addActionListener(this);
	SellerLogin.addActionListener(this);
	BuyerLogin.addActionListener(this);
	
	this.setTitle("PRE-OWNED BOOK STORE");
	this.setVisible(true);
	this.setSize(2000,2000);
	getContentPane().setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(true);
	getContentPane().add(BuyerButton);
    getContentPane().add(SellerButton);
    getContentPane().add(BuyerLogin);
    getContentPane().add(SellerLogin);
    
    seeOurHistoryBtn = new JButton("See Our History");
    seeOurHistoryBtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
    seeOurHistoryBtn.setBackground(Color.WHITE);
    seeOurHistoryBtn.setBounds(621, 402,222, 23);
    getContentPane().add(seeOurHistoryBtn);
    seeOurHistoryBtn.addActionListener(this);
   
	//this.getContentPane().setBackground(Color.white);
	ImageIcon img=new ImageIcon("bgLogo.jpg");
	JLabel l = new JLabel("",img,JLabel.CENTER);
	l.setBounds(0,0,2000,2000);
	this.getContentPane().add(l);
	
	getContentPane().setLayout(null);
	this.pack();
	this.setVisible(true);
	this.setSize(2000,2000);
	this.setResizable(true);
   
   }


@Override
public void actionPerformed(ActionEvent e) 
{
	if(e.getSource()==SellerButton)
	{
		this.dispose();
		new getSellerDetails();
		
	}
	else if(e.getSource()==BuyerButton)
	{
		this.dispose();
		new getBuyerDetails();
	}
	else if(e.getSource()==SellerLogin)
	{
		this.dispose();
		new SellerLoginVerification();
	}
	else if(e.getSource()==BuyerLogin)
	{
		this.dispose();
		new BuyerLoginVerification();
	}
	else if(e.getSource()==seeOurHistoryBtn)
	{
		this.dispose();
		new OurHistory();
	}
	
}
}
