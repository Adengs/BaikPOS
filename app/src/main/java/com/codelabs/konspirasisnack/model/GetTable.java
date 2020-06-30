package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTable {
    /**
     * DATA : [{"floor_id":5,"floor_name":"Lantai Utama","ot_name":"Dikopian Bandung","jumlah_meja":12,"meja":[{"table_id":18,"floor_id":5,"table_name":"Meja A","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":19,"floor_id":5,"table_name":"Meja B","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":20,"floor_id":5,"table_name":"Meja C","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":21,"floor_id":5,"table_name":"Meja D","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":22,"floor_id":5,"table_name":"Meja E","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":23,"floor_id":5,"table_name":"Meja AA","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":24,"floor_id":5,"table_name":"Meja AB","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":25,"floor_id":5,"table_name":"Meja AC","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":26,"floor_id":5,"table_name":"Meja AD","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":27,"floor_id":5,"table_name":"Meja VIP","capacity":1,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":28,"floor_id":5,"table_name":"Meja VIP Couple","capacity":2,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":29,"floor_id":5,"table_name":"Meja VIP Keluarga","capacity":8,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""}]}]
     * MESSAGE : SUCCESS
     * STATUS : 200
     */

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
         * floor_id : 5
         * floor_name : Lantai Utama
         * ot_name : Dikopian Bandung
         * jumlah_meja : 12
         * meja : [{"table_id":18,"floor_id":5,"table_name":"Meja A","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":19,"floor_id":5,"table_name":"Meja B","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":20,"floor_id":5,"table_name":"Meja C","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":21,"floor_id":5,"table_name":"Meja D","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":22,"floor_id":5,"table_name":"Meja E","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":23,"floor_id":5,"table_name":"Meja AA","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":24,"floor_id":5,"table_name":"Meja AB","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":25,"floor_id":5,"table_name":"Meja AC","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":26,"floor_id":5,"table_name":"Meja AD","capacity":4,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":27,"floor_id":5,"table_name":"Meja VIP","capacity":1,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":28,"floor_id":5,"table_name":"Meja VIP Couple","capacity":2,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""},{"table_id":29,"floor_id":5,"table_name":"Meja VIP Keluarga","capacity":8,"table_info":"","table_created_by":0,"table_updated_by":0,"table_status":1,"created_at":"","updated_at":""}]
         */

        @SerializedName("floor_id")
        private int floorId;
        @SerializedName("floor_name")
        private String floorName;
        @SerializedName("ot_name")
        private String otName;
        @SerializedName("jumlah_meja")
        private int jumlahMeja;
        @SerializedName("meja")
        private List<Meja> meja;

        public int getFloorId() {
            return floorId;
        }

        public void setFloorId(int floorId) {
            this.floorId = floorId;
        }

        public String getFloorName() {
            return floorName;
        }

        public void setFloorName(String floorName) {
            this.floorName = floorName;
        }

        public String getOtName() {
            return otName;
        }

        public void setOtName(String otName) {
            this.otName = otName;
        }

        public int getJumlahMeja() {
            return jumlahMeja;
        }

        public void setJumlahMeja(int jumlahMeja) {
            this.jumlahMeja = jumlahMeja;
        }

        public List<Meja> getMeja() {
            return meja;
        }

        public void setMeja(List<Meja> meja) {
            this.meja = meja;
        }

        public static class Meja {
            /**
             * table_id : 18
             * floor_id : 5
             * table_name : Meja A
             * capacity : 4
             * table_info :
             * table_created_by : 0
             * table_updated_by : 0
             * table_status : 1
             * created_at :
             * updated_at :
             */

            @SerializedName("reservation_detail")
            private ReservationDetail reservationDetail;
            @SerializedName("table_id")
            private int tableId;
            @SerializedName("floor_id")
            private int floorId;
            @SerializedName("table_name")
            private String tableName;
            @SerializedName("capacity")
            private int capacity;
            @SerializedName("table_info")
            private String tableInfo;
            @SerializedName("table_created_by")
            private int tableCreatedBy;
            @SerializedName("table_updated_by")
            private int tableUpdatedBy;
            @SerializedName("table_status")
            private int tableStatus;
            @SerializedName("is_reserved")
            private int is_reserved;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;
            private boolean isSelected = false;
            private boolean isPermSelected = false;


            public ReservationDetail getReservationDetail() {
                return reservationDetail;
            }

            public int getTableId() {
                return tableId;
            }

            public void setTableId(int tableId) {
                this.tableId = tableId;
            }

            public int getFloorId() {
                return floorId;
            }

            public void setFloorId(int floorId) {
                this.floorId = floorId;
            }

            public String getTableName() {
                return tableName;
            }

            public void setTableName(String tableName) {
                this.tableName = tableName;
            }

            public int getCapacity() {
                return capacity;
            }

            public void setCapacity(int capacity) {
                this.capacity = capacity;
            }

            public String getTableInfo() {
                return tableInfo;
            }

            public void setTableInfo(String tableInfo) {
                this.tableInfo = tableInfo;
            }

            public int getTableCreatedBy() {
                return tableCreatedBy;
            }

            public void setTableCreatedBy(int tableCreatedBy) {
                this.tableCreatedBy = tableCreatedBy;
            }

            public int getTableUpdatedBy() {
                return tableUpdatedBy;
            }

            public void setTableUpdatedBy(int tableUpdatedBy) {
                this.tableUpdatedBy = tableUpdatedBy;
            }

            public int getTableStatus() {
                return tableStatus;
            }

            public void setTableStatus(int tableStatus) {
                this.tableStatus = tableStatus;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public boolean isSelected() {
                return isSelected;
            }

            public void setSelected(boolean selected) {
                isSelected = selected;
            }

            public boolean isPermSelected() {
                return isPermSelected;
            }

            public void setPermSelected(boolean permSelected) {
                isPermSelected = permSelected;
            }

            public int getIs_reserved() {
                return is_reserved;
            }

            public void setIs_reserved(int is_reserved) {
                this.is_reserved = is_reserved;
            }
        }

        public static class ReservationDetail {
            @SerializedName("res_id")
            private int res_id;
            @SerializedName("res_code")
            private String res_code;
            @SerializedName("res_merchant_id")
            private int res_merchant_id;
            @SerializedName("res_outlet_id")
            private int res_outlet_id;
            @SerializedName("res_customer_id")
            private int res_customer_id;
            @SerializedName("res_table_id")
            private int res_table_id;
            @SerializedName("res_table_merge")
            private int res_table_merge;
            @SerializedName("res_number_of_people")
            private int res_number_of_people;
            @SerializedName("res_date")
            private String res_date;
            @SerializedName("res_arrival_date")
            private String res_arrival_date;
            @SerializedName("res_arrival_time")
            private String res_arrival_time;
            @SerializedName("res_cashier_id")
            private int res_cashier_id;
            @SerializedName("res_created_by")
            private int res_created_by;
            @SerializedName("res_updated_by")
            private int res_updated_by;
            @SerializedName("res_status")
            private int res_status;
            @SerializedName("res_is_reservation")
            private int res_is_reservation;
            @SerializedName("res_note")
            private String res_note;
            @SerializedName("created_at")
            private String created_at;
            @SerializedName("updated_at")
            private String updated_at;


            public int getRes_id() {
                return res_id;
            }

            public void setRes_id(int res_id) {
                this.res_id = res_id;
            }

            public String getRes_code() {
                return res_code;
            }

            public void setRes_code(String res_code) {
                this.res_code = res_code;
            }

            public int getRes_merchant_id() {
                return res_merchant_id;
            }

            public void setRes_merchant_id(int res_merchant_id) {
                this.res_merchant_id = res_merchant_id;
            }

            public int getRes_outlet_id() {
                return res_outlet_id;
            }

            public void setRes_outlet_id(int res_outlet_id) {
                this.res_outlet_id = res_outlet_id;
            }

            public int getRes_customer_id() {
                return res_customer_id;
            }

            public void setRes_customer_id(int res_customer_id) {
                this.res_customer_id = res_customer_id;
            }

            public int getRes_table_id() {
                return res_table_id;
            }

            public void setRes_table_id(int res_table_id) {
                this.res_table_id = res_table_id;
            }

            public int getRes_table_merge() {
                return res_table_merge;
            }

            public void setRes_table_merge(int res_table_merge) {
                this.res_table_merge = res_table_merge;
            }

            public int getRes_number_of_people() {
                return res_number_of_people;
            }

            public void setRes_number_of_people(int res_number_of_people) {
                this.res_number_of_people = res_number_of_people;
            }

            public String getRes_date() {
                return res_date;
            }

            public void setRes_date(String res_date) {
                this.res_date = res_date;
            }

            public String getRes_arrival_date() {
                return res_arrival_date;
            }

            public void setRes_arrival_date(String res_arrival_date) {
                this.res_arrival_date = res_arrival_date;
            }

            public String getRes_arrival_time() {
                return res_arrival_time;
            }

            public void setRes_arrival_time(String res_arrival_time) {
                this.res_arrival_time = res_arrival_time;
            }

            public int getRes_cashier_id() {
                return res_cashier_id;
            }

            public void setRes_cashier_id(int res_cashier_id) {
                this.res_cashier_id = res_cashier_id;
            }

            public int getRes_created_by() {
                return res_created_by;
            }

            public void setRes_created_by(int res_created_by) {
                this.res_created_by = res_created_by;
            }

            public int getRes_updated_by() {
                return res_updated_by;
            }

            public void setRes_updated_by(int res_updated_by) {
                this.res_updated_by = res_updated_by;
            }

            public int getRes_status() {
                return res_status;
            }

            public void setRes_status(int res_status) {
                this.res_status = res_status;
            }

            public int getRes_is_reservation() {
                return res_is_reservation;
            }

            public void setRes_is_reservation(int res_is_reservation) {
                this.res_is_reservation = res_is_reservation;
            }

            public String getRes_note() {
                return res_note;
            }

            public void setRes_note(String res_note) {
                this.res_note = res_note;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }


        }
    }
}
