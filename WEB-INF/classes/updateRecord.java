import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

public class updateRecord extends HttpServlet
{
    public String generateMD5(String rawPassword)
    {
        try { 

			// Static getInstance method is called with hashing MD5 
			MessageDigest md = MessageDigest.getInstance("MD5"); 

			// digest() method is called to calculate message digest 
			// of an input digest() return array of byte 
			byte[] messageDigest = md.digest(rawPassword.getBytes()); 

			// Convert byte array into signum representation 
			BigInteger no = new BigInteger(1, messageDigest); 

			// Convert message digest into hex value 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		} 

		// For specifying wrong message digest algorithms 
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		}
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession sess=req.getSession(false);
        if(sess!=null)
        {
            String username=req.getParameter("username");
        String password= req.getParameter("password");
        String website=req.getParameter("website");
        String userID=(String)sess.getAttribute("email");
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        try
        {
        String url = "jdbc:mysql://127.0.0.1/passwordmanager";
        Connection con=DriverManager.getConnection(url,"root","1234");
        Statement st=con.createStatement();
        String query="UPDATE credentials SET password='"+password+"',username='"+username+"' WHERE userID='"+userID+"' and website='"+website+"';";
        int rs = st.executeUpdate( query );
            if(rs>0)
            {
                
                RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
                rd.forward(req,res);
                
            }
            else
            {
                
                
                // sess.setAttribute("error",new String("Record not found"));
                // RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
                // rd.forward(req,res);
                PrintWriter out = res.getWriter();
                out.println("<html><body><h1>Record Not Found</h1></body></html>");
                    
                }

        }
        catch(SQLException e)
        {
            // sess.setAttribute("error",new String("Record not found"));
            //     RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
            //     rd.forward(req,res);
            PrintWriter out = res.getWriter();
            out.println("<html><body><h1>Record Not Found</h1></body></html>");
        }  
    }
        else
        {
            res.sendRedirect("index.jsp");
        }
        

    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        doPost(req,res);
    }
}