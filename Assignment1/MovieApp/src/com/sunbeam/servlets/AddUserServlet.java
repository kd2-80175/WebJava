package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Users;
@WebServlet("/Sign Up")
public class AddUserServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email =req.getParameter("email");
		String password = req.getParameter("passwd");
		String mobile=req.getParameter("mob");
		String birthdate=req.getParameter("birthday");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bod = sdf.parse(birthdate);
			Users u = new Users(0, fname, lname, email, password, mobile, bod);
			try(UserDao rDao = new UserDaoImpl()) {
				rDao.save(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login Failed</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>User Added Successfully</h5>");
		out.println("<a href='index.html'>Login Again</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
