<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ContextAttribute.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my ContextAttribute.jsp page. <br>
    <%
    String email=(String)application.getAttribute("email");
     String password=(String)application.getAttribute("password");
     out.println("<br>Context Parameter in JSP");
     out.println("<br>Email:"+email);
      out.println("<br>passsword:"+password);
     /*  application.removeAttribute("password");
     String email1=(String)application.getAttribute("email");
     String password1=(String)application.getAttribute("password");
     out.println("<br>Context Parameter in JSP");
     out.println("<br>Email1:"+email);
     out.println("<br>passsword1:"+password1); */
     %>
  </body>
</html>
