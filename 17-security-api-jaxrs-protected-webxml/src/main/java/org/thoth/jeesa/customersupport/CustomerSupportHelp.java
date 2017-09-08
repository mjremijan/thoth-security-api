package org.thoth.jeesa.customersupport;

public class CustomerSupportHelp {
    protected String phone, email;

    public CustomerSupportHelp(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
}
