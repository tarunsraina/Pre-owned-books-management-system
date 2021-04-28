package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SellerUI extends JFrame implements ActionListener
{
	SellerLoginVerification obj=new SellerLoginVerification();
	int seller_ID=obj.seller_ID;
	JButton SellBookbtn;
	JButton HandBookbtn;
	JButton SearchBookbtn;
	JButton SearchHandBookbtn;
	JButton Historybtn;
	JButton backbtn;
	JButton updateMobBtn;
	JTextField PHField;
	SellerUI()
	{

		this.getContentPane().setBackground(new Color(30,150,155));
		this.setVisible(true);
		this.setSize(2000,2000);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		
		SellBookbtn = new JButton("Sell Books");
		SellBookbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		SellBookbtn.setBackground(Color.WHITE);
		SellBookbtn.setBounds(569, 173,210, 23);
		SellBookbtn.setFocusable(false);

		
		HandBookbtn = new JButton("Sell Handwritten Notes");
		HandBookbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		HandBookbtn.setBackground(Color.WHITE);
		HandBookbtn.setBounds(538, 316, 280, 25);
		HandBookbtn.setFocusable(false);
	
		SearchBookbtn = new JButton("Search Book");
		SearchBookbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		SearchBookbtn.setBackground(Color.WHITE);
		SearchBookbtn.setBounds(569, 105, 210, 23);
		SearchBookbtn.setFocusable(false);
		
		SearchHandBookbtn = new JButton("Search Handwritten Notes");
		SearchHandBookbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		SearchHandBookbtn.setBackground(Color.WHITE);
		SearchHandBookbtn.setBounds(538, 237, 280, 30);
		SearchHandBookbtn.setFocusable(false);
		
		Historybtn = new JButton("See My History");
		Historybtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Historybtn.setBackground(Color.WHITE);
		Historybtn.setBounds(569, 401, 210, 23);
		Historybtn.setFocusable(false);
		
		backbtn = new JButton("Back");
		backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		backbtn.setBackground(Color.WHITE);
		backbtn.setBounds(630,720, 89, 23);
		backbtn.setFocusable(false);
		
		PHField = new JTextField();
		PHField.setBounds(601, 529, 145, 20);
		this.getContentPane().add(PHField);
		PHField.setColumns(10);
		
		updateMobBtn = new JButton("Update My Mobile Number");
		updateMobBtn.setBackground(Color.WHITE);
		updateMobBtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
		updateMobBtn.setBounds(569,560, 198, 23);
		getContentPane().add(updateMobBtn);
		updateMobBtn.setFocusable(false);
		
		Historybtn.addActionListener(this);
		SellBookbtn.addActionListener(this);
		SearchHandBookbtn.addActionListener(this);
		HandBookbtn.addActionListener(this);
		SearchBookbtn.addActionListener(this);
		backbtn.addActionListener(this);
		updateMobBtn.addActionListener(this);
		
		
		
		this.getContentPane().setBackground(Color.white);
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(-16,11,2010,2011);
		this.getContentPane().add(l);
		
		getContentPane().add(SellBookbtn);
		getContentPane().add(HandBookbtn);
		getContentPane().add(SearchBookbtn);
		getContentPane().add(SearchHandBookbtn);
		getContentPane().add(Historybtn);
		getContentPane().add(backbtn);
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==SellBookbtn)
		{
			this.dispose();
			new SellBook();
		}
		else if(e.getSource()==HandBookbtn)
		{
			this.dispose();
			new SellHandwrittenBooks();
		}
		else if(e.getSource()==SearchHandBookbtn)
		{
			this.dispose();
			new SearchHandwrittenNotes();
		}
		else if(e.getSource()==SearchBookbtn)
		{
			this.dispose();
			new SearchBook();
		}
		else if(e.getSource()==Historybtn)
		{
			this.dispose();
			new SellerHistory();
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
					sqlQuery=String.format("update seller set phone_number='%s' where seller_ID=%d",phone,seller_ID);
					System.out.println(sqlQuery);
					st.executeUpdate(sqlQuery);
					JOptionPane.showMessageDialog(null,"Mobile Number Changed Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				catch(Exception exp)
				{

					JOptionPane.showMessageDialog(null,"Please enter valid details","Error",JOptionPane.ERROR_MESSAGE);
				}
			
		}
	}

}
