import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")

public class ServletTwo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		
//		String username = null;
//		String password = null;
//		Cookie[] cookies = req.getCookies();
//		for(Cookie c : cookies) {
//			if(c.getName().equals("username"))
//				username = c.getValue();
//			if(c.getName().equals("password"))
//				password = c.getValue();
//		}
		
		out.println("second servlet");
		out.println(username + " " + password + "</br>");

	}
	
}
