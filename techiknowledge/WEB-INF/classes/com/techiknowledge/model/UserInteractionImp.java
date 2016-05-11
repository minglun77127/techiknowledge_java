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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.techiknowledge.dao.User;

/**
  *
  * @author WayneKung
  */
public class UserInteractionImp implements UserInteraction{
    
    public String encrypt(String oriPassword){
        String enPassword = null;
        
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte byteData[] = md.digest(oriPassword.getBytes());
            
            //convert the byte to hex format
            StringBuffer sb = new StringBuffer();
            for(int i= 0; i < byteData.length; i++){
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            enPassword = sb.toString();
            
        }catch(NoSuchAlgorithmException ex){
            System.out.println("NoSuchAlgorithmException : " + ex);
        }
        return enPassword;
    }
    
    public String getMailContent(User user){
        StringBuffer content = new StringBuffer("<h3>Hi " + user.getFirstName() + "</h3><br>")
                .append("<h2> Thank you for signing up on our website. Please click on the link below to activate your account "
                + "</h2>")
                .append("<a style=\"font-size:16px\"; href=\"http://localhost:8081/TechiKnowledgeWTP/customer.html?action=ACTIVE&")
                .append("email=" + user.getEmail() + "&value=" + user.getActiveCode() +"\">Confirm Account</a>");
        
        return content.toString();
    }
}
