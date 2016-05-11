package com.techiknowledge.dao;
import java.util.Date;

public class Offer {
	private String id;
	private String title;
	private String offererId;
	private String acceptedBy;
	private boolean isCompleted;
	private double payAmount;
	private String description;
	private Date createTime;
	private Date last_update;
	private boolean isDeleted;
	private String serviceType;
	private String type;
	private String image;
	private User user;

	public Offer(){
		
	}

	public Offer(String id, String title, String offererId, String acceptedBy, boolean isCompleted, double payAmount,
			String description, Date createTime, Date last_update, boolean isDeleted, String serviceType, String type, String image) {
		super();
		this.id = id;
		this.title = title;
		this.offererId = offererId;
		this.acceptedBy = acceptedBy;
		this.isCompleted = isCompleted;
		this.payAmount = payAmount;
		this.description = description;
		this.createTime = createTime;
		this.last_update = last_update;
		this.isDeleted = isDeleted;
		this.serviceType = serviceType;
		this.type = type;
		this.image = image;
	}
	public Offer(String id, String title, String offererId, String acceptedBy, boolean isCompleted, double payAmount,
			String description, Date createTime, Date last_update, boolean isDeleted, String serviceType, String type, String image, User user) {
		super();
		this.id = id;
		this.title = title;
		this.offererId = offererId;
		this.acceptedBy = acceptedBy;
		this.isCompleted = isCompleted;
		this.payAmount = payAmount;
		this.description = description;
		this.createTime = createTime;
		this.last_update = last_update;
		this.isDeleted = isDeleted;
		this.serviceType = serviceType;
		this.type = type;
		this.image = image;
		this.user = user;
	}
	public Offer(String id, String title, String offererId, double payAmount,
			String description, String serviceType) {
		super();
		this.id = id;
		this.title = title;
		this.offererId = offererId;
		this.payAmount = payAmount;
		this.description = description;
		this.serviceType = serviceType;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOffererId() {
		return offererId;
	}

	public void setOffererId(String offererId) {
		this.offererId = offererId;
	}

	public String getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(String acceptedBy) {
		this.acceptedBy = acceptedBy;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String type) {
		this.type = image;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
