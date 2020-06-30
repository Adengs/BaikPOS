package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetEmployeePosition {


    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private List<DATA> DATA;

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

    public List<DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATA> DATA) {
        this.DATA = DATA;
    }

    public static class DATA {
        /**
         * id : 1
         * position : Owner
         */

        @SerializedName("id")
        private String id;
        @SerializedName("position")
        private String position;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
