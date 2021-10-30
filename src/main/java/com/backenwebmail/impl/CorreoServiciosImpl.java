package com.backenwebmail.impl;

import com.backenwebmail.entity.User;
import com.backenwebmail.modelo.Emailcfg;
import com.backenwebmail.modelo.Feedback;
import com.backenwebmail.security.EncriptadorAES;
import com.backenwebmail.service.CorreosServices;
import com.backenwebmail.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service("EmailService")
public class CorreoServiciosImpl implements CorreosServices {

    protected static final Log logger = LogFactory.getLog(CorreoServiciosImpl.class);
    @Autowired(required = true)
    private Emailcfg emailcfg;

    @Autowired
    private UserService userService;

    @Autowired
    private EncriptadorAES encriptadorAES;

    @Override
    public Boolean sendFeeback(Feedback feedback) {

        boolean valor = false;
        User userAdmin = null;
        List<User> users = userService.findUserRol("Admin");

        for (User us : users){
            if (us.getRol().equals("Admin")){
                userAdmin =us;
                break;
            }
        }

        String pass = encriptadorAES.decrypt(userAdmin.getPassword(), userAdmin.getEmail());

        this.emailcfg.setUsername(userAdmin.getEmail());
        this.emailcfg.setPassword(pass);

       // logger.info( this.emailcfg.toString());

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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userAdmin.getUsername()));
            message.setSubject("new feedback from " + feedback.getName());

            message.setText("La persona " + feedback.getName() + " te esta contactando: "
                    + "\nCorreo = " + feedback.getEmail()
                    + "\n" + feedback.getFeedback());

            Transport transport = session.getTransport("smtp");
            transport.connect(this.emailcfg.getHost(), this.emailcfg.getUsername(), this.emailcfg.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            valor = true;
        } catch (MessagingException me) {
            me.printStackTrace();
        }
        return valor;
    }


    @Override
    public Boolean sendMailsFeeback(List<Feedback> feedbacks) {
        int countSendMails = 0;
        for (Feedback feedback : feedbacks) {
            this.sendFeeback(feedback);
            countSendMails++;
        }

        if (feedbacks.size() == countSendMails) {
            return true;
        }
        return false;
    }

}
