package com.bridgelabz.servlets.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	public static void send(String userEmail, String admin, String passwordAdmin) {
		System.out.println("******************** Inside Mailer Class And Send");
		String dbUrl = "jdbc:mysql://localhost:3306/Student_Info";
		// Connection with the database

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String password ="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, "root", "root");
			String query = "select * from studentInfo where email=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			set = pstmt.executeQuery();
			if (set.next()) {
				password = password+set.getString("password");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		System.out.println("*************//////////////" + props);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(admin, passwordAdmin);
			}
		});
		
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(admin));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setText(password);
			System.out.println("################Inside try block for MimeMessage");
			
			// 3rd step)send message
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", 587, admin, passwordAdmin);
			transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
