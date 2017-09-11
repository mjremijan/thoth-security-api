package org.thoth.jeesa.welcome;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;

@Named(value = "welcomeMessage")
@SessionScoped
public class WelcomeMessage implements Serializable {

    private static final long serialVersionUID = 11480978236074509L;
    private String text;

    public WelcomeMessage() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = StringUtils.trimToNull(text);
    }

    public String getMessage() {
        return "Welcome " + this.text;
    }
}
