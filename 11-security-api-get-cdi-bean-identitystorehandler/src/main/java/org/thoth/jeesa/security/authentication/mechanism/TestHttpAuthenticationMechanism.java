package org.thoth.jeesa.security.authentication.mechanism;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.AutoApplySession;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.thoth.jeesa.security.credential.TestCredential;

@ApplicationScoped
@Named(value = "testHttpAuthenticationMechanism")
@AutoApplySession
public class TestHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    private static final Logger log = Logger.getLogger(TestHttpAuthenticationMechanism.class);

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @PostConstruct
    public void postConstruct() {
        log.info(String.format("ENTER #postConstruct()"));
    }

    @Override
    public AuthenticationStatus validateRequest(
        HttpServletRequest request,
         HttpServletResponse response,
         HttpMessageContext httpMessageContext)
        throws AuthenticationException {
        log.info(String.format("ENTER #validateRequest()"));

        AuthenticationStatus status
            = AuthenticationStatus.SUCCESS;

        // Delegate the {credentials in -> identity data out} function to
        // the Identity Store
        CredentialValidationResult result = identityStoreHandler.validate(
            new TestCredential("security-api-user"));

        if (result.getStatus() == VALID) {
            // Communicate the details of the authenticated user to the
            // container. In many cases the underlying handler will just store the details
            // and the container will actually handle the login after we return from
            // this method.
            return httpMessageContext.notifyContainerAboutLogin(
                result.getCallerPrincipal(), result.getCallerGroups());
        } else {
            return httpMessageContext.responseUnauthorized();
        }
    }
}
