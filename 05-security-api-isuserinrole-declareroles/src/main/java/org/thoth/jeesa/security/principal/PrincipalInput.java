package org.thoth.jeesa.security.principal;

import java.util.StringJoiner;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("principalInput")
@RequestScoped
public class PrincipalInput {
    protected String name;
    protected String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "{", "}");
        sj.add(String.format("\"name\":\"%s\"", getName()));
        sj.add(String.format("\"roles\":\"%s\"", getRoles()));
        return sj.toString();
    }

}
