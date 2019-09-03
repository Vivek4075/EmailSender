package com.company;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void sendMail(String receipt) throws /*Messaging*/Exception {
	    // write your code here
        System.out.println("Sending Message\n");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        //System.out.println("scsc\n");

        String myAccountEmail = "vivekkumarmeena4075.com";
        String password = "xyz";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });

        Message message = prepareMessage(session,myAccountEmail,receipt);
        Transport.send(message);
        System.out.println("Message Gaya Bhai\n");

        
    }


    private static Message prepareMessage(Session session, String myAccountEmail,String receipent) throws Exception {
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(receipent));
            message.setSubject("Your Email");
            message.setText("HEY BOEEEE\n");
            return message;
        }
        catch (AddressException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
