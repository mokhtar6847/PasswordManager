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

public class login extends HttpServlet
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
        String email=req.getParameter("email");
        String password= req.getParameter("password");
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
        password=generateMD5(password);
            String check="SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"';";
            ResultSet rp = st.executeQuery( check );
            if(rp.next())
            {
                HttpSession session = req.getSession(true);
                //RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
                session.setAttribute("email",email);
              res.sendRedirect("main.jsp");
                //rd.forward(req,res);
                
            }
            else
            {
                
                // req.setAttribute("error",new String("Invalid Email/Password"));
                // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                // rd.forward(req,res);
                PrintWriter out = res.getWriter();
                out.println("<html><body><h1>Invalid Email/Password</h1></body></html>");
                
                    
                }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        
        

    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        doPost(req,res);
    }
}