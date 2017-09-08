package org.thoth.jeesa.customersupport;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.thoth.jeesa.executive.ExecutiveContract;

@Named(value = "customerSupportController")
@ApplicationScoped
public class CustomerSupportController {

    @Inject
    protected ExecutiveContract executiveContract;

    @Inject
    protected ContractDetails details;

    public CustomerSupportController() {
    }

    public void findContractDetails() {
        details.setText(
            executiveContract.getContractDetails()
        );
    }
}
