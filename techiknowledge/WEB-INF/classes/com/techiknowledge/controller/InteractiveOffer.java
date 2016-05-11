package com.techiknowledge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techiknowledge.dao.Offer;
import com.techiknowledge.dao.OfferDao;
import com.techiknowledge.dao.OfferImp;
import com.techiknowledge.dao.User;
import com.techiknowledge.dao.Address;

/**
 * Servlet implementation class InteractiveOffer
 */
public class InteractiveOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InteractiveOffer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--------enter-post--------");
		req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("User");
        Address address = user.getAddress();
        
        if(action.equals("CREATEOFFER")){
        	
        	Offer offer = new Offer(
        			java.util.UUID.randomUUID().toString(),
        			req.getParameter("title").trim(),
        			user.getId(),
        			Double.parseDouble(req.getParameter("pay").trim()),
        			req.getParameter("description").trim(),
        			req.getParameter("servType").trim()
        			);
        	System.out.println("--------offerInit--------");
        	OfferDao offerInfo = new OfferImp();
        	if(offerInfo.createOffer(offer)){
        		System.out.println("--------offerCreated--------");
        	}else{
        		System.out.println("-----offerCreationFailed-----");
        	}
        	//RequestDispatcher rd = req.getRequestDispatcher("/views/OfferList.jsp");
            
            //rd.forward(req, res);
        	res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().println("offercreated");
            
        }else if(action.equals("LOADOFFER")){
        	OfferDao offerInfo = new OfferImp();
        	if(user.getType()==1){
        		session.setAttribute("offerList", offerInfo.getOfferByUser(user));
        	}else if(user.getType()==0){
        		session.setAttribute("offerList", offerInfo.getOfferDetailByCity(address.getCity()));
        	}
        }else if(action.equals("DELETEOFFER")){
        	OfferDao offerInfo = new OfferImp();
        	offerInfo.deleteOfferById(req.getParameter("offerId"));
        }else if(action.equals("BIDOFFER")){
        	OfferDao offerInfo = new OfferImp();
        	offerInfo.updateOfferByBid(req.getParameter("offerId"), user.getId(), Double.parseDouble(req.getParameter("pay")));
        	res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write("bidsuccess");
        }else if(action.equals("UPLOAD")){
        	OfferDao offerInfo = new OfferImp();
        	offerInfo.uploadOfferImg(req.getParameter("offerId"), req.getParameter("img"));
        	res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write("Image upload success");
        }else if(action.equals("ACCEPT")){
        	OfferDao offerInfo = new OfferImp();
        	offerInfo.acceptOfferById(req.getParameter("offerId"));
        	res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write("Bid accepted");
        }
	}
}
