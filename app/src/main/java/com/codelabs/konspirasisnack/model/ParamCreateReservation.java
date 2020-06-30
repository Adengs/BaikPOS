package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParamCreateReservation {
    /**
     * customer_id : 1
     * arrival_date :
     * arrival_time :
     * tables : [{"id":1}]
     * merge_tables : 1
     * number_of_people : 3
     * note :
     * status : 1
     * is_reservation : 1
     */

    @SerializedName("customer_id")
    private int customerId = 0;
    @SerializedName("arrival_date")
    private String arrivalDate;
    @SerializedName("arrival_time")
    private String arrivalTime;
    @SerializedName("merge_tables")
    private int mergeTables;
    @SerializedName("number_of_people")
    private int numberOfPeople;
    @SerializedName("note")
    private String note;
    @SerializedName("status")
    private int status;
    @SerializedName("is_reservation")
    private int isReservation;
    @SerializedName("tables")
    private List<Table> tables;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getMergeTables() {
        return mergeTables;
    }

    public void setMergeTables(int mergeTables) {
        this.mergeTables = mergeTables;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsReservation() {
        return isReservation;
    }

    public void setIsReservation(int isReservation) {
        this.isReservation = isReservation;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public static class Table {
        /**
         * id : 1
         */

        @SerializedName("id")
        private int id;

        public Table (int id){
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
