<html>
   <!-- <script>
      function check()
      {
         alert(document.ans.value)
         if(document.ans.value==document.correctans.value)
         {
            return true;
         }
         document.getElementById(1).innerHTML="Please enter correct value";
         return false;
      
      }
      </script> -->
   
   <body>
      Your security Question is: 
      <%
         String str =(String)request.getAttribute("secQ");
         String ans =(String)request.getAttribute("answer");
         String email=request.getParameter("enterEmail");
         out.println(str);
      %><br>
      Now give us a correct answer!
      <style>
         body {
           background-image: url('img/mainn.png');
           background-size: 100% 100%;}
     </style>
      <form name=resetPass method="POST" action="verifyAnsFP">
         <input type="text" name="ans" id="ans" placeholder="Type the answer here!" required>
         <input type="hidden" id="correctans" name="correctans" value="<%=ans%>">
         <input type="hidden" id="email" name="email" value="<%=email%>">
         <button type="submit">Enter</button>
      </form>
      <div id=1></div>
      <!-- <%
      String a=request.getParameter("ans");
      out.println(a);
      %> -->
   </body>
   
</html>
