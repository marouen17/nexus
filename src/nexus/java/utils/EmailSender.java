/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nexus.java.utils;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {


    
    public static boolean sendMail (String to, String password, String message, String from){
        String host ="smtp.gmail.com";
        Properties props= System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress());
            InternetAddress toAddress = new InternetAddress(to);
            
            
                mimeMessage.addRecipient(RecipientType.TO, toAddress);
                mimeMessage.setSubject("Bienvenu");
                mimeMessage.setText(message);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, password);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                return true;
            
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
               
        return false ;
    }

    
    
        
    
}
