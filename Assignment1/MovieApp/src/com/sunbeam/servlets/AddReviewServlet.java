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
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Reviews;
import com.sunbeam.pojos.Users;

@WebServlet("/AddReview")
public class AddReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>AddReview</title>");
		out.println("</head>");
		out.println("<body>");

		//HttpSession session=req.getSession();
		out.println("<h5>Add Your Review</h5>");
		out.println("<form method='post' action='AddReview'>");
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
		out.println("Review: <input type='text' name='review' id='revid'>\r\n<br/>");
		out.println("<input type='submit' value='Save'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		//String revID=req.getParameter("id");
		//int id=Integer.parseInt(revID);
		String rate=req.getParameter("rating");
		int rating=Integer.parseInt(rate);
		String review=req.getParameter("review");
		String movieID=req.getParameter("movieid");
		int movie=Integer.parseInt(movieID);
		Date modified = new Date();
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("curUser");
		int userId = user.getId();
		Reviews r = new Reviews(0, movie, review, rating, userId, modified);
		System.out.println(r);
		try(ReviewDao rDao = new ReviewDaoImpl()) {
			rDao.save(r);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("review");
	}

}


