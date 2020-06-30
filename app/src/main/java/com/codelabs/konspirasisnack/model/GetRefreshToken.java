package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRefreshToken {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAToken DATA;

    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAToken getDATA() {
        return DATA;
    }

    public static class DATAToken {
        @Expose
        @SerializedName("token")
        private String token;

        public String getToken() {
            return token;
        }
    }
}
