package org.thoth.jeesa.executive;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
public class ExecutiveContract {

    @RolesAllowed({"ExecutiveRole"})
    public String getContractDetails() {
        return "Contract_Details";
    }
}
