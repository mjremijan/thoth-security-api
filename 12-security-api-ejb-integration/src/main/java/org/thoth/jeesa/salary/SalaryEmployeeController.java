package org.thoth.jeesa.salary;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;

@Named(value = "salaryEmployeeController")
@ApplicationScoped
public class SalaryEmployeeController {

    private static final Logger log = Logger.getLogger(SalaryEmployeeController.class);

    @Inject
    protected SalaryEmployeeEjb salaryEmployeeEjb;

    @Inject
    protected SalaryEmployeeInformation salaryEmployeeInformation;

    public void getNumberOfVacationDays() throws IOException {
        log.info("ENTER #getNumberOfVacationDays()");

        log.info("Attempt to call method on SalaryEmployeeEjb");
        salaryEmployeeInformation.setNumberOfVacationDays(salaryEmployeeEjb.getNumberOfVacationDays());
        log.info(String.format("numberOfVacationDays=\"%d\"", salaryEmployeeInformation.getNumberOfVacationDays()));

        log.info("Go back to index page");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("index.xhtml");
    }
}
