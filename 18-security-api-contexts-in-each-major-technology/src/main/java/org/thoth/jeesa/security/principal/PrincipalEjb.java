package org.thoth.jeesa.security.principal;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class PrincipalEjb {

    @Resource
    private SessionContext ctx;

    public String getCallerPrincipalName() {
        return ctx.getCallerPrincipal().getName();
    }
}
