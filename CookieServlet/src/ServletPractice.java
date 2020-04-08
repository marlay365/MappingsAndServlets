import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletPractice")
public class ServletPractice extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
//		rd.forward(req, resp);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//		HttpSession session = req.getSession();
//		session.setAttribute("username", username);
//		session.setAttribute("password", password);
		
		Cookie cookie = new Cookie("username", username);
		Cookie cookie2 = new Cookie("password", password);
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		resp.sendRedirect("SecondServlet");
		
		//PrintWriter out = resp.getWriter();
//		out.println("this is the first servlet and then");
//		out.println(username + " " + password);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	

}

