package org.thoth.jeesa.salary;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Stateless
public class SalaryEmployeeEjb {

    @RolesAllowed({"SalaryEmployeeRole"})
    public int getNumberOfVacationDays() {
        return 20;
    }
}
