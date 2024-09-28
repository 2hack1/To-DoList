package com.send.mess.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OtpService {

	
	public void sendEmailTest(int otp,String to) {
		String from = "kapilagrawal230@gmail.com";
		String password = "cywi sfuw yycp dzij";

		String message = "Verification code\r\n" 
				+ "Please use the verification code below to sign in.\r\n" 
				+ "\r\n"
				+ otp 
				+ "\r\n" + "\r\n" 
				+ "If you didn’t request this, you can ignore this email.\r\n" 
				+ "\r\n"
				+ "Thanks,\r\n" + "The Mailmeteor team";
		
		
		

		System.out.println("Message sending process..........");
		// gmail host.
		String gmailHost="smtp.gmail.com";
		String gmailPort = "465";
		// get system properties
		Properties properties = System.getProperties();
		
		// setting important properties in system properties
		// set gmail host in properties
		properties.put("mail.smtp.host", gmailHost);
		// set gmail port in properties
		properties.put("mail.smtp.port", gmailPort);
		// set gmail ssl security enable/disabled in properties
		properties.put("mail.smtp.ssl.enable", "true");
		// set gmail authantication enable/disable in properties
		properties.put("mail.smtp.auth", "true");

		// Stap-1 :- Get Session
		Session instance = Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		// Stap-2 :- Compose the message.
		try {
			MimeMessage mimeMessage = new MimeMessage(instance);
			mimeMessage.setFrom(from);
			mimeMessage.setSubject("OTP Varification Testing...");
			mimeMessage.setText(message);
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Stap-3 :- Sending Message.
			Transport.send(mimeMessage);
			System.out.println("Message send success...................");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
}
