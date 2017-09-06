package org.thoth.jeesa.servlet.http;

import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class HttpServletResponseProxy implements InvocationHandler {

    private static final Logger log = Logger.getLogger(HttpServletResponseProxy.class);

    protected HttpServletResponse response;
    protected HttpServletResponsePrintWriter writer;

    public HttpServletResponseProxy(HttpServletResponse response) {
        this.response = response;
        writer = new HttpServletResponsePrintWriter();
        log.info(String.format("My PrintWriter is %s%n", writer));
    }

    public StringWriter getStringWriter() {
        return writer.getStringWriter();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (method.getName().equals("getWriter")) {
            log.info("#getWriter() called, return my writer");
            result = writer;
        }
        else
        if (method.getName().equals("flushBuffer")) {
            log.info("#flushBuffer() called, do nothing");
        }
        else {
            result = method.invoke(response, args);
        }
        return result;
    }
}
