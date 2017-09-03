package org.thoth.jeesa.security.role;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "declareRolesController")
@ApplicationScoped
@DeclareRoles({"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"})
public class DeclareRolesController {

    protected List<RoleMapping> roleMappings;

    @PostConstruct
    protected void postConstruct() {
        roleMappings
            = new LinkedList<>();
        roleMappings.add(new RoleMapping("ExecutiveRole", "GROUP_EXECUTIVES"));
        roleMappings.add(new RoleMapping("CustomerSupportRole", "GROUP_CUSTOMER_SUPPORTS"));
        roleMappings.add(new RoleMapping("SalaryEmployeeRole", "GROUP_SALARY_EMPLOYEES"));
    }

    public List<RoleMapping> getRoleMappings() {
        return roleMappings;
    }
}