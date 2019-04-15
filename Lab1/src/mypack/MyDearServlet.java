package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyDearServlet extends HttpServlet{
	Connection con=null;
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		try {
			PrintWriter out=response.getWriter();
			out.write("Welcome to the homepage");
		}
		catch(IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		 out.println("This is my Jsp page");
		//out.println("name:"+request.getParameter("sno"));
		String sno=request.getParameter("sno");
		//out.println("<br>class:"+request.getParameter("sname"));
		String sname=request.getParameter("sname");
		//out.println("<br>id:"+request.getParameter("ssex"));
		String ssex=request.getParameter("ssex");
		String sql="insert into student(sno,sname,ssex,sage,sdept)values('"+sno+"','"+sname+"','"+ssex+"',' ',' ')";
		//System.out.println("insert-->"+sql);
		try {
			Statement st=this.con.createStatement();
		    int n=st.executeUpdate(sql);
		    if(n>0){
		    	System.out.println("insert is success"); 
		    	  sql="select sno,sname,ssex from student";
				    ResultSet rs=st.executeQuery(sql);
				    while(rs.next()){
				    	out.println(rs.getString("sno")+"--"+rs.getString("sname")+"--"+rs.getString("ssex")+"<br>");
				    }
				    
		    } 
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init() {
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=SQLText";
		String username="Test";
		String password="1234567";
		try {
			Class.forName(driver);
			 this.con=DriverManager.getConnection(url, username, password);
			System.out.println("conn in init()");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}