package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProductCategory {
    /**
     * DATA : [{"item_cat_id":6,"item_cat_merchant_id":5,"item_cat_outlet_id":0,"item_cat_name":"Es Kopi","item_cat_description":"","item_cat_sort":1,"item_cat_is_active":1,"created_at":"2020-02-07 10:56:23","updated_at":"2020-02-07 10:56:23"},{"item_cat_id":7,"item_cat_merchant_id":5,"item_cat_outlet_id":0,"item_cat_name":"Snacks","item_cat_description":"","item_cat_sort":1,"item_cat_is_active":1,"created_at":"2020-02-07 13:37:19","updated_at":"2020-02-07 13:37:25"},{"item_cat_id":8,"item_cat_merchant_id":5,"item_cat_outlet_id":0,"item_cat_name":"Indonesian Food","item_cat_description":"","item_cat_sort":1,"item_cat_is_active":1,"created_at":"2020-02-07 13:40:35","updated_at":"2020-02-07 13:40:35"}]
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

        @SerializedName("item_cat_id")
        private int itemCatId;
        @SerializedName("item_cat_merchant_id")
        private int itemCatMerchantId;
        @SerializedName("item_cat_outlet_id")
        private int itemCatOutletId;
        @SerializedName("item_cat_name")
        private String itemCatName;
        @SerializedName("item_cat_description")
        private String itemCatDescription;
        @SerializedName("item_cat_sort")
        private int itemCatSort;
        @SerializedName("item_cat_is_active")
        private int itemCatIsActive;
        @SerializedName("total_item_registered")
        private int totalItemRegistered;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getItemCatId() {
            return itemCatId;
        }

        public void setItemCatId(int itemCatId) {
            this.itemCatId = itemCatId;
        }

        public int getItemCatMerchantId() {
            return itemCatMerchantId;
        }

        public void setItemCatMerchantId(int itemCatMerchantId) {
            this.itemCatMerchantId = itemCatMerchantId;
        }

        public int getItemCatOutletId() {
            return itemCatOutletId;
        }

        public void setItemCatOutletId(int itemCatOutletId) {
            this.itemCatOutletId = itemCatOutletId;
        }

        public String getItemCatName() {
            return itemCatName;
        }

        public void setItemCatName(String itemCatName) {
            this.itemCatName = itemCatName;
        }

        public String getItemCatDescription() {
            return itemCatDescription;
        }

        public void setItemCatDescription(String itemCatDescription) {
            this.itemCatDescription = itemCatDescription;
        }

        public int getItemCatSort() {
            return itemCatSort;
        }

        public void setItemCatSort(int itemCatSort) {
            this.itemCatSort = itemCatSort;
        }

        public int getItemCatIsActive() {
            return itemCatIsActive;
        }

        public void setItemCatIsActive(int itemCatIsActive) {
            this.itemCatIsActive = itemCatIsActive;
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

        public int getTotalItemRegistered() {
            return totalItemRegistered;
        }

        public void setTotalItemRegistered(int totalItemRegistered) {
            this.totalItemRegistered = totalItemRegistered;
        }
    }
}
