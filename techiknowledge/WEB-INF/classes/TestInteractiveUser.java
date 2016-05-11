

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techiknowledge.dao.Address;
import com.techiknowledge.dao.User;
import com.techiknowledge.dao.UserDao;
import com.techiknowledge.dao.UserImp;
import com.techiknowledge.model.UserInteraction;
import com.techiknowledge.model.UserInteractionImp;

/**
 * Servlet implementation class TestInteractiveUser
 */
public class TestInteractiveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInteractiveUser() {
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
		String testMode = "UPDATE_USER";//req.getParameter("action");
		
		switch(testMode){
		    case "LOGIN":
		        testGetUser(req, res);
		        break;
		    
		    case "UPDATE_USER":
		        testAddUser(req, res);
		        break;
		    
		    default:
		        
		}
		
	}
	
	private void testGetUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	    req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        
        //Test
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        if(action.equals("LOGIN")){
            String account = req.getParameter("useraccount").trim();
            String pw = req.getParameter("password").trim();
            //User user = new User();
            UserDao userInfo = new UserImp();
            UserInteraction userGenerator = new UserInteractionImp();
            
            User user = userInfo.getUserByEmail(account, userGenerator.encrypt(pw));
            
            //Test
            out.println("<HTML>");
            out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
            out.println("<BODY>");
            out.println("<BIG>Hello World , Lonin!</BIG>");
            out.println("<h6>Input Account: " + account + "</h6><br>");
            out.println("<h6>Input Password: " + pw + "</h6>");
            
            if(user != null){
                
                out.println("<h6>return user id         : " + user.getId() + "</h6>");
                out.println("<h6>return user email      : " + user.getEmail() + "</h6>");
                out.println("<h6>return user password   : " + user.getPassword() + "</h6>");
                out.println("<h6>return user firstName  : " + user.getFirstName() + "</h6>");
                out.println("<h6>return user lastName   : " + user.getLastName() + "</h6>");
                out.println("<h6>return user phone      : " + user.getPhone() + "</h6>");
                out.println("<h6>return user gender     : " + user.getGender() + "</h6>");
                out.println("<h6>return user createTime : " + user.getCreateTime() + "</h6>");
                out.println("<h6>return user last_update: " + user.getLast_update() + "</h6>");
                out.println("<h6>return user isActive   : " + user.getIsActive() + "</h6>");
                out.println("<h6>return user isDelete   : " + user.getIsDelete() + "</h6>");
                
                out.println("<h6>return user AddressId  : " + user.getAddress().getId() + "</h6>");
                out.println("<h6>return user id         : " + user.getAddress().getUserId() + "</h6>");
                out.println("<h6>return user addressLine: " + user.getAddress().getAddressLine() + "</h6>");
                out.println("<h6>return user country    : " + user.getAddress().getCountry() + "</h6>");
                out.println("<h6>return user province   : " + user.getAddress().getProvince() + "</h6>");
                out.println("<h6>return user city       : " + user.getAddress().getCity() + "</h6>");
                out.println("<h6>return user postalCode : " + user.getAddress().getPostalCode() + "</h6>");
                out.println("<h6>return user last_update: " + user.getAddress().getLast_update() + "</h6>");
                out.println("<h6>return user isDelete   : " + user.getAddress().getIsDelete() + "</h6>");
            }else{
                out.println("<h6> Imput Wrong Account or Password! </h6>");
            }
            
            out.println("</BODY></HTML>");
        }
	}
	
	private void testAddUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
	    String UserId = UUID.randomUUID().toString();
        String UserEmail = "testUser1@gmail.com";
        String UserPassword = new UserInteractionImp().encrypt("testUser1");
        Integer type = 1;
        String UserFirstName = "test";
        String UserLastName = "User1";
        String UserPhone = "999-999-9988";
        int UserGender = 1;
        String UserActiveCode = "test98989";
        
        String AddressId = UUID.randomUUID().toString();
        String AddressAddLine = "9029 test Road. W.";
        String AddressCountry = "Japan";
        String AddressProvince = "BC";
        String AddressCity = "TOKYO";
        String AddressPostCode = "6y9y9y";
        
        Address address = new Address(
                AddressId,
                UserId,
                AddressAddLine,
                AddressCountry,
                AddressProvince,
                AddressCity,
                AddressPostCode
                );
        User user = new User(
                UserId,
                UserEmail,
                UserPassword,
                type,
                UserFirstName,
                UserLastName,
                UserPhone,
                UserGender,
                UserActiveCode,
                address
                );
        
        req.setCharacterEncoding("UTF-8");
        
        //Test
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        UserDao userInfo = new UserImp();
        UserInteraction userGenerator = new UserInteractionImp(); 
        //UserInteraction userGenerator = new UserInteractionImp();
        
        //test
        //userInfo.addUser(user);
        
        //Test
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<BIG>Test Insert , SignUp!</BIG>");
        out.println("<h6>Input Account: " + UserEmail + "</h6>");
        out.println("<h6>Input Password: " + UserPassword + "</h6>");
        
        if(userInfo.addUser(user)){
            User reGetUser = userInfo.getUserByEmail(UserEmail, UserPassword);
            
            if(reGetUser != null){
                out.println("<h6>return user id         : " + reGetUser.getId() + "</h6>");
                out.println("<h6>return user email      : " + reGetUser.getEmail() + "</h6>");
                out.println("<h6>return user password   : " + reGetUser.getPassword() + "</h6>");
                out.println("<h6>return user firstName  : " + reGetUser.getFirstName() + "</h6>");
                out.println("<h6>return user lastName   : " + reGetUser.getLastName() + "</h6>");
                out.println("<h6>return user phone      : " + reGetUser.getPhone() + "</h6>");
                out.println("<h6>return user gender     : " + reGetUser.getGender() + "</h6>");
                out.println("<h6>return user createTime : " + reGetUser.getCreateTime() + "</h6>");
                out.println("<h6>return user last_update: " + reGetUser.getLast_update() + "</h6>");
                out.println("<h6>return user isActive   : " + reGetUser.getIsActive() + "</h6>");
                out.println("<h6>return user isDelete   : " + reGetUser.getIsDelete() + "</h6>");
                
                out.println("<h6>return user AddressId  : " + reGetUser.getAddress().getId() + "</h6>");
                out.println("<h6>return user id         : " + reGetUser.getAddress().getUserId() + "</h6>");
                out.println("<h6>return user addressLine: " + reGetUser.getAddress().getAddressLine() + "</h6>");
                out.println("<h6>return user country    : " + reGetUser.getAddress().getCountry() + "</h6>");
                out.println("<h6>return user province   : " + reGetUser.getAddress().getProvince() + "</h6>");
                out.println("<h6>return user city       : " + reGetUser.getAddress().getCity() + "</h6>");
                out.println("<h6>return user postalCode : " + reGetUser.getAddress().getPostalCode() + "</h6>");
                out.println("<h6>return user last_update: " + reGetUser.getAddress().getLast_update() + "</h6>");
                out.println("<h6>return user isDelete   : " + reGetUser.getAddress().getIsDelete() + "</h6>");
            }else{
                System.out.println("-----reGetUser-------null-");
            }
            
        }else{
            out.println("<h6> Insert NEW USER ERROR! </h6>");
        }
        
        out.println("</BODY></HTML>");
	}

}
