package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetCustomer {


    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private List<GetCustomer.DATA> DATA;

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

    public List<GetCustomer.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<GetCustomer.DATA> DATA) {
        this.DATA = DATA;
    }

    public static class DATA implements Serializable {

        @SerializedName("cust_id")
        private int custId;
        @SerializedName("cust_merchant_id")
        private int custMerchantId;
        @SerializedName("cust_outlet_id")
        private int custOutletId;
        @SerializedName("cust_group_id")
        private int custGroupId;
        @SerializedName("cust_code")
        private String custCode;
        @SerializedName("cust_fullname")
        private String custFullname;
        @SerializedName("cust_gender")
        private String custGender;
        @SerializedName("cust_dob")
        private String custDob;
        @SerializedName("cust_email")
        private String custEmail;
        @SerializedName("cust_phone")
        private String custPhone;
        @SerializedName("cust_address")
        private String custAddress;
        @SerializedName("cust_city")
        private int custCity;
        @SerializedName("cust_total_point")
        private int custTotalPoint;
        @SerializedName("cust_info")
        private String custInfo;
        @SerializedName("cust_created_by")
        private int custCreatedBy;
        @SerializedName("cust_updated_by")
        private int custUpdatedBy;
        @SerializedName("cust_is_active")
        private int custIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

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

        public int getCustGroupId() {
            return custGroupId;
        }

        public void setCustGroupId(int custGroupId) {
            this.custGroupId = custGroupId;
        }

        public String getCustCode() {
            return custCode;
        }

        public void setCustCode(String custCode) {
            this.custCode = custCode;
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

        public String getCustEmail() {
            return custEmail;
        }

        public void setCustEmail(String custEmail) {
            this.custEmail = custEmail;
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

        public int getCustCity() {
            return custCity;
        }

        public void setCustCity(int custCity) {
            this.custCity = custCity;
        }

        public int getCustTotalPoint() {
            return custTotalPoint;
        }

        public void setCustTotalPoint(int custTotalPoint) {
            this.custTotalPoint = custTotalPoint;
        }

        public String getCustInfo() {
            return custInfo;
        }

        public void setCustInfo(String custInfo) {
            this.custInfo = custInfo;
        }

        public int getCustCreatedBy() {
            return custCreatedBy;
        }

        public void setCustCreatedBy(int custCreatedBy) {
            this.custCreatedBy = custCreatedBy;
        }

        public int getCustUpdatedBy() {
            return custUpdatedBy;
        }

        public void setCustUpdatedBy(int custUpdatedBy) {
            this.custUpdatedBy = custUpdatedBy;
        }

        public int getCustIsActive() {
            return custIsActive;
        }

        public void setCustIsActive(int custIsActive) {
            this.custIsActive = custIsActive;
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
    }
}
