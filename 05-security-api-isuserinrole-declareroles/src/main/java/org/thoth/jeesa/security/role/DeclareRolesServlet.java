package org.thoth.jeesa.security.role;

import javax.annotation.security.DeclareRoles;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@DeclareRoles({"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"})
public class DeclareRolesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

}
