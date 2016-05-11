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

package com.techiknowledge.dao;

/**
  *
  * @author WayneKung
  */
public interface UserDao {
    
    public User getUserByEmail(String email, String password);
    
    public boolean addUser(User user);
    
    public boolean UpdateUser(User user);
    
    public boolean DeleteUser(User user);
    
    public boolean isAccountExist(String email);
    
    public boolean activeAccount(String email, String activeCode);
}
