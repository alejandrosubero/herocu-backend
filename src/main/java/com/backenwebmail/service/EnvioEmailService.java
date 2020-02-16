package com.backenwebmail.service;

import java.util.List;

import com.backenwebmail.modelo.Correo;
import com.backenwebmail.modelo.CuerpoDeCorreo;

public interface EnvioEmailService  {

	public void sendMail(Correo mail);
	public int sendEmails(List<String> correos, CuerpoDeCorreo cuerpo);
	public void sendPreConfiguredMail(String message);
	public void sendMailWithAttachment(String to, String subject, String body, String fileToAttach);
	public void sendMailWithInlineResources(String to, String subject, String fileToAttach);
}
