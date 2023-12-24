package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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

@WebServlet("/revedit")
public class ReviewEdit extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String revid=req.getParameter("id");
		int id =Integer.parseInt(revid);
		Reviews r=null;
		try(ReviewDao revDao=new ReviewDaoImpl()){
			r=revDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>Edit Review</h5>");
		out.println("<form method='post' action='revedit'>");
		out.printf("Id: <input type='text' name='id' value='%s' readonly>\r\n<br/>",r.getId());
		try(MovieDao mdao=new MovieDaoImpl()){
			List<Movie> list=mdao.findAll();
		out.println("Movie :<select name='movieid'>");
		for(Movie m:list)
			out.printf("<option value='%d'>%s</option>",m.getId(),m.getTitle());
		out.println("</select> <br/>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("Rating: <input type='number' name='rating' id='ratid' >\r\n<br/>");
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("curUser");
		int userId = user.getId();
		out.printf("User Id: <input type='number' name='id' value='%d' readonly>\r\n<br/>",userId);
		out.println("Review: <input type='text' name='review' id='revid'>\r\n<br/>");
		out.println( "<input type='submit' value='Update'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost (HttpServletRequest req,HttpServletResponse resp) throws IOException {
		        String revID=req.getParameter("id");
				int id=Integer.parseInt(revID);
		String movieID=req.getParameter("movieid");
		int movie=Integer.parseInt(movieID);
		String rate=req.getParameter("rating");
		int rating=Integer.parseInt(rate);
		String review=req.getParameter("review");
		Date modified = new Date();
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("curUser");
		int userId = user.getId();
		Reviews r = new Reviews(id, movie, review, rating, userId, modified);
		try(ReviewDao rDao = new ReviewDaoImpl()) {
			rDao.update(r);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("review");
		
		
		
	}

}
