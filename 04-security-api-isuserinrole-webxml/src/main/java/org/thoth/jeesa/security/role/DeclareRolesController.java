package org.thoth.jeesa.security.role;

import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "declareRolesController")
@ApplicationScoped
public class DeclareRolesController {

    public List<String> getAll() {
        return Arrays.asList(new String[]{"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole", "NOT_IN_WEBXML_ROLE"});
    }
}
