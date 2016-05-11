package com.techiknowledge.dao;

import java.util.ArrayList;

public interface OfferDao {
	public Offer getOffer(String offerId);
	
	public ArrayList<Offer> getOfferByUser(User user);
	
	public ArrayList<Offer> getOfferDetailByCity(String city);
	
	public boolean createOffer(Offer offer);
	
	public boolean updateOffer(Offer offer);
	
	public boolean updateOfferByBid(String offerId, String bidderId, double bid);
	
	public boolean deleteOffer(Offer offer);
	
	public boolean deleteOfferById(String offerId);
	
	public boolean uploadOfferImg(String offerId, String image);
	
	public boolean acceptOfferById(String OfferId);
}