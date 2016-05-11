package com.techiknowledge.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.sql.DataSource;

public class OfferImp implements OfferDao {
		public Offer getOffer(String offerId){
			Offer offer=null;
			Connection con=null;
			String query="SELECT id, title, offererId, acceptedBy, isCompleted, payAmount, description, createTime, last_update, isDelete, image FROM offer WHERE id=? AND isDelete=false;";
			
			try{
				DataSource ds = getDataSource();
				if(ds!=null){
					con=ds.getConnection();
					if(con!=null){
						PreparedStatement pstm=con.prepareStatement(query);
						pstm.setString(1, offerId);
						ResultSet rs = pstm.executeQuery();
						while(rs.next()){
							 offer=new Offer(
									rs.getString("id"),
									rs.getString("title"),
									rs.getString("offererId"),
									rs.getString("accpetBy"),
									rs.getBoolean("isCompleted"),
									rs.getDouble("payAmount"),
									rs.getString("description"),
									rs.getDate("createTime"),
									rs.getDate("last_update"),
									rs.getBoolean("isDelete"),
									rs.getString("serviceType"),
									rs.getString("type"),
									rs.getString("image")
							);
						}
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(con!=null){
						con.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			return offer;
		}
		public ArrayList<Offer> getOfferByUser(User user){
			
			ArrayList<Offer> offerList = new ArrayList<Offer>();
			Connection con=null;
			//String query="SELECT id, title, offererId, acceptedBy, isCompleted, payAmount, description, createTime, last_update, isDelete, serviceType, type FROM offer WHERE offererId=? AND isDelete=0 ORDER BY createTime DESC;";
			String query=
			"SELECT offer.id, offer.title, offer.offererId, offer.acceptedBy, offer.isCompleted, offer.payAmount, offer.description, offer.createTime, offer.last_update, offer.isDelete, offer.serviceType, offer.type, offer.image, "+
					"bidder.id as bidderId, bidder.email as bidderEmail, bidder.firstName as bidderFName, bidder.lastName as bidderLName, bidder.gender bidderGender, bidder.phone as bidderPhone "+ 
			"FROM offer "+ 
				"LEFT JOIN user as bidder on offer.bidderId = bidder.id "+
			"WHERE offererId=? AND offer.isDelete=0 ORDER BY createTime DESC;";
			System.out.println("--------retrieve list---------");
			try{
				DataSource ds = getDataSource();
				if(ds!=null){
					con=ds.getConnection();
					if(con!=null){
						PreparedStatement pstm=con.prepareStatement(query);
						pstm.setString(1, user.getId());
						System.out.println("--------retrieve list for"+user.getFirstName()+"---------");
						ResultSet rs = pstm.executeQuery();
						while(rs.next()){
							offerList.add(new Offer(
									rs.getString("id"),
									rs.getString("title"),
									rs.getString("offererId"),
									rs.getString("acceptedBy"),
									rs.getBoolean("isCompleted"),
									rs.getDouble("payAmount"),
									rs.getString("description"),
									rs.getDate("createTime"),
									rs.getDate("last_update"),
									rs.getBoolean("isDelete"),
									rs.getString("serviceType"),
									rs.getString("type"),
									rs.getString("image"),
									new User(
											rs.getString("bidderId"),
											rs.getString("bidderFName"),
											rs.getString("bidderLName"),
											rs.getString("bidderEmail"),
											rs.getString("bidderPhone"),
											rs.getInt("bidderGender")
										)
									)
							);
						}
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(con!=null){
						con.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return offerList;
		}
		public ArrayList<Offer> getOfferDetailByCity(String city){
			ArrayList<Offer> offerList = new ArrayList<Offer>();
			Connection con=null;
			String query="SELECT offer.id, offer.title, offer.offererId, offer.acceptedBy, offer.isCompleted, offer.payAmount, offer.description, offer.createTime, offer.last_update, offer.isDelete, offer.serviceType, offer.type, offer.image, user.firstName, user.lastName, user.gender, user.phone, address.addressLine, address.country, address.province, address.city, address.postalCode FROM offer INNER JOIN user ON offer.offererId = user.id INNER JOIN address ON address.userId = user.id WHERE address.city=? AND offer.isDelete=0 ORDER BY offer.createTime DESC;";
			System.out.println("--------retrieve list---------");
			try{
				DataSource ds = getDataSource();
				if(ds!=null){
					con=ds.getConnection();
					if(con!=null){
						PreparedStatement pstm=con.prepareStatement(query);
						pstm.setString(1, city);
						System.out.println("--------retrieve list for "+city+" ---------");
						ResultSet rs = pstm.executeQuery();
						while(rs.next()){
							offerList.add(new Offer(
									rs.getString("id"),
									rs.getString("title"),
									rs.getString("offererId"),
									rs.getString("acceptedBy"),
									rs.getBoolean("isCompleted"),
									rs.getDouble("payAmount"),
									rs.getString("description"),
									rs.getDate("createTime"),
									rs.getDate("last_update"),
									rs.getBoolean("isDelete"),
									rs.getString("serviceType"),
									rs.getString("type"),
									rs.getString("image"),
									new User(
										rs.getString("firstName"),
										rs.getString("lastName"),
										rs.getString("phone"),
										rs.getInt("gender"),
										new Address(
												rs.getString("addressLine"),
												rs.getString("country"),
												rs.getString("province"),
												rs.getString("city"),
												rs.getString("postalCode")
										)
									)
									)
							);
						}
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(con!=null){
						con.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return offerList;
		}
		
		public boolean createOffer(Offer offer){
			
			boolean isCreated = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        //String query ="INSERT INTO offer (id, title, offererId, acceptedBy, isCompleted, payAmount, description, createTime, last_update, isDelete, serviceType, type) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	        String query ="INSERT INTO offer (id, title, offererId, payAmount, description, createTime, last_update, serviceType) VALUES(?,?,?,?,?,?,?,?)";
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                System.out.println(offer.getId());
	                System.out.println(offer.getTitle());
	                System.out.println(offer.getOffererId());
	                System.out.println(offer.getPayAmount());
	                System.out.println(offer.getDescription());
	                System.out.println(new Timestamp(currentTime.getTime()));
	                System.out.println(new Timestamp(currentTime.getTime()));
	                System.out.println(offer.getServiceType());
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setString(1, offer.getId());
	                    pstm.setString(2, offer.getTitle());
	                    pstm.setString(3, offer.getOffererId());
	                    //pstm.setString(4, offer.getAcceptedBy());
	                    //pstm.setBoolean(5, offer.isCompleted());
	                    pstm.setDouble(4, offer.getPayAmount());
	                    pstm.setString(5, offer.getDescription());
	                    pstm.setTimestamp(6, new Timestamp(currentTime.getTime()));
	                    pstm.setTimestamp(7, new Timestamp(currentTime.getTime()));
	                    //pstm.setBoolean(10, offer.isDeleted());
	                    pstm.setString(8, offer.getServiceType());
	                    //pstm.setString(12, offer.getType());
	                    if(pstm.executeUpdate() == 1){
                            isCreated = true;
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
	        return isCreated;
		};
		
		public boolean updateOffer(Offer offer){
		
			boolean isUpdated = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET title=?, offererId=?, acceptedBy=?, isCompleted=?, payAmount=?, description=?, createTime=?, last_update=?, isDelete=?, serviceType=?, type=? WHERE id=?";
	         
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setString(1, offer.getTitle());
	                    pstm.setString(2, offer.getOffererId());
	                    pstm.setString(3, offer.getAcceptedBy());
	                    pstm.setBoolean(4, offer.isCompleted());
	                    pstm.setDouble(5, offer.getPayAmount());
	                    pstm.setString(6, offer.getDescription());	         
	                    pstm.setTimestamp(7, new Timestamp(currentTime.getTime()));
	                    pstm.setTimestamp(8, new Timestamp(currentTime.getTime()));
	                    pstm.setBoolean(9, offer.isDeleted());
	                    pstm.setString(10, offer.getServiceType());
	                    pstm.setString(11, offer.getType());
	                    
	                    if(pstm.executeUpdate() == 1){
	                        isUpdated = true;
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
		};
		public boolean updateOfferByBid(String offerId, String bidderId, double bid){
			boolean isUpdated = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET payAmount=?, bidderId=? WHERE id=?";
	         
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setDouble(1, bid);
	                    pstm.setString(2, bidderId);
	                    pstm.setString(3, offerId);
	                    if(pstm.executeUpdate() == 1){
	                        isUpdated = true;
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
		
		public boolean deleteOffer(Offer offer){
			
			boolean isDeleted = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET last_update=?,  isDelete=? WHERE id=?";
	        
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setTimestamp(1, new Timestamp(currentTime.getTime()));
	                    pstm.setBoolean(2, true);
	                    pstm.setString(4, offer.getId());
	                    
	                    if(pstm.executeUpdate() == 1){
	                        isDeleted = true;
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
		};
		public boolean deleteOfferById(String offerId){
			boolean isDeleted = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET last_update=?,  isDelete=? WHERE id=?";
	        
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setTimestamp(1, new Timestamp(currentTime.getTime()));
	                    pstm.setBoolean(2, true);
	                    pstm.setString(3, offerId);
	                    
	                    if(pstm.executeUpdate() == 1){
	                        isDeleted = true;
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
		public boolean uploadOfferImg(String offerId, String image){
			boolean isUpdated = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET image=? WHERE id=?";
	         
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setString(1, image);
	                    pstm.setString(2, offerId);
	                    if(pstm.executeUpdate() == 1){
	                        isUpdated = true;
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
		
		public boolean acceptOfferById(String offerId){
			boolean isUpdated = false;
	        Connection con = null;
	        java.util.Date currentTime = new java.util.Date();
	        
	        String query ="UPDATE offer SET acceptedBy=? WHERE id=?";
	         
	        try{
	            DataSource ds = getDataSource();
	            if(ds != null){
	                con = ds.getConnection();
	                con.setAutoCommit(false);
	                
	                if(con != null){
	                    PreparedStatement pstm = con.prepareStatement(query);
	                    pstm.setInt(1, 1); ;
	                    pstm.setString(2, offerId);
	                    if(pstm.executeUpdate() == 1){
	                        isUpdated = true;
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
