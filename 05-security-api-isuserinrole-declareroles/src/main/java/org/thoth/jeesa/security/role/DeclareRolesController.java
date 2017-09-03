package org.thoth.jeesa.security.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "declareRolesController")
@DeclareRoles(value = {"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"})
public class DeclareRolesController {

    protected List<String> all;

    @PostConstruct
    protected void postConstruct() {
        all = new ArrayList<>();
        all.addAll(Arrays.asList(
            DeclareRolesController.class.getAnnotation(DeclareRoles.class).value())
        );
        all.add("NOT_IN_DECLAREROLES_ROLE");

    }

    public List<String> getAll() {
        return all;
    }
}
