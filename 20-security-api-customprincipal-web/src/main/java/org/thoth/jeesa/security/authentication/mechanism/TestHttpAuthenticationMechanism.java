package org.thoth.jeesa.security.authentication.mechanism;

import java.util.Arrays;
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
import org.apache.log4j.Logger;
import org.thoth.jeesa.security.principal.MyPrincipal;

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

        // Principal name
        String name = "security-api-user";
        log.info(String.format("PRINCIPAL name = \"%s\"", name));

        // Principal Identity Management Groups
        HashSet<String> set = new HashSet<>(
            Arrays.asList("GROUP_CUSTOMER_SUPPORTS,GROUP_SALARY_EMPLOYEES".split(","))
        );
        log.info(String.format("PRINCIPAL identityManagementGroups = \"%s\"", set));

        // MyPrincipal
        MyPrincipal myPrincipal
            = new MyPrincipal(name, set);
        log.info(String.format("PRINCIPAL myPrincipal = \"%s\"", myPrincipal));

        // Authentication status
        AuthenticationStatus status
            = httpMessageContext.notifyContainerAboutLogin(myPrincipal, set);

        return status;
    }

}
