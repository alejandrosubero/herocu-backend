package com.backenwebmail.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backenwebmail.modelo.Emailcfg;
import com.backenwebmail.modelo.Feedback;
//@CrossOrigin(origins = "https://annitawebss.000webhostapp.com")

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/feedback")
public class FeebadbackController {

	private Emailcfg emailcfg;

	

	public FeebadbackController(Emailcfg emailcfg) {

		this.emailcfg = emailcfg;
	}

	@PostMapping("/lig")
	public void sendFeeback(@RequestBody Feedback feedback, BindingResult bindingResult) {

		if (feedback.getToken().equals("")) {

			if (bindingResult.hasErrors()) {
				throw new ValidationException("Feedback in not valid");
			}

			Properties props = System.getProperties();

			props.put("mail.smtp.host", this.emailcfg.getHost());
			props.put("mail.smtp.user", this.emailcfg.getUsername());
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", this.emailcfg.getPort());

			Session session = Session.getDefaultInstance(props);

			MimeMessage message = new MimeMessage(session);

			try {
				message.setFrom(new InternetAddress(this.emailcfg.getUsername()));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress("alejandrosubero.ar@gmail.com"));
				message.setSubject("new feedback from " + feedback.getName());
				message.setText("el nombre de la persona que contacta: " + feedback.getName() + "\nCorreo = "
						+ feedback.getEmail() + "\n" + feedback.getFeedback());

				Transport transport = session.getTransport("smtp");
				transport.connect(this.emailcfg.getHost(), this.emailcfg.getUsername(), this.emailcfg.getPassword());
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} catch (MessagingException me) {
				me.printStackTrace();
			}

		}

	}

	
	
	@PostMapping("/ligeros")
	public boolean sendFeebacks(@RequestBody Feedback feedback, BindingResult bindingResult) {

		boolean valor = false;

		//if (feedback.getToken()=="1234567891011121314151689719"){

			if (bindingResult.hasErrors()) {
				throw new ValidationException("Feedback in not valid");
			}

			Properties props = System.getProperties();

			props.put("mail.smtp.host", this.emailcfg.getHost());
			props.put("mail.smtp.user", this.emailcfg.getUsername());
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", this.emailcfg.getPort());

			Session session = Session.getDefaultInstance(props);

			MimeMessage message = new MimeMessage(session);

			try {
				message.setFrom(new InternetAddress(this.emailcfg.getUsername()));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress("alejandrosubero@hotmail.com"));
				message.setSubject("new feedback from " + feedback.getName());
				message.setText("el nombre de la persona que contacta: " + feedback.getName() + "\nCorreo = "
						+ feedback.getEmail() + "\n" + feedback.getFeedback());

				Transport transport = session.getTransport("smtp");
				transport.connect(this.emailcfg.getHost(), this.emailcfg.getUsername(), this.emailcfg.getPassword());
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				valor = true;
			} catch (MessagingException me) {
				me.printStackTrace();
			}

		//}
		return valor;

	}

}
