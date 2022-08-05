package com.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Registered {
	public static void sendMail(String emailid){
		final String username  = "ankush.testjava@gmail.com";//Sender Email
		final String password   = "Ankush@6780";//Sender Password
		
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailid));//to mail address.
			message.setSubject("Registered Successfully");
			
			message.setText("Dear User ,"+ "\n\n You have successfully registered on Famms Fashion Store.");
 
			Transport.send(message);
 
			System.out.println("SignUp Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}		
	}
}
