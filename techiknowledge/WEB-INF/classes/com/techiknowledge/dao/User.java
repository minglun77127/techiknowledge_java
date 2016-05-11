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

import java.util.Date;

 /**
  *
  * @author WayneKung
  */
public class User {
    private String id;
    private String email;
    private String password;
    private Integer type;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer gender;
    private Date createTime;
    private Date last_update;
    private boolean isActive;
    private String activeCode;
    private boolean isDelete;
    private Address address;
    private boolean isLogin = false;
    
    public User(){};
    
    public User(String id, String email, String password, Integer type, String firstName, String lastName, String phone, Integer gender, Date createTime, Date last_update, boolean isActive, String activeCode, boolean isDelete, Address address){
        this.id = id;
        this.email = email;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.createTime = createTime;
        this.last_update = last_update;
        this.isActive = isActive;
        this.activeCode = activeCode;
        this.isDelete = isDelete;
        this.address = address;
    };
    
    public User(String id, String email, String password, Integer type, String firstName, String lastName, String phone, Integer gender, String activeCode, Address address){
        this.id = id;
        this.email = email;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.activeCode = activeCode;
        this.address = address;
    };
    
    public User(String id, String email, String password, Integer type, String firstName, String lastName, String phone, Integer gender){
        this.id = id;
        this.email = email;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
    };
    
    public User(String firstName, String lastName, String phone, Integer gender, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    };
    public User(String id, String firstName, String lastName, String email, String phone, Integer gender){
    	this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    };
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getLast_update() {
        return last_update;
    }

    public void setLast_update(java.util.Date last_update) {
        this.last_update = last_update;
    }
    
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
    
    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
}
