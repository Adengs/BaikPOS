package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReportKomisi {

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
        @SerializedName("tr_served_id")
        private int tr_served_id;
        @SerializedName("tr_served_trans_id")
        private int tr_served_trans_id;
        @SerializedName("tr_served_employee_id")
        private int tr_served_employee_id;
        @SerializedName("tr_served_total_comm")
        private String tr_served_total_comm;
        @SerializedName("tr_served_info")
        private String tr_served_info;
        @SerializedName("tr_served_is_comm")
        private int tr_served_is_comm;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("employee_name")
        private String employee_name;
        @SerializedName("total_commission")
        private String total_commission;
        @SerializedName("total_product")
        private String total_product;
        @SerializedName("outlet_name")
        private String outlet_name;
        @SerializedName("komisi_type")
        private String komisi_type;

        public int getTr_served_id() {
            return tr_served_id;
        }

        public void setTr_served_id(int tr_served_id) {
            this.tr_served_id = tr_served_id;
        }

        public int getTr_served_trans_id() {
            return tr_served_trans_id;
        }

        public void setTr_served_trans_id(int tr_served_trans_id) {
            this.tr_served_trans_id = tr_served_trans_id;
        }

        public int getTr_served_employee_id() {
            return tr_served_employee_id;
        }

        public void setTr_served_employee_id(int tr_served_employee_id) {
            this.tr_served_employee_id = tr_served_employee_id;
        }

        public String getTr_served_total_comm() {
            return tr_served_total_comm;
        }

        public void setTr_served_total_comm(String tr_served_total_comm) {
            this.tr_served_total_comm = tr_served_total_comm;
        }

        public String getTr_served_info() {
            return tr_served_info;
        }

        public void setTr_served_info(String tr_served_info) {
            this.tr_served_info = tr_served_info;
        }

        public int getTr_served_is_comm() {
            return tr_served_is_comm;
        }

        public void setTr_served_is_comm(int tr_served_is_comm) {
            this.tr_served_is_comm = tr_served_is_comm;
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

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public String getTotal_commission() {
            return total_commission;
        }

        public void setTotal_commission(String total_commission) {
            this.total_commission = total_commission;
        }


        public String getTotal_product() {
            return total_product;
        }

        public void setTotal_product(String total_product) {
            this.total_product = total_product;
        }

        public String getOutlet_name() {
            return outlet_name;
        }

        public void setOutlet_name(String outlet_name) {
            this.outlet_name = outlet_name;
        }

        public String getKomisi_type() {
            return komisi_type;
        }

        public void setKomisi_type(String komisi_type) {
            this.komisi_type = komisi_type;
        }
    }
}
