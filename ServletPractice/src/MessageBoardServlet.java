import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<String, String> map = new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='MessageBoardServlet' method='post'>");
		out.println("Name <input type='text' name='name'><br>");
		out.println("Message <input type='text' name='message' ><br>");
		out.println("<input type='submit' value='print message'>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
	    String message = req.getParameter("message");

	    map.put(name, message);
	    out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='MessageBoardServlet' method='post'>");
		out.println("Name <input type='text' name='name'><br>");
		out.println("Message <input type='text' name='message' ><br>");
		out.println("<input type='submit' value='print message'>");
		for (String i : map.keySet()) {
			  out.println("Name: " + i + " <br> Message: " + map.get(i) + "<br>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}
	
	

	
}
