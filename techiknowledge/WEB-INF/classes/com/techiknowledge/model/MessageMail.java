/**
 * Copyright (c) 2016 WKUNG Co., Ltd. All Right Reserved.
 *
 * This software is the confidential and proprietary information of
 * WKUNG Co., Ltd. ("Confidential Informaion").
 *
 * You shall not disclose such Confidential Informaion and shall use it
 * only in accordance with the terms of license agreement you entered
 * into with XXX Co., Ltd.
 */

package com.techiknowledge.model;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageMail {
    private final String SENDER = "techiknowl@gmail.com";
    private final String SENDERPW = "techi1USER";
    
    
    public boolean sendMail(String receiver, String content){
        boolean isSended = false;
        
        System.out.println("Send Mail Start");
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER,SENDERPW);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject("TechiKnowledge Confirm Account Mail");
            message.setContent(content, "text/html");

            Transport.send(message);
            isSended = true;
            System.out.println("Send Mail Done");

        } catch (MessagingException e) {
            System.out.println("-------exception-----");
            throw new RuntimeException(e);
        }
        
        return isSended;
    }

}
