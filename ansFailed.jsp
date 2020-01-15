<html>
   <body>
      Sorry! You gave a wrong answer! Now be careful and try again! 
      <%
      String answer=request.getParameter("correctans");
      String email=request.getParameter("email");
      %>
      <style>
         body {
           background-image: url('img/mainn.png');
           background-size: 100% 100%;}
     </style>
      <form name=resetPass method="POST" action="verifyAnsFP">
         <input type="text" name="ans" id="ans" placeholder="Type the answer here!" required>
         <input type="hidden" id="correctans" name="correctans" value="<%=answer%>">
         <input type="hidden" id="email" name="email" value="<%=email%>">
         <button type="submit">Enter</button>
      </form>
      <div id=1></div>
   </body>
   
</html>
