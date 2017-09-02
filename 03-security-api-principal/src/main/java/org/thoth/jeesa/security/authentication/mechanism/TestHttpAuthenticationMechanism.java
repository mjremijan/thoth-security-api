package org.thoth.jeesa.security.authentication.mechanism;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@ApplicationScoped
@Named(value = "testHttpAuthenticationMechanism")
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

        String name =
            request.getParameter("name");

        if (name != null) {
            log.info(String.format("PARAMETER name = \"%s\"", name));
            status = httpMessageContext.notifyContainerAboutLogin(name, null);
        }

        return status;
    }

}
