package org.thoth.soteria.security.role;

import java.util.Arrays;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@DeclareRoles({"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"})
@Named(value = "declareRolesController")
@ApplicationScoped
public class DeclareRolesController {

    public List<String> getAll() {
        DeclareRoles annoation
            = DeclareRolesController.class.getAnnotation(DeclareRoles.class);
        return Arrays.asList(annoation.value());
    }
}
