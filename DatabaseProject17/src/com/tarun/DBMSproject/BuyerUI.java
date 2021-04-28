package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BuyerUI extends JFrame implements ActionListener
{
	JButton btnSearchAndBuyBook;
	JButton SearchAndBuyHandBookbtn;
	JButton Historybtn;
	JButton backbtn;
	JTextField PHField;
	JButton updateMobBtn;
	BuyerLoginVerification obj=new BuyerLoginVerification();
	int buyer_ID=obj.buyer_ID;
	BuyerUI()
	{

		this.getContentPane().setBackground(new Color(30,150,155));
		this.setVisible(true);
		this.setSize(2000,2000);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		
		btnSearchAndBuyBook = new JButton("Search and Buy Books");
		btnSearchAndBuyBook.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		btnSearchAndBuyBook.setBounds(744,179,200,23);
		btnSearchAndBuyBook.setBackground(Color.WHITE);
		btnSearchAndBuyBook.setFocusable(false);
		this.getContentPane().add(btnSearchAndBuyBook);
		
		SearchAndBuyHandBookbtn = new JButton("Search and Buy Handwritten Notes");
		SearchAndBuyHandBookbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		SearchAndBuyHandBookbtn.setBounds(689, 251, 329, 25);
		SearchAndBuyHandBookbtn.setBackground(Color.WHITE);
		SearchAndBuyHandBookbtn.setFocusable(false);
		this.getContentPane().add(SearchAndBuyHandBookbtn);
		
		PHField = new JTextField();
		PHField.setBounds(782, 486, 145, 20);
		this.getContentPane().add(PHField);
		PHField.setColumns(10);
		
		updateMobBtn = new JButton("Update My Mobile Number");
		updateMobBtn.setBackground(Color.WHITE);
		updateMobBtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		updateMobBtn.setBounds(758,529, 198, 23);
		getContentPane().add(updateMobBtn);
		updateMobBtn.setFocusable(false);
		updateMobBtn.addActionListener(this);
		
		Historybtn = new JButton("See my History");
		Historybtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Historybtn.setBounds(744, 329, 200, 25);
		Historybtn.setBackground(Color.WHITE);
		Historybtn.setFocusable(false);
		this.getContentPane().add(Historybtn);
		
		backbtn = new JButton("Back");
		backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		backbtn.setBackground(Color.WHITE);
		backbtn.setFocusable(false);
		backbtn.setBounds(763, 663, 193, 25);
		this.getContentPane().add(backbtn);
		
	
		
		Historybtn.addActionListener(this);
		SearchAndBuyHandBookbtn.addActionListener(this);
		btnSearchAndBuyBook.addActionListener(this);
		backbtn.addActionListener(this);
		
		
		this.getContentPane().setBackground(Color.white);
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,0,2000,2000);
		this.getContentPane().add(l);
		getContentPane().add(SearchAndBuyHandBookbtn);
		getContentPane().add(btnSearchAndBuyBook);
		getContentPane().add(Historybtn);
		getContentPane().add(backbtn);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		if(e.getSource()==SearchAndBuyHandBookbtn)
		{
			this.dispose();
			new searchAndBuyNotes();
		}
		else if(e.getSource()==btnSearchAndBuyBook)
		{
			this.dispose();
			new searchAndBuyBooks();
		}
		else if(e.getSource()==Historybtn)
		{
			this.dispose();
			new BuyerHistory();
		}
		else if(e.getSource()==backbtn)
		{
			this.dispose();
			new MyFrame();
		}
		else if(e.getSource()==updateMobBtn)
		{
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
				String phone=PHField.getText();
				sqlQuery=String.format("update buyer set phone_number='%s' where buyer_ID=%d",phone,buyer_ID);
				//System.out.println(sqlQuery);
				int n=st.executeUpdate(sqlQuery);
				//System.out.println(n);
				JOptionPane.showMessageDialog(null,"Mobile Number Changed Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
			
				
			}
			catch(Exception exp)
			{

				JOptionPane.showMessageDialog(null,"Please enter valid details","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
