package org.thoth.jeesa.security.authentication.mechanism;

import java.util.HashSet;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.AutoApplySession;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

@ApplicationScoped
@Named(value = "testHttpAuthenticationMechanism")
@AutoApplySession
public class TestHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    private static final Logger log = Logger.getLogger(TestHttpAuthenticationMechanism.class);

    @PostConstruct
    public void postConstruct() {
        log.info(String.format("ENTER #postConstruct()"));
    }

    @Override
    public AuthenticationStatus validateRequest(
          HttpServletRequest request
        , HttpServletResponse response
        , HttpMessageContext httpMessageContext)
    throws AuthenticationException {
        log.info(String.format("ENTER #validateRequest()"));

        AuthenticationStatus status
            = AuthenticationStatus.SUCCESS;

        String name
            = "security-api-user";

        String identityManagementGroups
            = "GROUP_CUSTOMER_SUPPORTS,GROUP_SALARY_EMPLOYEES";

        if (name != null) {
            log.info(String.format("PARAMETER name = \"%s\"", name));
            log.info(String.format("PARAMETER identityManagementGroups = \"%s\"", identityManagementGroups));

            HashSet<String> set = null;
            if (identityManagementGroups != null) {
                set = new HashSet<>();
                for (String token : identityManagementGroups.split(",")) {
                    token = StringUtils.trimToNull(token);
                    if (token != null) {
                        set.add(token);
                    }
                }
            }

            status = httpMessageContext.notifyContainerAboutLogin(name, set);
        }

        return status;
    }

}
