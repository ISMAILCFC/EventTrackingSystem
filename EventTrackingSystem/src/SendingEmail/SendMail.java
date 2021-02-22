package SendingEmail;


import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author velik
 */
    
    import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {


    public static void SendMail(String GonderilecekMailAdres,String Baslik , String Icerik ){
        try {
    String from = "eventtrackingsystem@gmail.com";
   String pass = "admin1234.";
   String[] to = { GonderilecekMailAdres };
   String host = "smtp.gmail.com";
   Properties props = System.getProperties();
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.host", host);
   props.put("mail.smtp.user", from);
   props.put("mail.smtp.password", pass);
   props.put("mail.smtp.port", "587");
   props.put("mail.smtp.auth", "true");
   Session session = Session.getDefaultInstance(props, null);
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   InternetAddress[] toAddress = new InternetAddress[to.length];
   for (int i = 0; i < to.length; i++) {
    toAddress[i] = new InternetAddress(to[i]);
   }
            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }
   message.setSubject(Baslik);
   message.setText(Icerik);
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
            }
  } catch (MessagingException e) {
  }
}
    
}
    
    
