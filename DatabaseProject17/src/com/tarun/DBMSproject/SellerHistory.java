package com.tarun.DBMSproject;

import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class SellerHistory extends JFrame implements ActionListener
{	
	SellerLoginVerification obj=new SellerLoginVerification();
	int seller_ID=obj.seller_ID;
	JTable table;
	JScrollPane scrollpane;
	JTextField textField;
	JButton btnNewButton,Backbtn;
	SellerHistory()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 78, 686, 357);
		this.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Transaction ID", "Date", "Points"
			}));
	
		
		this.setBounds(175, 50, 180,31);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Backbtn.setBounds(210, 493, 99, 23);
		Backbtn.setBackground(Color.white);
		getContentPane().add(Backbtn);
		Backbtn.addActionListener(this);
	
		btnNewButton = new JButton("SHOW");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		btnNewButton.setBounds(210, 39, 96, 23);
		btnNewButton.setFocusable(false);
		this.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
	
	
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
		if(e.getSource()==btnNewButton)
		{
			Connection connection=null;
			String databaseName="pobms";
			final String url="jdbc:mysql://localhost:3306/"+ databaseName;
			final String username="root";
			final String password="ironman7";
			final String sqlQuery;
			
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection con=DriverManager.getConnection(url,username,password);
						Statement st=con.createStatement();
						//seller_ID=Integer.parseInt(textField.getText());
						ResultSet rs;
						sqlQuery=String.format("Select Transaction_ID,Date,points from history where seller_ID=%d",seller_ID);
						rs=st.executeQuery(sqlQuery);
						table.getColumnModel().getColumn(0).setPreferredWidth(128);
						table.getColumnModel().getColumn(1).setPreferredWidth(116);
						table.getColumnModel().getColumn(2).setPreferredWidth(120);
						//table.getColumnModel().getColumn(3).setPreferredWidth(107);
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
