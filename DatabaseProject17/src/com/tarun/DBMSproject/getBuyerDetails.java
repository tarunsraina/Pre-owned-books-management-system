package com.tarun.DBMSproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.taru.database.project8.SendMail;

import java.sql.*;

public class getBuyerDetails extends JFrame implements ActionListener
{
	JTextField BuyerIDField;
	JTextField BranchField;
	JTextField EmailField;
	JButton submitButton;
	JTextField NameField;
	JTextField CollegeIDField;
	JTextField PhonenoField;
	JComboBox combobox;
	private JComboBox combobox_1;
	String[] colleges= {"432-NIEIT,Mysore","271-NIE,Mysore","359-JSS,Mysore","856-Vidya vardhaka,Mysore","259-Vidya vikas,Mysore","564-RV,Banglore","691-PES,Banglore","698-BMS,Banglore","236-KLE,Hubli","904-SSIT,Tumkur","300-NMAM,Udupi","390-SDM,Dharwad","387-KLS,Belgaum","809-CMR,Banglore","675-Reva,Banglore"};
	//String[] colleges= {"432-NIEIT","271-NIE"};
	
	getBuyerDetails()
    {
				combobox=new JComboBox(colleges);
				getContentPane().add(combobox);
				combobox_1=new JComboBox(colleges);
				combobox_1.setBackground(Color.WHITE);
				combobox_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
				combobox_1.setBounds(932, 334,192,35);
				this.getContentPane().add(combobox_1);
				//combobox.setColumns(10);
				combobox_1.addActionListener(this);
				getContentPane().add(combobox_1);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.getContentPane().setBackground(new Color(30,150,155));
    	
		Label label = new Label("Name");
		label.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label.setBounds(380, 102, 120, 35);
		getContentPane().add(label);
		
		NameField = new JTextField();
		NameField.setBackground(new Color(255, 255, 255));
		NameField.setBounds(679, 102, 230, 35);
		getContentPane().add(NameField);
	
		Label label2 = new Label("Your ID");
		label2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label2.setBounds(380, 163, 120, 29);
		getContentPane().add(label2);
		
		BuyerIDField = new JTextField();
		BuyerIDField.setBackground(new Color(255, 255, 255));
		BuyerIDField.setBounds(679, 162, 230, 30);
		getContentPane().add(BuyerIDField);
		
		Label label3 = new Label("Branch");
		label3.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label3.setBounds(380, 213, 120, 35);
		getContentPane().add(label3);
		
		BranchField = new JTextField();
		BranchField.setBackground(new Color(255, 255, 255));
		BranchField.setBounds(679, 213, 230, 35);
		getContentPane().add(BranchField);
		
		Label label4 = new Label("Email-ID");
		label4.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label4.setBounds(380, 273, 120, 35);
		getContentPane().add(label4);
		
		EmailField = new JTextField();
		EmailField.setBackground(new Color(255, 255, 255));
		EmailField.setBounds(679, 273, 230, 35);
		getContentPane().add(EmailField);
		
		Label label5 = new Label("College-ID");
		label5.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label5.setBounds(380, 334, 120, 29);
		getContentPane().add(label5);
		
		CollegeIDField = new JTextField();
		CollegeIDField.setBackground(new Color(255, 255, 255));
		CollegeIDField.setBounds(679, 334, 230, 35);
		getContentPane().add(CollegeIDField);
		
		Label label6= new Label("Phone no");
		label6.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		label6.setBounds(380, 399, 120, 37);
		getContentPane().add(label6);
		
		PhonenoField = new JTextField();
		PhonenoField.setBackground(new Color(255, 255, 255));
		PhonenoField.setBounds(679, 399, 230, 37);
		getContentPane().add(PhonenoField);
		
    	submitButton=new JButton("Submit");
    	submitButton.setBackground(Color.white);
    	submitButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
    	submitButton.setBounds(725, 464,141, 35);
    	getContentPane().add(submitButton);
    	submitButton.addActionListener(this);
    	this.getContentPane().setBackground(Color.white);
		ImageIcon img=new ImageIcon("bgLogo.jpg");
		JLabel l = new JLabel("",img,JLabel.CENTER);
		l.setBounds(0,0,2000,2000);
		this.getContentPane().add(l);
    	this.pack();
    	this.setVisible(true);
    	this.setSize(2000,2000);
    	getContentPane().setLayout(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submitButton)
		{
			String buyer_name=NameField.getText();
			int Buyer_ID=Integer.parseInt(BuyerIDField.getText());
			String buyer_Branch=BranchField.getText();
			String Buyer_Email=EmailField.getText();
			int Buyer_CollegeID=Integer.parseInt(CollegeIDField.getText());
			String Buyer_phoneno=PhonenoField.getText();
			int dis=0;
			
			if(Buyer_phoneno.equals("")|| !Buyer_phoneno.matches("[0-9]+"))
			{
				JOptionPane.showMessageDialog(null,"Enter a valid mobile number","Error",JOptionPane.ERROR_MESSAGE);
				this.dispose();
				dis++;
				new MyFrame();
			}

			if(dis==0)
			{
			
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
				//Statement st=con.createStatement();

				java.sql.CallableStatement cst=con.prepareCall("CALL BuyerRegistration(?,?,?,?,?,?)");
				
				cst.setInt(1,Buyer_ID);
				cst.setString(2,buyer_Branch);
				cst.setString(3,Buyer_Email);
				cst.setString(4,buyer_name);
				cst.setInt(5,Buyer_CollegeID);
				cst.setString(6,Buyer_phoneno);
		        x=cst.executeUpdate();
			  
				//sqlQuery=String.format("Insert into buyer values(%d,'%s','%s','%s',%d,'%s')",Buyer_ID,buyer_Branch,Buyer_Email,buyer_name,Buyer_CollegeID,Buyer_phoneno);
				//x=st.executeUpdate(sqlQuery);
				
			}
			catch(Exception exp)
			{
				System.out.println("Please enter valid details");
			}
		
			
				if(x>0)
				{
					JOptionPane.showMessageDialog(null,"Succesfully Registered as Buyer","Success",JOptionPane.INFORMATION_MESSAGE);
					new BuyerUI();
					try {
						new SendMail(Buyer_Email);
					} catch (MessagingException e1) {
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			
		   }
		
		
	}
}
}