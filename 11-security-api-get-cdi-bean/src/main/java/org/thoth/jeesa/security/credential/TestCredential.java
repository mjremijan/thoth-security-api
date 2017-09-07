package org.thoth.jeesa.security.credential;

import javax.security.enterprise.credential.Credential;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestCredential implements Credential {

    protected String caller;

    public TestCredential(String caller) {
        this.caller = caller;
    }

    public String getCaller() {
        return caller;
    }

    public boolean compareTo(String caller) {
        return this.caller.equals(caller);
    }
}
