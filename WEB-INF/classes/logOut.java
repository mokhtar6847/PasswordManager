import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
public class logOut extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    
        HttpSession session=req.getSession(false);
        if(session==null)
        {
            res.sendRedirect("index.jsp");
        }
        else
        {
            session.invalidate();
            PrintWriter out=res.getWriter();
            // out.println("You have been logged out");
            // try{Thread.sleep(10000);}
            // catch(InterruptedException e){}
            res.sendRedirect("index.jsp");
        }
    }
}