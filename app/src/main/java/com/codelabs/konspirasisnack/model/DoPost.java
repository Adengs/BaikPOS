package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoPost {
    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
