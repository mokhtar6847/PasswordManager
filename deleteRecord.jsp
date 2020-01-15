<%@ page session="false" %>
<%
    HttpSession session=request.getSession(false);
    if(session==null)
    {response.sendRedirect("index.jsp");}
    else
    {String email=(String)session.getAttribute("email");}
%>

<html>
    <body>
        <style>
            body {
              background-image: url('img/mainn.png');
              background-size: 100% 100%;}
        </style>
        <form name="updateRecord" method="post" action="deleteRecord">
            Website: <input type="text" name="website">
            <button type="submit">Update</button>
        </form>
    </body>
</html>