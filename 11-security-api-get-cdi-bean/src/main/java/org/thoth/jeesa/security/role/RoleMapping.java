package org.thoth.jeesa.security.role;

import java.util.StringJoiner;

public class RoleMapping {
    protected String applicationSpecificRole;
    protected String identityManagementGroup;

    public RoleMapping(String applicationSpecificRole, String identityManagementGroup) {
        this.applicationSpecificRole = applicationSpecificRole;
        this.identityManagementGroup = identityManagementGroup;
    }

    public String getApplicationSpecificRole() {
        return applicationSpecificRole;
    }

    public String getIdentityManagementGroup() {
        return identityManagementGroup;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "{", "}");
        sj.add(String.format("\"applicationSpecificRole\":\"%s\"", getApplicationSpecificRole()));
        sj.add(String.format("\"identityManagementGroup\":\"%s\"", getIdentityManagementGroup()));
        return sj.toString();
    }
}
