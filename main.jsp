 <%@ page session="false" %> <!--//JSPs by default creates a session, to avoid that I wrote this line  -->
<%
    HttpSession session=request.getSession(false);
    if(session==null)
    {response.sendRedirect("index.jsp");}
    else
    {
        String email=(String)session.getAttribute("email");
    }
%>


<html>
    <body>
        <style>
            body {
              background-image: url('img/mainn.png');
              background-size: 100% 100%;}
        </style>
        <form name="logOut" method="POST" action="logOut" >
            <button style="float:right;" type="submit"> Log Out </button>
        </form>


        <div Style=float:left>
        <form name="addRecord" method="POST" action="addRecord.jsp">
            <button type="submit">Add a New Credential</button>
        </form>
        <form name="updateRecord" method="POST" action="updateRecord.jsp">
            <button type="submit">Update a Credential</button>
        </form>
        <form name="deleteRecord" method="POST" action="deleteRecord.jsp">
            <button type="submit">Delete a Credential</button>
        </form></div>
        
        <div Style=float:right>
        <form name="searchRecord" method="POST" action="searchRecord">
            <input type="search" name="website" placeholder="Enter Website Name">
            <button type="submit">Search a credential</button>
      &nbsp;
        </form>


        <a Style="float:right ; margin-top:520px" href="changePassword.jsp">Change Account's Master Password</a>
    
    
    </div>


        
        
    



       </body>
   
</html>