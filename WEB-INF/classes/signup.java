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

public class signup extends HttpServlet
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
    {   String email=req.getParameter("email");
        String cpassword=req.getParameter("cpassword");
        String password= req.getParameter("password");
        String question=req.getParameter("question");
        String answer=req.getParameter("answer");
        
        
        
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




        if(password.equals(cpassword))
        { 
            password=generateMD5(password);
            String check="select * from users where email='"+email+"'";
            ResultSet rp = st.executeQuery( check );
            if(rp.next())
            {
                //req.setAttribute("error",new String("The User Already Exists!"));
                // RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                // rd.forward(req,res);
                PrintWriter out = res.getWriter();
                out.println("<html><body><h1>The User Already Exists</h1></body></html>");
            }
            else
            {
                
                String query="insert into users(email,password,secq,answer) values ('"+email+"','"+password+"','"+question+"','"+answer+"')";
                int rs = st.executeUpdate( query );
                
                
                PrintWriter out = res.getWriter();
                out.println("<html><body><h1>Account Has Been Created</h1></body></html>");
                    
                }
        }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    
        
    
        

    }
}

