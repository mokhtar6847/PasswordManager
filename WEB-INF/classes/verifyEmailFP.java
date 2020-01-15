import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class verifyEmailFP extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
        String email=req.getParameter("enterEmail");
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
        //password=generateMD5(password);
            String check="SELECT * FROM users WHERE email='"+email+"';";
         
            ResultSet rp = st.executeQuery( check );
            if(rp.next())
            {
                
                String secQ=rp.getString("secq");
                String Ans=rp.getString("answer");
                req.setAttribute("secQ",secQ);
                req.setAttribute("answer",Ans);
                RequestDispatcher rd = req.getRequestDispatcher("/askSecQ.jsp");
                rd.forward(req,res);
            }
            else
            {
                
                
                RequestDispatcher rd = req.getRequestDispatcher("/emailFailed.jsp");
                rd.forward(req,res);
                    
                }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        
        

    }
}