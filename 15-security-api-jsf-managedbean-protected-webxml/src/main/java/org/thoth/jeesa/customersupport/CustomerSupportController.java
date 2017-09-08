package org.thoth.jeesa.customersupport;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named(value = "customerSupportController")
@Stateless
public class CustomerSupportController {

    public CustomerSupportController() {
    }
    
    @RolesAllowed({"CustomerSupportRole"})
    public String getHelp() {
        return "Tweet @customersupport and have a nice day :)";
    }

}
