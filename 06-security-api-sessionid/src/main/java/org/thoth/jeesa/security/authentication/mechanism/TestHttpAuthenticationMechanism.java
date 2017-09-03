package org.thoth.jeesa.security.authentication.mechanism;

import java.io.StringWriter;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

@ApplicationScoped
@Named(value = "testHttpAuthenticationMechanism")
public class TestHttpAuthenticationMechanism implements HttpAuthenticationMechanism {

    private static final Logger log = Logger.getLogger(TestHttpAuthenticationMechanism.class);

    protected StringWriter writer = new StringWriter();

    @PostConstruct
    public void postConstruct() {
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
          HttpServletRequest request
        , HttpServletResponse response
        , HttpMessageContext hmc)
    throws AuthenticationException {
        writer.getBuffer().setLength(0);
        log.info(String.format("ENTER #validateRequest()"));

        {
            StringBuilder sp = new StringBuilder("::HEADERS::\n");
            Enumeration<String> names
                = request.getHeaderNames();

            while (names.hasMoreElements()) {
                String name = names.nextElement();
                String valu = request.getHeader(name);
                sp.append(String.format("  NAME=\"%s\", VALUE=\"%s\"\n", name, valu));
            }
            log.info(String.format("%n%s", sp.toString()));
        }

        {
            StringBuilder sp = new StringBuilder("::PARAMETERS::\n");
            Enumeration<String> names
                = request.getParameterNames();

            while (names.hasMoreElements()) {
                String name = names.nextElement();
                String valu = request.getParameter(name);
                sp.append(String.format("  NAME=\"%s\", VALUE=\"%s\"\n", name, valu));
            }
            log.info(String.format("%n%s", sp.toString()));
        }

        {
            StringBuilder sp = new StringBuilder("::SESSION::\n");
            sp.append(String.format("  JSESSIONID=\"%s\"%n", request.getSession().getId()));
            log.info(String.format("%n%s", sp.toString()));
        }

        return AuthenticationStatus.SUCCESS;
    }

}
