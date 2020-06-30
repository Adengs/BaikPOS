package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class AddCategory {


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
         * item_cat_merchant_id : 5
         * item_cat_outlet_id : 8
         * item_cat_name : Testing
         * item_cat_sort : 3
         * item_cat_is_active : 1
         * updated_at : 2020-03-10 12:55:25
         * created_at : 2020-03-10 12:55:25
         * item_cat_id : 32
         * total_item_registered : 0
         */

        @SerializedName("item_cat_merchant_id")
        private int itemCatMerchantId;
        @SerializedName("item_cat_outlet_id")
        private int itemCatOutletId;
        @SerializedName("item_cat_name")
        private String itemCatName;
        @SerializedName("item_cat_sort")
        private String itemCatSort;
        @SerializedName("item_cat_is_active")
        private int itemCatIsActive;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("item_cat_id")
        private int itemCatId;
        @SerializedName("total_item_registered")
        private int totalItemRegistered;

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

        public String getItemCatSort() {
            return itemCatSort;
        }

        public void setItemCatSort(String itemCatSort) {
            this.itemCatSort = itemCatSort;
        }

        public int getItemCatIsActive() {
            return itemCatIsActive;
        }

        public void setItemCatIsActive(int itemCatIsActive) {
            this.itemCatIsActive = itemCatIsActive;
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

        public int getItemCatId() {
            return itemCatId;
        }

        public void setItemCatId(int itemCatId) {
            this.itemCatId = itemCatId;
        }

        public int getTotalItemRegistered() {
            return totalItemRegistered;
        }

        public void setTotalItemRegistered(int totalItemRegistered) {
            this.totalItemRegistered = totalItemRegistered;
        }
    }
}
