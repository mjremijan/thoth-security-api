package org.thoth.jeesa.security.role;

import java.util.Arrays;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "declareRolesController")
@ApplicationScoped
public class DeclareRolesController {

    public List<String> getAll() {
        DeclareRoles annoation
            = DeclareRolesServlet.class.getAnnotation(DeclareRoles.class);
        return Arrays.asList(annoation.value());
    }
}
