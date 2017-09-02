package org.thoth.jeesa.security.principal;

import java.security.Principal;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;

@Named("principalController")
@ApplicationScoped
public class PrincipalController {

    private static final Logger log = Logger.getLogger(PrincipalController.class);

    @Inject
    protected PrincipalInput input;

    public PrincipalController() {
    }

    public String getName() {
        Principal principal
            = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        String name =
            (principal == null) ? "UNKNOWN" : principal.getName();
        return name;
    }

    public boolean isUserInRole(String role) {
        return
            FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .isUserInRole(role)
        ;
    }

    public void setName() {
        log.info("ENTER #setName()");
        log.info(String.format("PrincipalInput = %s", input));
    }
}
