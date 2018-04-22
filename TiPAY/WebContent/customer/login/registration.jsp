<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<table width="1330px" height="627px" align="center" style="background-color:#fff8dc">
	<tr height="50px">
       <td height="50px">
           <%@include file="header.html"%>
       </td>
    </tr>
 	
 	<tr>
        <td align="center">
           <%@include file="signup.html"%>
        </td>
     </tr>
    
     <tr>
        <td height="30px">
           <%@include file="footer.html"%>
        </td>
     </tr>

</table>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>

<%
String fname = request.getParameter("fname");
String mname = request.getParameter("mname");
String lname = request.getParameter("lname");
String day = request.getParameter("day");
String month = request.getParameter("month");
String year = request.getParameter("year");
String gender = request.getParameter("gender");
String address = request.getParameter("address");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String password = request.getParameter("password");
Validation vd = new Validation();
if (vd.regValidation(fname, mname, lname, day, month, year, gender, address, email, mobile, password)){
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:8080:xe";
		Connection con = DriverManager.getConnection(url, "system", "Nitish");
		Statement st = con.createStatement();
		ResultSet rs;
		String sql = "insert into customer values(101, `fname`, `mname`, `ln)   ";
		rs = st.executeQuery(sql);
		while(rs.next()){
			//response.sendRedirect("https://www.google.com");
			response.sendRedirect("index.html");
			//System.out.println(rs.getNString(1)+"-"+rs.getNString(2));			
		}
		con.close();
		
		
	}catch(Exception ex){
        out.println("Unable to connect to database"+ex);}
	
}
%>


</body>
</html>