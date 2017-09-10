package org.thoth.jeesa.security.role;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "declareRolesController")
@ApplicationScoped
public class DeclareRolesController {

    protected List<DeclareRolesMapping> roleMappings;

    @PostConstruct
    protected void postConstruct() {
        roleMappings
            = new LinkedList<>();
        roleMappings.add(new DeclareRolesMapping("ExecutiveRole", "GROUP_EXECUTIVES"));
        roleMappings.add(new DeclareRolesMapping("CustomerSupportRole", "GROUP_CUSTOMER_SUPPORTS"));
        roleMappings.add(new DeclareRolesMapping("SalaryEmployeeRole", "GROUP_SALARY_EMPLOYEES"));
    }

    public List<DeclareRolesMapping> getRoleMappings() {
        return roleMappings;
    }
}