package example1;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class JavaMail_SendEmail
	{
	   public static void main(String [] args)
	   {    
	      String to = "zakirhere@gmail.com";
	      String from = "zakirsayed@cnico.com";
	      String host = "kwnhmail";

	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         message.setSubject("New Quote created: ");

	         message.setText("This is actual message");

	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	
}
