package com.realtez.emailer.service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
 
@Service
public class MailService {

	//String smtpServer = "smtp.gmail.com";
	static String smtpServer = "smtp.secureserver.net";
	static String smtpPort = "587";
	static String from = "communication@realtez.com";
	static String to = "xin.liudfdf@rentacenter.com";
	//static String to = "ericliux@gmail.com";
	public static void main(String[] args) {
		
		MailService mail = new MailService();
		mail.sendMail(to, "test", "This is just a test message");
	}
	public void sendMail(String recipients, String subject, String content) {

//		Properties properties = System.getProperties();
//		properties
//				.setProperty("mail.smtp.host", System.getProperty(smtpServer));
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
		
		 final String username = "ericliux@gmail.com";
	        final String password = "dvdzmaqfdfhexbxt";
	       // Properties prop = new Properties();
	        prop.put("mail.smtp.auth", true);
	        prop.put("mail.smtp.host", smtpServer);
	        prop.put("mail.smtp.port", smtpPort);
	       // prop.put("mail.smtp.starttls.enable", "true");
	        prop.put("mail.smtp.ssl.enable", false);
	        prop.put("mail.smtp.starttls.enable", false);
	        
	        Properties props = new Properties();
	        props.setProperty("mail.transport.protocol", "smtp");     
	        props.setProperty("mail.host", "smtp.gmail.com");  
	        props.put("mail.smtp.auth", "true");  
	        props.put("mail.smtp.port", "465");  
	        props.put("mail.debug", "true");  
	        props.put("mail.smtp.socketFactory.port", "465");  
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	        props.put("mail.smtp.socketFactory.fallback", "false");  
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
	        {
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
	            {
	                return new  javax.mail.PasswordAuthentication(username, password);
	            }
	        });
		 
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(recipients));
			//message.setReplyTo(InternetAddress.parse(recipients));
			// Set Subject: header field
			message.setSubject("Testing Subject");
			// This mail has 2 part, the BODY and the embedded image
			MimeMultipart multipart = new MimeMultipart("related");
			// first part (the html)
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
			messageBodyPart.setContent(htmlText, "text/html");
			// add it
			multipart.addBodyPart(messageBodyPart);
			// second part (the image)
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(
			"c://temp/loveln.jpg");
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");
			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);
			// put everything together
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");

		} catch (MessagingException mex) {
		   mex.printStackTrace();
		}
		
	  
		
	}
}
