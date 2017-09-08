/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.jeesa.security.principal;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author H1MJR01
 */
@Named(value = "principalEjbController")
@Dependent
public class PrincipalEjbController {

    @Inject
    protected PrincipalEjb ejb;
    
    public PrincipalEjbController() {
    }
    
    public String getPrinicpalName() {
        return ejb.getCallerPrincipalName();
    }
    
}
