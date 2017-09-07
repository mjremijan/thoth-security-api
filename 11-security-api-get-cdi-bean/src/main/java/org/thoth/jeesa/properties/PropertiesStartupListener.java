package org.thoth.jeesa.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;

@WebListener
public class PropertiesStartupListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(PropertiesStartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info(String.format("ENTER contextInitialized()"));

        Properties props
            = new Properties();

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("some.properties");
        ) {
            log.info(String.format("Loading properties from 'some.properties'"));
            props.load(is);
        } catch (IOException e) {
            log.fatal("oops", e);
            throw new RuntimeException(e);
        }

        props.keySet().stream().map(k -> String.valueOf(k)).forEach(k -> {
            sce.getServletContext().setAttribute(k, props.getProperty(k));
            log.info(String.format("PROPERTY name=\"%s\" value=\"%s\"", k, sce.getServletContext().getAttribute(k)));
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
