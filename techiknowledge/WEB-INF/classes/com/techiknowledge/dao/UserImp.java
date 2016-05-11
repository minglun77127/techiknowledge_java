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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.sql.DataSource;

/**
  *
  * @author WayneKung
  */
public class UserImp implements UserDao{
    
    public User getUserByEmail(String email, String password){
        Connection con = null;
        User user = null;
        Address address = null;
        String query = "SELECT id, email, password, type, firstName, lastName, phone, gender, createTime, last_update, isActive, isDelete FROM user WHERE email=? AND password=? AND isDelete=false";
        String queryInfo = "SELECT id, userId, addressLine, country, province, city, postalCode, last_update, isDelete FROM address WHERE userId=? AND isDelete=false";
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setString(1, email);
                    pstm.setString(2, password);
                    
                    ResultSet rs = pstm.executeQuery();
                    while(rs.next()){
                        user = new User();
                        user.setId(rs.getString(1));
                        user.setEmail(rs.getString(2));
                        user.setPassword(rs.getString(3));
                        user.setType(rs.getInt(4));
                        user.setFirstName(rs.getString(5));
                        user.setLastName(rs.getString(6));
                        user.setPhone(rs.getString(7));
                        user.setGender(rs.getInt(8));
                        user.setCreateTime(rs.getTimestamp(9));
                        user.setLast_update(rs.getTimestamp(10));
                        user.setIsActive(rs.getBoolean(11));
                        user.setIsDelete(rs.getBoolean(12));
                    }
                    
                    if(user != null){
                        PreparedStatement pstm2 = con.prepareStatement(queryInfo);
                        pstm2.setString(1, user.getId());
                        
                        ResultSet rs2 = pstm2.executeQuery();
                        while(rs2.next()){
                            address = new Address();
                            address.setId(rs2.getString(1));
                            address.setUserId(rs2.getString(2));
                            address.setAddressLine(rs2.getString(3));
                            address.setCountry(rs2.getString(4));
                            address.setProvince(rs2.getString(5));
                            address.setCity(rs2.getString(6));
                            address.setPostalCode(rs2.getString(7));
                            address.setLast_update(rs2.getTimestamp(8));
                            address.setIsDelete(rs2.getBoolean(9));
                            
                            user.setAddress(address);
                        }
                    }
                }
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return user;
    }
    
    public boolean addUser(User user){
        boolean isAdded = false;
        Connection con = null;
        java.util.Date currentTime = new java.util.Date();
        
        String query ="INSERT INTO user (id,email,password,firstName,lastName,phone,gender,createTime,last_update,activeCode) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String queryInfo = "INSERT INTO address (id,userId,addressLine,country,province,city,postalCode,last_update) VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                con.setAutoCommit(false);
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setString(1, user.getId());
                    pstm.setString(2, user.getEmail());
                    pstm.setString(3, user.getPassword());
                    pstm.setString(4, user.getFirstName());
                    pstm.setString(5, user.getLastName());
                    pstm.setString(6, user.getPhone());
                    pstm.setInt(7, user.getGender());
                    pstm.setTimestamp(8, new Timestamp(currentTime.getTime()));
                    pstm.setTimestamp(9, new Timestamp(currentTime.getTime()));
                    pstm.setString(10, user.getActiveCode());
                    
                    if(pstm.executeUpdate() == 1){
                        PreparedStatement pstm2 = con.prepareStatement(queryInfo);
                        pstm2.setString(1, user.getAddress().getId());
                        pstm2.setString(2, user.getAddress().getUserId());
                        pstm2.setString(3, user.getAddress().getAddressLine());
                        pstm2.setString(4, user.getAddress().getCountry());
                        pstm2.setString(5, user.getAddress().getProvince());
                        pstm2.setString(6, user.getAddress().getCity());
                        pstm2.setString(7, user.getAddress().getPostalCode());
                        pstm2.setTimestamp(8, new Timestamp(currentTime.getTime()));
                    
                        if(pstm2.executeUpdate() == 1){
                            con.commit();
                            isAdded = true;
                        }
                    }
                }
            }
        }catch(SQLException ex){
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.setAutoCommit(true);
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return isAdded;
    }
    
    public boolean UpdateUser(User user){
        boolean isUpdated = false;
        Connection con = null;
        java.util.Date currentTime = new java.util.Date();
        
        String query ="UPDATE user SET firstName=?, lastName=?, gender=?, last_update=? WHERE id=?";
        String queryInfo = "UPDATE address SET addressLine=?, country=?, province=?, city=?, postalCode=?, last_update=? WHERE id=?";
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                con.setAutoCommit(false);
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(query);
                    //pstm.setString(1, user.getPassword());
                    pstm.setString(1, user.getFirstName());
                    pstm.setString(2, user.getLastName());
                    //pstm.setString(3, user.getPhone());
                    pstm.setInt(3, user.getGender());
                    pstm.setTimestamp(4, new Timestamp(currentTime.getTime()));
                    pstm.setString(5, user.getId());
                    
                    if(pstm.executeUpdate() == 1){
                        PreparedStatement pstm2 = con.prepareStatement(queryInfo);
                        pstm2.setString(1, user.getAddress().getAddressLine());
                        pstm2.setString(2, user.getAddress().getCountry());
                        pstm2.setString(3, user.getAddress().getProvince());
                        pstm2.setString(4, user.getAddress().getCity());
                        pstm2.setString(5, user.getAddress().getPostalCode());
                        pstm2.setTimestamp(6, new Timestamp(currentTime.getTime()));
                        pstm2.setString(7, user.getAddress().getId());
                    
                        if(pstm2.executeUpdate() == 1){
                            con.commit();
                            isUpdated = true;
                        }
                    }
                }
            }
        }catch(SQLException ex){
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.setAutoCommit(true);
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return isUpdated;
    }
    
    public boolean DeleteUser(User user){
        boolean isDeleted = false;
        Connection con = null;
        java.util.Date currentTime = new java.util.Date();
        
        String query ="UPDATE user SET last_update=?, isActive=?, isDelete=? WHERE id=?";
        String queryInfo = "UPDATE address SET last_update=?, isDelete=? WHERE id=?";
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                con.setAutoCommit(false);
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setTimestamp(1, new Timestamp(currentTime.getTime()));
                    pstm.setBoolean(2, false);
                    pstm.setBoolean(3, true);
                    pstm.setString(4, user.getId());
                    
                    if(pstm.executeUpdate() == 1){
                        PreparedStatement pstm2 = con.prepareStatement(queryInfo);
                        pstm2.setTimestamp(1, new Timestamp(currentTime.getTime()));
                        pstm2.setBoolean(2, true);
                        pstm2.setString(3, user.getAddress().getId());
                    
                        if(pstm2.executeUpdate() == 1){
                            con.commit();
                            isDeleted = true;
                        }
                    }
                }
            }
        }catch(SQLException ex){
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.setAutoCommit(true);
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return isDeleted;
    }
    
    public boolean isAccountExist(String email){
        boolean isExist = false;
        Connection con = null;
        User user = null;
        
        String query = "SELECT id, email FROM user WHERE email=? AND isDelete=false";
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(query);
                    pstm.setString(1, email);
                    
                    ResultSet rs = pstm.executeQuery();
                    while(rs.next()){
                        //Test by catch User Object
                        user = new User();
                        user.setId(rs.getString(1));
                        user.setEmail(rs.getString(2));
                        
                        isExist = true;
                    }
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return isExist;
    }
    
    public boolean activeAccount(String email, String activeCode){
        Connection con = null;
        User user = null;
        boolean isActive = false;
        
        String queryUser ="SELECT id, email, activeCode FROM user WHERE email=? AND activeCode=?";
        String queryActiveUser = "UPDATE user SET isActive=? WHERE id=?";
        
        
        try{
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
                
                if(con != null){
                    PreparedStatement pstm = con.prepareStatement(queryUser);
                    pstm.setString(1, email);
                    pstm.setString(2, activeCode);
                    
                    ResultSet rs = pstm.executeQuery();
                    while(rs.next()){
                        //Test by catch User Object
                        user = new User();
                        user.setId(rs.getString(1));
                        user.setEmail(rs.getString(2));
                        user.setActiveCode(rs.getString(3));
                    }
                    
                    if(user != null){
                        PreparedStatement pstm2 = con.prepareStatement(queryActiveUser);
                        pstm2.setInt(1, 1);
                        pstm2.setString(2, user.getId());
                        
                        if(pstm2.executeUpdate() == 1){
                            isActive = true;
                        }
                    }
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return isActive;
    }
    
    private DataSource getDataSource(){
        DataSource ds = null;
        
        try{
            Context ctx = new javax.naming.InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TechiknowledgeDB");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    };
    
}
