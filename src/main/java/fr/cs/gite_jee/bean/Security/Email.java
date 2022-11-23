package fr.cs.gite_jee.bean.Security;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import sun.security.krb5.internal.Authenticator;

import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

public class Email {
//    public static void sendEmail(String toEmail, String subject, String body){
//        final String fromEmail = "fsackebandt";
//        final String password ="dddddd";
//
//
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.free.fr"); //SMTP Host
//        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//        props.put("mail.smtp.port", "465"); //SMTP Port
//
//        Authenticator auth = new Authenticator() {
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//
//        Session session = Session.getDefaultInstance(props, auth);
//
//
//        try
//        {
//            MimeMessage msg = new MimeMessage(session);
//            //set message headers
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            //msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//            msg.setFrom(new InternetAddress("fsackebandt@free.fr", "NoReply"));
//            msg.setReplyTo(InternetAddress.parse("fsackebandt@free.fr", false));
//            msg.setSubject(subject, "UTF-8");
//            msg.setText(body, "UTF-8");
//            msg.setSentDate(new Date());
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//            Transport.send(msg);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
