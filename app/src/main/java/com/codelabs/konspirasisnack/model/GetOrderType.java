package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderType {
    /**
     * DATA : [{"type_id":1,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Meja","type_description":"Order Type Meja","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"},{"type_id":2,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Bungkus","type_description":"Order Type Bungkus","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"},{"type_id":3,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Delivery","type_description":"Order Type Delivery","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"},{"type_id":4,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Ojek Online","type_description":"Order Type Ojek Online","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"},{"type_id":5,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Reservasi","type_description":"Order Type Reservasi","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"},{"type_id":6,"type_merchant_id":0,"type_outlet_id":0,"type_name":"Dilayani Oleh","type_description":"Order Type Dilayani Oleh","type_setting":"","type_created_by":0,"type_updated_by":0,"type_is_active":1,"created_at":"2019-05-31 02:14:00","updated_at":"2019-06-13 08:29:25"}]
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
         * type_id : 1
         * type_merchant_id : 0
         * type_outlet_id : 0
         * type_name : Meja
         * type_description : Order Type Meja
         * type_setting :
         * type_created_by : 0
         * type_updated_by : 0
         * type_is_active : 1
         * created_at : 2019-05-31 02:14:00
         * updated_at : 2019-06-13 08:29:25
         */

        @SerializedName("type_id")
        private int typeId;
        @SerializedName("type_merchant_id")
        private int typeMerchantId;
        @SerializedName("type_outlet_id")
        private int typeOutletId;
        @SerializedName("type_name")
        private String typeName;
        @SerializedName("type_description")
        private String typeDescription;
        @SerializedName("type_setting")
        private String typeSetting;
        @SerializedName("type_created_by")
        private int typeCreatedBy;
        @SerializedName("type_updated_by")
        private int typeUpdatedBy;
        @SerializedName("type_is_active")
        private int typeIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public int getTypeMerchantId() {
            return typeMerchantId;
        }

        public void setTypeMerchantId(int typeMerchantId) {
            this.typeMerchantId = typeMerchantId;
        }

        public int getTypeOutletId() {
            return typeOutletId;
        }

        public void setTypeOutletId(int typeOutletId) {
            this.typeOutletId = typeOutletId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeDescription() {
            return typeDescription;
        }

        public void setTypeDescription(String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public String getTypeSetting() {
            return typeSetting;
        }

        public void setTypeSetting(String typeSetting) {
            this.typeSetting = typeSetting;
        }

        public int getTypeCreatedBy() {
            return typeCreatedBy;
        }

        public void setTypeCreatedBy(int typeCreatedBy) {
            this.typeCreatedBy = typeCreatedBy;
        }

        public int getTypeUpdatedBy() {
            return typeUpdatedBy;
        }

        public void setTypeUpdatedBy(int typeUpdatedBy) {
            this.typeUpdatedBy = typeUpdatedBy;
        }

        public int getTypeIsActive() {
            return typeIsActive;
        }

        public void setTypeIsActive(int typeIsActive) {
            this.typeIsActive = typeIsActive;
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
