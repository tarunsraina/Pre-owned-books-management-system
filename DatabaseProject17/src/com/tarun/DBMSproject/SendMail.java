package com.tarun.DBMSproject;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail{
	SendMail(String recep) throws MessagingException
	{
		//System.out.println("jjjjjjjjjjj");
	final String myEmail="tarunsraina483@gmail.com";
	final String password="ironman7";
	
	//String recep;
//SendMail(String recep) throws MessagingException
//{
	Properties prop=new Properties();
	
	prop.put("mail.smtp.auth","true");
	prop.put("mail.smtp.starttls.enable","true");
	prop.put("mail.smtp.host","smtp.gmail.com");
	prop.put("mail.smtp.port","587");
	
	
	
	
	Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
		
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(myEmail,password);
	}
	
});
	Message msg=prepareMessage(session,myEmail,recep);
	Transport.send(msg);
}

private static Message prepareMessage(Session session,String myEmail,String recep){
	Message msg=new MimeMessage(session);
	try 
	{
		msg.setFrom(new InternetAddress(myEmail));
		msg.setRecipient(Message.RecipientType.TO,new InternetAddress(recep));
		msg.setSubject("Registration Successful");
		msg.setText("Hey There,\nYour Registration is succesful!\n\n\n\nPlease Know your college code:\n\n432-NIEIT,Mysore\n271-NIE,Mysore\n359-JSS,Mysore\n856-Vidya vardhaka,Mysore\n259-Vidya vikas,Mysore\n564-RV,Banglore\n691-PES,Banglore\n698-BMS,Banglore\n236-KLE,Hubli\n904-SSIT,Tumkur\n300-NMAM,Udupi\n390-SDM,Dharwad\n387-KLS,Belgaum\n809-CMR,Banglore\n675-Reva,Banglore\n\n\n\nContact Us:\nTarun-tarunsraina@gmail.com\nHafsa-hafsa@gmail.com\nDharani-Dharani@gmail.com");
		return msg;
	} catch (AddressException e) {
		e.printStackTrace();
	} catch (MessagingException e) {
		e.printStackTrace();
	}
	return null;
}
	}

