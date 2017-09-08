package org.thoth.jeesa.executive;

public class ExecutiveContract {
    protected String name;
    protected double amount;

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public ExecutiveContract(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}
