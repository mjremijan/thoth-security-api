package org.thoth.jeesa.executive;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Stateless
public class ExecutiveEjb {

    @RolesAllowed({"ExecutiveRole"})
    public String getContractName() {
        return "super-secret-contract-name";
    }
}
