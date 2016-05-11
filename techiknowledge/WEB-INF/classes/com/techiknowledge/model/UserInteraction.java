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

import com.techiknowledge.dao.User;

/**
  *
  * @author WayneKung
  */
public interface UserInteraction {
    
    public String encrypt(String oriPassword);
    
    public String getMailContent(User user);
}
