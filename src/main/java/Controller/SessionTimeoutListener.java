package Controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionTimeoutListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(60); // Set session timeout to 1 minute
    }

    public void sessionDestroyed(HttpSessionEvent event) {} // Removed the extra space character
}
