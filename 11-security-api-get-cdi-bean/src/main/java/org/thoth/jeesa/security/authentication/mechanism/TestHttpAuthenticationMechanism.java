package org.thoth.jeesa.security.authentication.mechanism;

import java.io.StringWriter;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.thoth.jeesa.security.credential.TestCredential;

@ApplicationScoped
@Named(value = "testHttpAuthenticationMechanism")
//@AutoApplySession
public class TestHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    private static final Logger log = Logger.getLogger(TestHttpAuthenticationMechanism.class);

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    protected StringWriter writer;

    @PostConstruct
    public void postConstruct() {
        writer = new StringWriter();
        try {
            Logger log = Logger.getRootLogger();
            Enumeration enu = log.getAllAppenders();
            Object next = enu.nextElement();
            Appender a = (Appender)next;
            log.addAppender(new WriterAppender(a.getLayout(), writer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBuffer() {
        writer.flush();
        return writer.toString();
    }

    @Override
    public AuthenticationStatus validateRequest(
        HttpServletRequest request,
         HttpServletResponse response,
         HttpMessageContext httpMessageContext)
        throws AuthenticationException {
        writer.getBuffer().setLength(0);
        log.info(String.format("ENTER #validateRequest()"));


        try {
            log.info("Create new TestCredential for IdentityStoreHandler to validate");
            TestCredential testCredential
                = new TestCredential("security-api-user");
            log.info(String.format("testCredential = %s", testCredential));

            log.info("Pass TestCredenttial to IdentityStoreHandler");
            log.info(String.format("IdentityStoreHandler = %s", identityStoreHandler));
            CredentialValidationResult result = identityStoreHandler.validate(
                new TestCredential("security-api-user"));

            log.info(String.format("Got CredentialValidationResult = %s", result));
            if (result.getStatus() == VALID) {
                // Communicate the details of the authenticated user to the
                // container. In many cases the underlying handler will just store the details
                // and the container will actually handle the login after we return from
                // this method.
                log.info(String.format("Notify container about login"));
                return httpMessageContext.notifyContainerAboutLogin(
                    result.getCallerPrincipal(), result.getCallerGroups());
            } else {
                return httpMessageContext.responseUnauthorized();
            }
        } catch (Exception e) {
            log.info("yikes!", e);
            throw new RuntimeException(e);
        }
    }
}
