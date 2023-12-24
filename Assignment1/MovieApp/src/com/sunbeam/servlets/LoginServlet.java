package com.sunbeam.servlets;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Users;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	String email =req.getParameter("email");
	String password = req.getParameter("passwd");
	System.out.println("Email: " + email+" and Password: "+ password);
	
	try(UserDao userDao=new UserDaoImpl()){
		Users user=userDao.findByEmail(email);
		System.out.println("Found User: "+user);
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session=req.getSession();
			session.setAttribute("curUser", user);
			System.out.println(user);
			resp.sendRedirect("review");
			
		}
		else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Failed</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h5>Invalid email or password</h5>");
			out.println("<a href='index.html'>Login Again</a>");
			out.println("</body>");
			out.println("</html>");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
