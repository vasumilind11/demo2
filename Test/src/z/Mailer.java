package z;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	public class Mailer {
		
		public static void send(String to , String subject ,String msg)
		{   
			final String user_id ="vasumilind11@gmail.com";
		    final String password = "milind@1234";
		    
		    Properties props = new Properties();
		    props.put("mail.smtp.host","smtp.gmail.com");
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.port", "587");		
		    props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		     
		    props.put("mail.smtp.auth","true");
		    
		    Session session = Session.getDefaultInstance(props , new javax.mail.Authenticator() {
		    	
		          protected PasswordAuthentication getPasswordAuthentication()
		    	  {
		    		return new PasswordAuthentication(user_id, password);
		       	}
		    	
			});
			
			try
			{
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user_id));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(subject);
				message.setText(msg);
				
				Transport.send(message);
				
			}
			catch(MessagingException e)
			{
				e.printStackTrace();
			}
		    
			   System.out.println("mail has sent");
			
			
		}

	}

