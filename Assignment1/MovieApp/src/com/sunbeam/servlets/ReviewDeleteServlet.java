package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.daos.ReviewDaoImpl;

@WebServlet("/revdel")
public class ReviewDeleteServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		String revId=req.getParameter("id");
		int id=Integer.parseInt(revId);
		int cnt=0;
		try(ReviewDao revDao =new ReviewDaoImpl()){
			cnt =revDao.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message="Review Deleted: " + cnt;
		req.setAttribute(message, message);
		
		RequestDispatcher rd =req.getRequestDispatcher("review");
		rd.forward(req, resp);
		
	}

}
