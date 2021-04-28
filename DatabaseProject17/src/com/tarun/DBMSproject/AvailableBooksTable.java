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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class AvailableBooksTable extends JFrame implements ActionListener
{
	JTable table;
	JButton HomeButton;
	String sqlQuery="";
	AvailableBooksTable()
	{
		this.setVisible(true);
		this.setSize(2000,2000);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 68, 930, 467);
		this.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Book-ID", "Authour", "semester", "Price", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		try {
			Connection connection=null;
			String databaseName="pobms";
			final String url="jdbc:mysql://localhost:3306/"+ databaseName;
			final String username="root";
			final String password="ironman7";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs;
			sqlQuery=String.format("Select Book_ID,Authour,Semester,Price,status from booksAvailable;");
			rs=st.executeQuery(sqlQuery);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception exp)
		{
			
		}
		HomeButton = new JButton("Home");
		HomeButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		HomeButton.setBounds(770, 699, 89, 23);
		HomeButton.setBackground(Color.white);
		HomeButton.setFocusable(false);
		HomeButton.addActionListener((ActionListener) this);
		this.getContentPane().add(HomeButton);
		
		
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,11,2124,1961);
		getContentPane().add(l);
		this.getContentPane().add(l);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==HomeButton)
		{
			this.dispose();
			new MyFrame();
		}
		
	}
}
