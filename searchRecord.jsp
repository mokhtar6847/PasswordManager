<%@ page session="false" %>
<%
    HttpSession session=request.getSession(false);
    String username="",password="";
    if(session==null)
    {response.sendRedirect("index.jsp");}
    else
    {
    String email=(String)session.getAttribute("email");
    username=(String)request.getAttribute("username");
    password=(String)request.getAttribute("password");
    }
%>

<html>
    <body>
        <style>
            body {
              background-image: url('img/mainn.png');
              background-size: 100% 100%;}
              h1{
                  text-align:center;
                  margin-top: 120px;
                  color:white;
                  text-decoration:underline;
              }
        </style>
        <h1> Your username is: <%=username%> and password is: <%=password%></h1>
    </body>

</html>