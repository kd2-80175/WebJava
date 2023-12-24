package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.MovieDaoImpl;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/revshare")
public class ShareServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int reviewId = Integer.parseInt(req.getParameter("id"));
		//List<Reviews> r=new;
		
		UserDao userDao = null;
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			List<Users> list = null;
			try {
				list = userDao.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try(ReviewDao mdao=new ReviewDaoImpl()){
				List<Reviews> list1=mdao.findAll();
				
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<form method='post' action='revshare'>");
		out.printf("Review Id: <input type='text' name='reviewid' value='%d' readonly/>", reviewId);
		out.println("<select name='userid'>");
		for(Users u:list)
		 out.printf("<option value='%d'>%s</option>", u.getId(), u.getFirstname());
		out.println("</select>");
		out.println("<input type='submit' value='Share'/>");
		out.println("</form>");

		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String revId=req.getParameter("id");
		int id=Integer.parseInt(revId);
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("curUser");
		int userId = user.getId();
		Reviews r = new Reviews(id, movie, review, rating, userId, modified);
		try(ReviewDao rDao = new ReviewDaoImpl()) {
			rDao.update(r);
		}
		
	}

}
