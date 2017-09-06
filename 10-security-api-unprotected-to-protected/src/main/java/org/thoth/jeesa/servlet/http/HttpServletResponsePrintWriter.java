package org.thoth.jeesa.servlet.http;

import java.io.PrintWriter;
import java.io.StringWriter;

public class HttpServletResponsePrintWriter extends PrintWriter {

    public HttpServletResponsePrintWriter() {
        super(new StringWriter(), true);
    }

    public StringWriter getStringWriter() {
        return (StringWriter)super.lock;
    }

    @Override
    public void close() {
        // do nothing.
    }
}
