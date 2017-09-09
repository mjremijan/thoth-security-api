package org.thoth.jeesa.security.credential;

import javax.security.enterprise.credential.Credential;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestCredential implements Credential {
    protected String id;
    protected String caller;

    public TestCredential(String id) {
        this.id = id;
        this.caller = this.id+"/TestCredential";
    }

    public String getCaller() {
        return caller;
    }
}
