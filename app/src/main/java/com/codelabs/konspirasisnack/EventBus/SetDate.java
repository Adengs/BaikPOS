package com.codelabs.konspirasisnack.EventBus;

public class SetDate {

    private String date;
    private int outlet;

    public SetDate(String date,int outlet) {
        this.date = date;
        this.outlet = outlet;
    }

    public String getDate() {
        return date;
    }

    public int getOutlet() {
        return outlet;
    }

    public void setOutlet(int outlet) {
        this.outlet = outlet;
    }
}
