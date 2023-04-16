package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                //for security reason can't share password
                return new PasswordAuthentication("suvadipmajhi.official.1997@gmail.com", "*****");
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("suvadipmajhi.official.1997@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("suvadipmajhi72@gmail.com"));
        message.setSubject("Test Email");
        message.setText("This is a test email from Java.");

        Transport.send(message);
        System.out.println("Email sent successfully.");
    }
}