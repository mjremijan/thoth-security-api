package org.thoth.jeesa.guest;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;
import org.thoth.jeesa.executive.ExecutiveEjb;

@Named(value = "guestController")
@ApplicationScoped
public class GuestController {

    private static final Logger log = Logger.getLogger(GuestController.class);

    @Inject
    protected ExecutiveEjb executiveEjb;

    public void someAction() throws IOException {
        log.info("ENTER #someAction()");

        log.info("Attempt to call method on ExecutiveEjb");
        String contractName
            = executiveEjb.getContractName();
        log.info(String.format("contractName=\"%s\"", contractName));

        log.info("Go back to index page");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("index.xhtml");
    }
}
