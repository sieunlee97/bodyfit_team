package com.bodyfit.bodyfit.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
    public void sessionCreated(HttpSessionEvent se) {

        se.getSession().setMaxInactiveInterval(60*120); //세션만료120분

    }

 

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

}
