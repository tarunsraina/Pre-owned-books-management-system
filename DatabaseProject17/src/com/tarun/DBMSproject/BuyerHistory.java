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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class BuyerHistory extends JFrame implements ActionListener
{	
	JTable table;
	JScrollPane scrollpane;
	JTextField textField;
	JButton btnNewButton,Backbtn;
	BuyerLoginVerification obj=new BuyerLoginVerification();
	int buyer_ID=obj.buyer_ID;
	BuyerHistory()
	{
		Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		Backbtn.setBounds(433, 493, 119, 23);
		Backbtn.setBackground(Color.white);
		getContentPane().add(Backbtn);
		Backbtn.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 78, 570, 348);
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

		
		btnNewButton = new JButton("SHOW");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		btnNewButton.setBounds(210, 39, 96, 23);
		btnNewButton.setFocusable(false);
		this.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
	
		
		this.getContentPane().setBackground(new Color(30,150,155));
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
		if(e.getSource()==btnNewButton)
		{
			Connection connection=null;
			String databaseName="pobms";
			final String url="jdbc:mysql://localhost:3306/"+ databaseName;
			final String username="root";
			final String password="ironman7";
			final String sqlQuery;
			
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,username,password);
						Statement st=con.createStatement();
						ResultSet rs;
						sqlQuery=String.format("Select Transaction_ID,Date,points from history where buyer_ID=%d",buyer_ID);
						
						rs=st.executeQuery(sqlQuery);
						System.out.println(sqlQuery);
						table.getColumnModel().getColumn(0).setPreferredWidth(128);
						table.getColumnModel().getColumn(1).setPreferredWidth(116);
						table.getColumnModel().getColumn(2).setPreferredWidth(120);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception exp)
					{
						JOptionPane.showMessageDialog(null,"Please,Try again","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
		else if(e.getSource()==Backbtn)
		{
			this.dispose();
			new BuyerUI();
		}
		
	}
}
