package org.thoth.jeesa.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "timestampController")
@ApplicationScoped
public class TimestampController {

    public TimestampController() {
    }
    
    public String getTimestamp() {
        return new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
    }

}
