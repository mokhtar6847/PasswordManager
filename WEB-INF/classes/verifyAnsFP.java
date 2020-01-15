import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class verifyAnsFP extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
        String answer=req.getParameter("correctans");
        String typedanswer=req.getParameter("ans");
        String email=req.getParameter("email");
        if(answer.equals(typedanswer))
        {
            
            RequestDispatcher rd = req.getRequestDispatcher("/updatePass.jsp");
                rd.forward(req,res);
        }
        else
        {
            RequestDispatcher rd = req.getRequestDispatcher("/ansFailed.jsp");
            rd.forward(req,res); 
        }
    }
}