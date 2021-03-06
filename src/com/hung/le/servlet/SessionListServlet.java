package com.hung.le.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hung.le.session.SessionRegistry;

public class SessionListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSession());
		req.setAttribute("sessionList", SessionRegistry.getAllSessions());
		req.setAttribute("timestamp", System.currentTimeMillis());
		req.getRequestDispatcher("/WEB-INF/jsp/view/sessions.jsp").forward(req, resp);
	}

	
}
