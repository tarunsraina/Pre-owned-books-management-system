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
import java.util.Random;

public class SellHandwrittenBooks extends JFrame implements ActionListener
{
	JTextField InstructorField;
	JTextField SemesterField;
	JTextField SubjectField;
	JTextField PriceField;
	JTextField SellerIDField;
	JTextField NotesIdField;
	JButton submitButton,Backbtn;
	SellHandwrittenBooks()
    {
		
		this.setBounds(175, 50, 180,31);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Backbtn.setBounds(224, 493, 85, 23);
		Backbtn.setBackground(Color.white);
		this.add(Backbtn);
		Backbtn.addActionListener(this);
		
		Label label = new Label("Please Enter the Details");
		label.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		label.setBackground(Color.white);
		label.setBounds(180, 60, 217, 22);
		this.add(label);
		
		Label label_1 = new Label("Subject");
		label_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1.setBounds(54, 120, 128, 22);
		this.getContentPane().add(label_1);
		
		SubjectField = new JTextField();
		SubjectField.setBounds(206, 120, 183, 20);
		this.getContentPane().add(SubjectField);
		SubjectField.setColumns(10);
		
		
		Label label_1_1 = new Label("Instructor");
		label_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1_1.setBounds(54, 162, 128, 22);
		this.getContentPane().add(label_1_1);
		
		Label label_1_1_1 = new Label("Semester");
		label_1_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1_1_1.setBounds(54, 205, 128, 22);
		this.getContentPane().add(label_1_1_1);
		
		Label label_1_1_1_1 = new Label("Price");
		label_1_1_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1_1_1_1.setBounds(54, 244, 128, 22);
		this.getContentPane().add(label_1_1_1_1);
		
		Label label_1_1_1_1_1 = new Label("Your-ID");
		label_1_1_1_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1_1_1_1_1.setBounds(54, 284, 128, 22);
		this.getContentPane().add(label_1_1_1_1_1);
		
		Label label_1_1_1_1_2 = new Label("Book-ID");
		label_1_1_1_1_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label_1_1_1_1_2.setBounds(54, 327, 128, 22);
		this.getContentPane().add(label_1_1_1_1_2);
		
		InstructorField = new JTextField();
		InstructorField.setColumns(10);
		InstructorField.setBounds(206, 162, 183, 20);
		this.getContentPane().add(InstructorField);
		
		SemesterField = new JTextField();
		SemesterField.setColumns(10);
		SemesterField.setBounds(206, 205, 183, 20);
		this.getContentPane().add(SemesterField);
		
		PriceField = new JTextField();
		PriceField.setColumns(10);
		PriceField.setBounds(206, 244, 183, 20);
		this.getContentPane().add(PriceField);
		
		SellerIDField = new JTextField();
		SellerIDField.setColumns(10);
		SellerIDField.setBounds(206, 284, 183, 20);
		this.getContentPane().add(SellerIDField);
		
		NotesIdField = new JTextField();
		NotesIdField.setColumns(10);
		NotesIdField.setBounds(206, 327, 183, 20);
		this.getContentPane().add(NotesIdField);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		submitButton.setBounds(145, 371, 89, 23);
		this.getContentPane().add(submitButton);
		submitButton.setBackground(Color.white);
		submitButton.addActionListener(this);
		
		
		this.getContentPane().setBackground(new Color(30,150,155));
		this.getContentPane().setBackground(Color.white);
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,0,2000,2000);
		this.getContentPane().add(l);
		this.setLayout(null);
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
			int seller_ID=Integer.parseInt(SellerIDField.getText());
			String price=PriceField.getText();
			String Instructor=InstructorField.getText();
			String Sem=SemesterField.getText();
			String subject=SubjectField.getText();
			int notes_ID=Integer.parseInt(NotesIdField.getText());
			int buyer_ID=-1;
			
		   // Connection connection=null;
		    String databaseName="pobms";
		    String url="jdbc:mysql://localhost:3306/"+ databaseName;
			String username="root";
			String password="ironman7";
			String sqlQuery;
			int x = 0;
			
			try {
	
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				sqlQuery=String.format("Insert into handwritten_notes values(%d,'%s','%s','%s','%s',%d,%d)",notes_ID,Sem,Instructor,subject,price,seller_ID,buyer_ID);
				 x=st.executeUpdate(sqlQuery);
				
				
	
				if(x>0)
				{
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis);
					String date1=""+date+"";
					int book_ID=-1;
					int points=10;
					Random rand=new Random();
					sqlQuery=String.format("Insert into history values(%d,%d,%d,'%s',%d,%d,%d);",book_ID+rand.nextInt(100000),book_ID,notes_ID,date1,seller_ID,buyer_ID,points);
					st.executeUpdate(sqlQuery);
					JOptionPane.showMessageDialog(null,"Handwritten notes Posted Successfully","Success",JOptionPane.PLAIN_MESSAGE);
					this.dispose();
					new SellerUI();
				}
			}
				
				catch(Exception exp)
				{
					System.out.println("Please enter valid details");
				}
			
		   }
		else if(e.getSource()==Backbtn)
		{
			this.dispose();
			new SellerUI();
		}
		
		
	}
}
