package org.thoth.jeesa.executive;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "executiveController")
@ApplicationScoped
public class ExecutiveController {

    @Inject
    protected ExecutiveContract contract;
    
    public ExecutiveController() {
    }
    
    public String getContractDetails() {
        return contract.getContractDetails();
    }

}
