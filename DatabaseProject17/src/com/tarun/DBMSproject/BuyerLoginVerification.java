package com.tarun.DBMSproject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.*;

public class BuyerLoginVerification extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	JTextField BuyerIDField;
	JButton submitButton;
	JButton Registerbtn;
	public static int buyer_ID;
	BuyerLoginVerification()
    {
		this.setBounds(175, 50, 180,31);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Label label = new Label("Please Enter your Registered ID");
		label.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		label.setBounds(640, 92, 292, 48);
		getContentPane().add(label);
		
		BuyerIDField = new JTextField();
		BuyerIDField.setBounds(640, 174, 174, 32);
		getContentPane().add(BuyerIDField);
		
		Label label_1 = new Label("Not registered?");
		label_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		label_1.setBounds(640, 374, 174, 39);
		getContentPane().add(label_1);
		
		submitButton= new JButton("Submit");
		submitButton.setBackground(Color.white);
		submitButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		submitButton.setBounds(640, 235, 174, 39);
		submitButton.addActionListener(this);
		getContentPane().add(submitButton);
		
		
		Registerbtn=new JButton("Register Now!");
		Registerbtn.setBackground(Color.white);
		Registerbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Registerbtn.setBounds(640, 434,174,39);
    	getContentPane().add(Registerbtn);
    	Registerbtn.addActionListener(this);
    	
   
    	submitButton.addActionListener(this);
		this.getContentPane().setBackground(new Color(30,150,155));
		this.getContentPane().setBackground(Color.white);
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
		
		if(e.getSource()==submitButton)
		{
			 
			ResultSet rs;
		   // Connection connection=null;
		    String databaseName="pobms";
		    String url="jdbc:mysql://localhost:3306/"+ databaseName;
			String username="root";
			String password="ironman7";
			String sqlQuery;
			int count= 0;
			
			try {
	
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				if(BuyerIDField.getText().equals(""))
				{
			    		JOptionPane.showMessageDialog(null,"Enter valid Details","Error",JOptionPane.ERROR_MESSAGE);
			    		count=-1;
				}
				buyer_ID=Integer.parseInt(BuyerIDField.getText());
				sqlQuery=String.format("select buyer_ID from buyer where buyer_ID=%s",buyer_ID);
				rs=st.executeQuery(sqlQuery);
				while(rs.next())
				{
					count++;
				}
			    if(count==-1)
			    {
			    	this.dispose();
			    	new MyFrame();
			    }
			
				else if(count>0)
				{
					this.dispose();
					this.dispose();
					new BuyerUI();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Not Registred","Error",JOptionPane.ERROR_MESSAGE);
					this.dispose();
					new MyFrame();
				}
			}
			catch(Exception exp)
			{
				System.out.println(exp.getMessage());
			}
			
		   }
		else if(e.getSource()==Registerbtn)
		{
			this.dispose();
			new getBuyerDetails();
		}
		
		
	}
}
