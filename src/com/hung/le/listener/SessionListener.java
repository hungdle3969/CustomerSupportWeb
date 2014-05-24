package com.hung.le.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hung.le.session.SessionRegistry;

public class SessionListener implements HttpSessionListener, HttpSessionIdListener{

	private static final Logger log = LogManager.getLogger();
	
	@Override
	public void sessionIdChanged(HttpSessionEvent e, String oldSessionId) {

		log.debug("Session ID" + oldSessionId + " changed to " + e.getSession().getId());
		SessionRegistry.udpateSessionId(e.getSession(), oldSessionId);
	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {

		log.debug("Session " + e.getSession().getId() + " created.");
		SessionRegistry.addSession(e.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {

		log.debug("Session " + e.getSession().getId() + " destroyed.");
		SessionRegistry.removeSession(e.getSession());
		
	}
	
	

}
