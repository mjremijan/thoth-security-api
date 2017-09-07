package org.thoth.jeesa.salary;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@SessionScoped
@Named(value = "salaryEmployeeInformation")
public class SalaryEmployeeInformation implements Serializable {

    private static final long serialVersionUID = 16164651984654L;

    protected Integer numberOfVacationDays;

    public Integer getNumberOfVacationDays() {
        return numberOfVacationDays;
    }

    public void setNumberOfVacationDays(Integer numberOfVacationDays) {
        this.numberOfVacationDays = numberOfVacationDays;
    }
}
