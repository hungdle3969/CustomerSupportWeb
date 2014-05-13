/**
 * 
 */
package com.hung.le.servlet;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author admin
 *
 */
public class LoginServlet extends HttpServlet{

	private static final Map<String, String> userDatabase = new Hashtable<>();
	
	static {
		
		userDatabase.put("hungle", "hungpass");
		userDatabase.put("lanle", "lanpass");
		userDatabase.put("chasele", "chasepass");
		userDatabase.put("audreyle", "audreypass");
		userDatabase.put("danhle", "danhpass");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		//when the logout is not null it means the user already logged out -> provide them the login page
		if(req.getParameter("logout") != null){
			session.invalidate(); // log user out
			resp.sendRedirect("login");
			return;
		}
		//when the username attribute is not null it means the user logged in -> allow them to view the ticket page
		else if(session.getAttribute("username") != null){
			resp.sendRedirect("tickets");
			return;
		}
		
		req.setAttribute("loginFailed", false); //user is not logged in
		req.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		//when the username attribute is not null, it means user logged in -> allow them to access ticket page
		if(req.getAttribute("username") != null){
			resp.sendRedirect("tickets");
			return;
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//if username and password are invalid, forward the login page to user
		if(username == null || password == null || 
				!LoginServlet.userDatabase.containsKey(username) || !password.equals(LoginServlet.userDatabase.get(username))){
			req.setAttribute("loginFailed", true);
			req.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(req, resp);
		}
		else{//after successfully login, set value for username attribute and allow them to access ticket page
			session.setAttribute("username", username);
			req.changeSessionId();	// new feature in servlet 3.1 from EE7 that protects against the session fixation attacks
			resp.sendRedirect("tickets");
		}
	}
	
	
}


