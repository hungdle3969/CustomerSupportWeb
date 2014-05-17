package com.hung.le.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import com.hung.le.session.SessionRegistry;

public class SessionListener implements HttpSessionListener, HttpSessionIdListener{

	private SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyy HH:mm:ss");
	@Override
	public void sessionIdChanged(HttpSessionEvent e, String oldSessionId) {

		System.out.println(this.date() + ": Session ID" + oldSessionId + " changed to " + e.getSession().getId());
		
		SessionRegistry.udpateSessionId(e.getSession(), oldSessionId);
	}

	@Override
	public void sessionCreated(HttpSessionEvent e) {

		System.out.println(this.date() + ": Session " + e.getSession().getId() + " created.");
		
		SessionRegistry.addSession(e.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {

		System.out.println(this.date() + ": Session " + e.getSession().getId() + " destroyed.");
		
		SessionRegistry.removeSession(e.getSession());
		
	}
	
	private String date(){
		return this.formatter.format(new Date());
	}
	
	

}
