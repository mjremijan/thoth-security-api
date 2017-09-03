package org.thoth.jeesa.session;

public class SessionAttribute {
    String name, value;

    public SessionAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
