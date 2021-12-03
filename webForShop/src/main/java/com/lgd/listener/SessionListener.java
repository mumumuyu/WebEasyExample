package com.lgd.listener;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		HashMap books = new HashMap();
		session.setAttribute("books",books);
		session.setAttribute("money",0F);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {}
}
