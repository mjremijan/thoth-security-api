package org.thoth.jeesa.security.principal;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

public class TestPrincipal implements Principal {

    protected String name;
    protected Set<String> roles;

    public TestPrincipal(String name, Set<String> roles) {
        this.name = name;
        this.roles = Collections.unmodifiableSet(roles);
    }

    @Override
    public String getName() {
        return name;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    @Override
    public String toString() {
        StringBuilder sp = new StringBuilder();
        sp.append("{").append("\n");
        sp.append("   \"sub\" : \"").append(getName()).append("\"").append("\n");
        sp.append("  ,\"roles\" : ["+roles.stream().reduce((a,b) -> "\"" + a + "\",\"" + b + "\"").get()+"]").append("\n");
        sp.append("}").append("\n");
        return sp.toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
