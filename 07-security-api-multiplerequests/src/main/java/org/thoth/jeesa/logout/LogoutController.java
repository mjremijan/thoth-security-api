package org.thoth.jeesa.logout;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.log4j.Logger;

@Named(value = "logoutController")
@ApplicationScoped
public class LogoutController {

    private static final Logger log = Logger.getLogger(LogoutController.class);

    public LogoutController() {
    }


    public void logout() throws IOException {
        log.info("ENTER #logout()");
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("index.xhtml");
    }
}
