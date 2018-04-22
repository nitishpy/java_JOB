<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="login" method="post">
<table width="1330px" height="627px" align="center" style="background-color:#fff8dc">
	<tr height="50px">
       <td height="50px">
           <%@include file="header.html"%>
       </td>
    </tr>
 	
  	<tr> 
         <td align="center"> 
           <%@include file="signin.jsp"%>
         </td> 
      </tr> 
    
     <tr>
        <td height="30px">
           <%@include file="footer.html"%>
        </td>
     </tr>
</table>
</form>
</body>
</html>


