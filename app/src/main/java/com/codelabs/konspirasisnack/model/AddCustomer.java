package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class AddCustomer {
    /**
     * DATA : {"cust_merchant_id":5,"cust_outlet_id":8,"cust_created_by":8,"cust_code":"EHR090320CMVZ4","cust_phone":"","cust_address":"Jl. Raya Solo Km. 23 Yogyakarta","cust_email":"customer1@mail.com","cust_city":0,"cust_fullname":"Test Customer","cust_gender":"male","cust_dob":"","cust_group_id":0,"cust_total_point":"0","updated_at":"2020-03-09 13:35:05","created_at":"2020-03-09 13:35:05","cust_id":11}
     * MESSAGE : SUCCESS
     * STATUS : 200
     */

    @SerializedName("DATA")
    private DATA DATA;
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;

    public DATA getDATA() {
        return DATA;
    }

    public void setDATA(DATA DATA) {
        this.DATA = DATA;
    }

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

    public static class DATA {
        /**
         * cust_merchant_id : 5
         * cust_outlet_id : 8
         * cust_created_by : 8
         * cust_code : EHR090320CMVZ4
         * cust_phone :
         * cust_address : Jl. Raya Solo Km. 23 Yogyakarta
         * cust_email : customer1@mail.com
         * cust_city : 0
         * cust_fullname : Test Customer
         * cust_gender : male
         * cust_dob :
         * cust_group_id : 0
         * cust_total_point : 0
         * updated_at : 2020-03-09 13:35:05
         * created_at : 2020-03-09 13:35:05
         * cust_id : 11
         */

        @SerializedName("cust_merchant_id")
        private int custMerchantId;
        @SerializedName("cust_outlet_id")
        private int custOutletId;
        @SerializedName("cust_created_by")
        private int custCreatedBy;
        @SerializedName("cust_code")
        private String custCode;
        @SerializedName("cust_phone")
        private String custPhone;
        @SerializedName("cust_address")
        private String custAddress;
        @SerializedName("cust_email")
        private String custEmail;
        @SerializedName("cust_city")
        private int custCity;
        @SerializedName("cust_fullname")
        private String custFullname;
        @SerializedName("cust_gender")
        private String custGender;
        @SerializedName("cust_dob")
        private String custDob;
        @SerializedName("cust_group_id")
        private int custGroupId;
        @SerializedName("cust_total_point")
        private String custTotalPoint;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("cust_id")
        private int custId;

        public int getCustMerchantId() {
            return custMerchantId;
        }

        public void setCustMerchantId(int custMerchantId) {
            this.custMerchantId = custMerchantId;
        }

        public int getCustOutletId() {
            return custOutletId;
        }

        public void setCustOutletId(int custOutletId) {
            this.custOutletId = custOutletId;
        }

        public int getCustCreatedBy() {
            return custCreatedBy;
        }

        public void setCustCreatedBy(int custCreatedBy) {
            this.custCreatedBy = custCreatedBy;
        }

        public String getCustCode() {
            return custCode;
        }

        public void setCustCode(String custCode) {
            this.custCode = custCode;
        }

        public String getCustPhone() {
            return custPhone;
        }

        public void setCustPhone(String custPhone) {
            this.custPhone = custPhone;
        }

        public String getCustAddress() {
            return custAddress;
        }

        public void setCustAddress(String custAddress) {
            this.custAddress = custAddress;
        }

        public String getCustEmail() {
            return custEmail;
        }

        public void setCustEmail(String custEmail) {
            this.custEmail = custEmail;
        }

        public int getCustCity() {
            return custCity;
        }

        public void setCustCity(int custCity) {
            this.custCity = custCity;
        }

        public String getCustFullname() {
            return custFullname;
        }

        public void setCustFullname(String custFullname) {
            this.custFullname = custFullname;
        }

        public String getCustGender() {
            return custGender;
        }

        public void setCustGender(String custGender) {
            this.custGender = custGender;
        }

        public String getCustDob() {
            return custDob;
        }

        public void setCustDob(String custDob) {
            this.custDob = custDob;
        }

        public int getCustGroupId() {
            return custGroupId;
        }

        public void setCustGroupId(int custGroupId) {
            this.custGroupId = custGroupId;
        }

        public String getCustTotalPoint() {
            return custTotalPoint;
        }

        public void setCustTotalPoint(String custTotalPoint) {
            this.custTotalPoint = custTotalPoint;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }
    }
}
