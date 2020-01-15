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
        <form name="changePass" method="post" action="changePassword" onsubmit="return validate()">
        <input type="password" name="currentpass" placeholder="Enter Current Password">
        <input type="password" name="newpass" placeholder="Enter New Password">
        <input type="password" name="confirmpass" placeholder="Confirm New Password">
        <button type="submit">Change</button>
        </form>
    </body>

    <script>
    
function validate()
{

	if(document.changePass.newpass.value != document.changePass.confirmpass.value)
	{
		document.changePass.confirmpass.style.backgroundColor="red";
		document.changePass.confirmpass.focus();
		return false;
	}
	else
	{
		return true;
	}
}
    </script>
</html>