package org.thoth.jeesa.security.credential;

import javax.security.enterprise.credential.Credential;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class TestCredential implements Credential {
    protected String id;

    public TestCredential(String id) {
        this.id = id;
    }

    public String getCaller() {
        return this.id;
    }
}
