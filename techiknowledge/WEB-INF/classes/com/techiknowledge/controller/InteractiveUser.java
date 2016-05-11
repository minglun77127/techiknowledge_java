package com.techiknowledge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.*;

import com.techiknowledge.dao.*;
import com.techiknowledge.model.*;

/**
 * Servlet implementation class InteractiveUser
 */
public class InteractiveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InteractiveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        Utility util = null;
        UserDao userInfo = null;
        UserInteraction userGenerator = null;
        HttpSession session = null;
        String message = null; 
        Gson gson = null;
        
        System.out.println("--------action--###---" + req.getParameter("action"));
        
        if(action.equals("LOGIN")){
            String account = req.getParameter("email").trim();
            String pw = req.getParameter("password").trim();
            util = new Utility();
            userInfo = new UserImp();
            userGenerator = new UserInteractionImp();
            session =  req.getSession();
            
            req.setAttribute("test", "test");
            
            if(util.isValidate(account) && util.isValidate(pw)){
                User user = userInfo.getUserByEmail(account, userGenerator.encrypt(pw));
                
                if(user != null){
                    if(user.getIsActive()){
                    	 user.setIsLogin(true);
                         session.setAttribute("User", user);
                    }else{
                    	message = "Account not activated";
                    }
                }else{
                    session.setAttribute("Message", "Wrong Account Information. Please try again.");
                    message = "Input Wrong Account or Password!";
                }
            }else{
                session.setAttribute("Message", "Input Wrong Account or Password!");
                message = "Input Wrong Account or Password!";
            }
            
            if(message != null){
                /*  JSON */
                JsonParser jp = new JsonParser();
                JsonObject o = jp.parse("{\"message\":\"" + message + "\"}").getAsJsonObject();
                
                /*gson = new Gson();
                String json = gson.toJson(session);*/
                
                res.setContentType("application/json");
                res.getWriter().write(o.toString());
                
                
                /*req.setAttribute("Message", message);
                req.getRequestDispatcher("/LogIn.jsp").forward(req, res);  
            	
            	res.setContentType("text/plain");
                res.setCharacterEncoding("UTF-8");
                res.getWriter().write(message);*/
            }else{
                RequestDispatcher rd = req.getRequestDispatcher("/views/Offer.jsp");
                rd.forward(req, res);
            }
        }
        else if(action.equals("LOGOUT")){
        	System.out.println("--------enter logout--------");
        	session =  req.getSession();
            session.invalidate();
            //RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            //rd.forward(req, res);
        }
        else if(action.equals("REGISTER")){
        	System.out.println(req.getParameter("email"));
        	System.out.println(req.getParameter("password"));
            String account = req.getParameter("email").trim();
            String pw = req.getParameter("password").trim();
            util = new Utility();
            userGenerator = new UserInteractionImp();
            MessageMail mail = new MessageMail();
            session =  req.getSession();
            //String resUrl = "/LogIn.jsp";
            
            if(util.isValidate(account) && util.isValidate(pw)){
                userInfo = new UserImp();
                String userId = java.util.UUID.randomUUID().toString();
                System.out.println(req.getParameter("type"));
                User user = new User(
                        userId,
                        account,
                        userGenerator.encrypt(pw),
                        Integer.parseInt(req.getParameter("type")),
                        req.getParameter("firstName").trim(),
                        req.getParameter("lastName").trim(),
                        req.getParameter("phone").trim(),
                        Integer.parseInt(req.getParameter("gender")),
                        userGenerator.encrypt(account + pw),
                        new Address(
                                java.util.UUID.randomUUID().toString(),
                                userId,
                                req.getParameter("address").trim(),
                                req.getParameter("country"),
                                req.getParameter("province"),
                                req.getParameter("city"),
                                req.getParameter("postalCode").trim()
                                )
                        );
                if(userInfo.isAccountExist(account)){
                    message = account + " already exist! Please enter another email. Thank you.";
                }else{
	                if(userInfo.addUser(user) && mail.sendMail(account, userGenerator.getMailContent(user))){
	                    user.setIsLogin(true);
	                    session.setAttribute("Message", "Create Account!");
	                    
	                    //message="You account has been created, an activation link has been sent to your email: " + account;
	                    System.out.println("--------Create Account!--------");
	                    
	                }else{
	                    session.setAttribute("Message", "Create Account Faile!");
	                    
	                    message="Create Account Faile!!";
	                    System.out.println("--------Create Account Faile!!--------");
	                }
                }
                /*resUrl = "/views/SignUp.jsp";
                session.setAttribute("User", user);*/
                
            	//res.setContentType("text/plain");
                //res.setCharacterEncoding("UTF-8");
                //res.getWriter().write(message);
                
            }else{
                //session.setAttribute("Message", "Please reset Account or Password!");
            	
            	System.out.println("--------Please reset Account or Password!--------");
            	message = "Please reset Account or Password!";
            	//res.setContentType("text/plain");
                //res.setCharacterEncoding("UTF-8");
                //res.getWriter().write(message);
            }
            
            //RequestDispatcher rd = req.getRequestDispatcher(resUrl);
            //rd.forward(req, res);
            if(message != null){
                /*  JSON */
                JsonParser jp = new JsonParser();
                JsonObject o = jp.parse("{\"message\":\"" + message + "\"}").getAsJsonObject();
                
                /*gson = new Gson();
                String json = gson.toJson(session);*/
                
                res.setContentType("application/json");
                res.getWriter().write(o.toString());
                
                
                /*req.setAttribute("Message", message);
                req.getRequestDispatcher("/LogIn.jsp").forward(req, res);  
            	
            	res.setContentType("text/plain");
                res.setCharacterEncoding("UTF-8");
                res.getWriter().write(message);*/
            }else{
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.forward(req, res);
            }
        }
        else if(action.equals("EDIT")){
            util = new Utility();
            userGenerator = new UserInteractionImp();
            session = req.getSession();
            User user = (User)session.getAttribute("User");
            session.removeAttribute("Message");
            String resUrl = "/views/SignUp.jsp";
            
            if(user != null && user.getIsLogin() == true){
                //System.out.println("----User FirstName:------" + user.getFirstName());
                
                user.setFirstName(req.getParameter("firstName").trim());
                user.setLastName(req.getParameter("lastName").trim());
                //user.setGender(Integer.parseInt(req.getParameter("gender")));
                user.getAddress().setAddressLine(req.getParameter("address").trim());
                user.getAddress().setCountry(req.getParameter("country"));
                user.getAddress().setProvince(req.getParameter("province"));
                user.getAddress().setCity(req.getParameter("city"));
                user.getAddress().setPostalCode(req.getParameter("postalCode").trim());
                
                //if(req.getParameter("password") != "" && util.isValidate(req.getParameter("password"))){
                    //user.setPassword(userGenerator.encrypt(req.getParameter("password")));
                //}
                
                userInfo = new UserImp();
                if(userInfo.UpdateUser(user)){
                    session.setAttribute("Message", "Edit Information Correct!");
                }else{
                    session.setAttribute("Message", "Edit Information Faile!");
                }
                
                //req.getParameter("password") == null ? System.out.println("----User FirstName:------") : System.out.println("----xcxcx------")
                
            }else{
                session.setAttribute("Message", "Please Log In Agan!");
                resUrl = "/Login.jsp";
            }
            
            //RequestDispatcher rd = req.getRequestDispatcher(resUrl);
            //rd.forward(req, res);
        }
        else if(action.equals("CHECKEMAIL")){
            util = new Utility();
            userInfo = new UserImp();
            req.setCharacterEncoding("UTF-8");
            String account = req.getParameter("email").trim();
            message = "";
            
            //System.out.println("--------check email: " + account);
            if(util.isValidate(account)){
                if(userInfo.isAccountExist(account)){
                    message = account + "already exist! Please enter another email. Thank you.";
                }
            }else{
                message = "You enter " + account + " irregularities. Please enter again. Thank you.";
            }
            
            res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write(message);
        }
        else if(action.equals("ACTIVE")){
            userInfo = new UserImp();
            req.setCharacterEncoding("UTF-8");
            String resUrl = "/index.jsp";
            
            System.out.println("----ACTIVE---- email: " + req.getParameter("email"));
            System.out.println("----ACTIVE--- active code: " + req.getParameter("value"));
            
            if(userInfo.activeAccount(req.getParameter("email"), req.getParameter("value"))){
                RequestDispatcher rd = req.getRequestDispatcher(resUrl);
                rd.forward(req, res);
            }else{
                res.setContentType("text/plain");
                res.setCharacterEncoding("UTF-8");
                res.getWriter().write("Active Faile!");
            }
        }
	}

}
