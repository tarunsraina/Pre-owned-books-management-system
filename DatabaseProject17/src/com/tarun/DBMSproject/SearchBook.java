package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class SearchBook extends JFrame implements ActionListener
{
	JTextField collegeIDField;
	JButton submitbtn;
	JTextField BookIDField;
	JButton Buybtn;
	JButton Backbtn;
	JTable table;
	JScrollPane scrollpane;
	JComboBox combobox;
	
	String[] colleges= {"432-NIEIT,Mysore","271-NIE,Mysore","359-JSS,Mysore","856-Vidya vardhaka,Mysore","259-Vidya vikas,Mysore","564-RV,Banglore","691-PES,Banglore","698-BMS,Banglore","236-KLE,Hubli","904-SSIT,Tumkur","300-NMAM,Udupi","390-SDM,Dharwad","387-KLS,Belgaum","809-CMR,Banglore","675-Reva,Banglore"};
	//String[] colleges= {"432-NIEIT","271-NIE"};
	SearchBook()
	{
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 100, 892, 399);
		this.getContentPane().add(scrollPane);
		combobox=new JComboBox(colleges);
		getContentPane().add(combobox);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null,null},
			},
			new String[] {
				"Book_name", "Authour", "Price","Semester","Book-ID"
			}));
		
		JLabel lblNewLabel = new JLabel("College-ID");
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 41, 123, 14);
		this.getContentPane().add(lblNewLabel);
		
		combobox=new JComboBox(colleges);
		combobox.setBounds(130, 40,284,28);
		this.getContentPane().add(combobox);
		//combobox.setColumns(10);
		combobox.addActionListener(this);
		getContentPane().add(combobox);
		
		this.setBounds(175, 50, 180,31);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Backbtn.setBounds(130, 519, 117, 28);
		Backbtn.setBackground(Color.white);
		getContentPane().add(Backbtn);
		Backbtn.addActionListener(this);
		/*
		submitbtn = new JButton("Submit");
		submitbtn.setBackground(Color.WHITE);
		submitbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		submitbtn.setBounds(241, 39, 96, 23);
		this.getContentPane().add(submitbtn);
		submitbtn.addActionListener(this);
		*/
		
		this.getContentPane().setBackground(Color.white);
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,0,2000,2000);
		this.getContentPane().add(l);

		this.getContentPane().setBackground(new Color(30,150,155));
		getContentPane().setLayout(null);
		this.pack();
    	this.setVisible(true);
    	this.setSize(2000,2000);
    	this.setResizable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==combobox)
		{
			int college_ID=0;
			
			try {
			JComboBox cb=(JComboBox)e.getSource();
			String clg=(String)combobox.getSelectedItem();
			switch(clg)
			{
			case "432-NIEIT,Mysore":
				college_ID=432;
				break;
			case "271-NIE,Mysore":
				college_ID=271;
				break;
			
			case "359-JSS,Mysore":
				college_ID=359;
				break;
			case "856-Vidya vardhaka,Mysore":
				college_ID=856;
				break;
			case "259-Vidya vikas,Mysore":
				college_ID=259;
				break;
			case "564-RV,Banglore":
				college_ID=564;
				break;
			case "691-PES,Banglore":
				college_ID=691;
				break;
			case "698-BMS,Banglore":
				college_ID=698;
				break;
			case "236-KLE,Hubli":
				college_ID=236;
				break;
			case "904-SSIT,Tumkur":
				college_ID=904;
				break;
			case "300-NMAM,Udupi":
				college_ID=300;
				break;
			case "390-SDM,Dharwad":
				college_ID=390;
				break;
			case "387-KLS,Belgaum":
				college_ID=387;
				break;
			case "809-CMR,Banglore":
				college_ID=809;
				break;
			case "675-Reva,Banglore":
				college_ID=675;
				break;
			}
			
			
			//else if(clg.eq)
			String databaseName="pobms";
			final String url="jdbc:mysql://localhost:3306/"+ databaseName;
			final String username="root";
			final String password="ironman7";
			final String sqlQuery;
			
					
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection con=DriverManager.getConnection(url,username,password);
						Statement st=con.createStatement();
						//int college_ID=Integer.parseInt(collegeIDField.getText());
						ResultSet rs;
						sqlQuery=String.format("Select Authour,Book_name,Price,Semester,Book_ID from book b join seller s on b.seller_ID =s.seller_ID where college_ID=%d",college_ID);
						System.out.println(sqlQuery);
						rs=st.executeQuery(sqlQuery);
						table.getColumnModel().getColumn(0).setPreferredWidth(128);
						table.getColumnModel().getColumn(1).setPreferredWidth(116);
						table.getColumnModel().getColumn(2).setPreferredWidth(120);
						table.getColumnModel().getColumn(3).setPreferredWidth(107);
						table.getColumnModel().getColumn(4).setPreferredWidth(107);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception exp)
					{
						
					}
				}
		else if(e.getSource()==Backbtn)
		{
			this.dispose();
			new SellerUI();
		}
	}
}
