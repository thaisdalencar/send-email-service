package br.com.thaisdalencar.sendEmail.sendEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

	public void send(String senderEmail, String senderPassword, 
			String recipientName, String recipientEmail,
			String subject, String message) {
		try {			
			
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));
			email.setSSLOnConnect(true);

			email.setFrom(senderEmail);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(recipientEmail);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
