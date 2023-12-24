package com.sunbeam.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		
		HttpSession session=req.getSession();
		User curUser=(User)session.getAttribute("curUser");
		out.printf("Hello,%s %s<hr/>\r\n",curUser.getFirstName(),curUser.getLastName());
		
		out.println("<h5>Election Candidates</h5>");
		out.println("<form method='post' action='vote'>");
		try(CandidateDao candDao=new CandidateDaoImpl()){
			List<Candidate> list= candDao.findAll();
			for(Candidate c:list) {
				out.printf("<input type='radio' name='candidate' value='%d'/> %s-%s<br/>\r\n", c.getId(),c.getName(),c.getParty());
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<input type='submit' value='Vote'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
