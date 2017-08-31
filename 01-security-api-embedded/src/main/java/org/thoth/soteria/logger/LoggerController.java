package org.thoth.soteria.logger;

import java.io.File;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

@Named(value = "loggerController")
@ApplicationScoped
public class LoggerController {

    protected ServletContext servletContext;

    public LoggerController () {
        servletContext = (ServletContext) FacesContext
            .getCurrentInstance().getExternalContext().getContext();
    }
    
    public String getLogFilePath() {
        return 
            System.getProperty("com.sun.aas.instanceRoot") 
            + File.separator 
            + "logs" 
            + File.separator 
            + servletContext.getAttribute("maven.project.artifactId")  
            + ".log"
        ;
    }

}
