package org.thoth.soteria.session;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named(value = "sessionController")
@ApplicationScoped
public class SessionController {

    public SessionController() {
    }

    public String getId() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
    }

    public List<SessionAttribute> getAttributes() {
        List<SessionAttribute> attributes
            = new LinkedList<>();

        Optional<HttpSession> session
            = Optional.of(
                (HttpSession) FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getSession(true)
            );
        
        session.ifPresent(s -> {
            Enumeration names
                = s.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                String value = String.valueOf(s.getAttribute(name));
                attributes.add(new SessionAttribute(name, value));
            }
        });
        
       return attributes;
    }
}
