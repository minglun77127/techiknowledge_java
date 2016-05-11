

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

/**
 * Servlet implementation class TestDBconnection
 */
public class TestDBconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDBconnection() {
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
	    res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        System.out.println("-----------------------");
        try {
            Context ctx = new javax.naming.InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TechiknowledgeDB");
            if (ds != null) {
                Connection conn = ds.getConnection();

                if (conn != null) {
                    out.println("Got Connection: " + conn.toString());
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from user");
                    while (rs.next()) {
                        out.println("empNo = " + rs.getString(1));
                    }
                    conn.close();
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
