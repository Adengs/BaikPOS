package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTokenClient {
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("DATA")
    private DATATokenClient dataTokenClient;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public DATATokenClient getDataTokenClient() {
        return dataTokenClient;
    }

    public static class DATATokenClient{
        @Expose
        @SerializedName("token")
        private String token;


        public String getToken() {
            return token;
        }
    }
}
