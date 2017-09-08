package org.thoth.jeesa.security.principal;

import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestCallerPrincipal extends CallerPrincipal
{
    public TestCallerPrincipal(String name) {
        super(name + "/TestPrincipal");
    }
}
