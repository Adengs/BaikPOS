package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class CheckVoucher {
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private GetVoucher.DATA DATA;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public GetVoucher.DATA getDATA() {
        return DATA;
    }

    public void setDATA(GetVoucher.DATA DATA) {
        this.DATA = DATA;
    }
}
