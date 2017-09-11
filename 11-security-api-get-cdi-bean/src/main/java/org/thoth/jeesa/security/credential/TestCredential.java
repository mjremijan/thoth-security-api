package org.thoth.jeesa.security.credential;

import java.util.StringJoiner;
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

    @Override
    public String toString() {
        StringJoiner joiner
            = new StringJoiner(",", "{", "}");
        joiner.add(String.format("\"caller\"=\"%s\"", getCaller()));
        return joiner.toString();
    }
}
