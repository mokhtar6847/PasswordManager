<html>
    <body>
        <%
        String email=request.getParameter("email");
        System.out.println(email);
        %>
        <style>
            body {
              background-image: url('img/mainn.png');
              background-size: 100% 100%;}
        </style>
        Bull's Eye..!!
        <form name=updatePass method="POST" action="updatePass">
            <input type="text" name="newpass" id="newpass" placeholder="Type New Password">
            <input type="hidden" name="email" value="<%=email%>">
            <button type="submit">Update Password</button>
        </form>
    </body>
</html>