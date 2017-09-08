package org.thoth.jeesa.customersupport;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "contractDetails")
@SessionScoped
public class ContractDetails implements Serializable {

    private static final long serialVersionUID = 198709709709870987L;


    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
