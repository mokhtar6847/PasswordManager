import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 


public class updatePass extends HttpServlet
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
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
        String email=req.getParameter("email");
        String newPassword=req.getParameter("newpass");
        newPassword=generateMD5(newPassword);
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
      
            String check="update users SET password='"+newPassword+"' WHERE email='"+email+"';";
         
            int i = st.executeUpdate( check );
            if(i>0)
            {
                PrintWriter a=res.getWriter();
                
                a.println("Password updated");
                // RequestDispatcher rd = req.getRequestDispatcher("/askSecQ.jsp");
                // rd.forward(req,res);
            }
            else
            {
                
                PrintWriter a=res.getWriter();
                a.println(email);
                a.println(newPassword);
                a.println("Password not updated");
                // RequestDispatcher rd = req.getRequestDispatcher("failure");
                // rd.forward(req,res);
                    
                }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        
        

    }
}