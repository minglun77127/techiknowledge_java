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

import java.sql.Timestamp;

/**
  *
  * @author WayneKung
  */
public class Address {
    private String id;
    private String userId;
    private String addressLine;
    private String country;
    private String province;
    private String city;
    private String postalCode;
    private Timestamp last_update;
    private boolean isDelete;
    
    public Address(){};
    
    public Address(String id, String userId, String addressLine, String country, String province, String city, String postalCode, Timestamp last_update, boolean isDelete){
        this.id = id;
        this.userId = userId;
        this.addressLine = addressLine;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
        this.last_update = last_update;
        this.isDelete = isDelete;
    };
    
    public Address(String id, String userId, String addressLine, String country, String province, String city, String postalCode){
        this.id = id;
        this.userId = userId;
        this.addressLine = addressLine;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
    };
    
    public Address(String userId, String addressLine, String country, String province, String city, String postalCode){
        this.userId = userId;
        this.addressLine = addressLine;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
    };
    
    public Address(String addressLine, String country, String province, String city, String postalCode){
        this.addressLine = addressLine;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
    };
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

}
