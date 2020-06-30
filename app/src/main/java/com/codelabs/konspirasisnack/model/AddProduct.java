package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

public class AddProduct {


    @SerializedName("DATA")
    private AddProduct.DATA DATA;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("MESSAGE")
    private String MESSAGE;

    public AddProduct.DATA getDATA() {
        return DATA;
    }

    public void setDATA(AddProduct.DATA DATA) {
        this.DATA = DATA;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public static class DATA {
        @SerializedName("item_merchant_id")
        private int itemMerchantId;
        @SerializedName("item_category_id")
        private String itemCategoryId;
        @SerializedName("item_unit_id")
        private String itemUnitId;
        @SerializedName("item_name")
        private String itemName;
        @SerializedName("item_is_cashier_on")
        private int itemIsCashierOn;
        @SerializedName("item_harga_modal")
        private String itemHargaModal;
        @SerializedName("item_harga_jual")
        private String itemHargaJual;
        @SerializedName("item_is_active")
        private int itemIsActive;
        @SerializedName("item_created_by")
        private int itemCreatedBy;
        @SerializedName("item_updated_by")
        private int itemUpdatedBy;
        @SerializedName("item_image")
        private String itemImage;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("item_id")
        private int itemId;
        @SerializedName("actual_stock")
        private int actualStock;
        @SerializedName("selisih_stock")
        private int selisihStock;
        @SerializedName("item_type_txt")
        private String itemTypeTxt;
        @SerializedName("category_name_txt")
        private String categoryNameTxt;
        @SerializedName("category")
        private Category category;

        public int getItemMerchantId() {
            return itemMerchantId;
        }

        public void setItemMerchantId(int itemMerchantId) {
            this.itemMerchantId = itemMerchantId;
        }

        public String getItemCategoryId() {
            return itemCategoryId;
        }

        public void setItemCategoryId(String itemCategoryId) {
            this.itemCategoryId = itemCategoryId;
        }

        public String getItemUnitId() {
            return itemUnitId;
        }

        public void setItemUnitId(String itemUnitId) {
            this.itemUnitId = itemUnitId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public int getItemIsCashierOn() {
            return itemIsCashierOn;
        }

        public void setItemIsCashierOn(int itemIsCashierOn) {
            this.itemIsCashierOn = itemIsCashierOn;
        }

        public String getItemHargaModal() {
            return itemHargaModal;
        }

        public void setItemHargaModal(String itemHargaModal) {
            this.itemHargaModal = itemHargaModal;
        }

        public String getItemHargaJual() {
            return itemHargaJual;
        }

        public void setItemHargaJual(String itemHargaJual) {
            this.itemHargaJual = itemHargaJual;
        }

        public int getItemIsActive() {
            return itemIsActive;
        }

        public void setItemIsActive(int itemIsActive) {
            this.itemIsActive = itemIsActive;
        }

        public int getItemCreatedBy() {
            return itemCreatedBy;
        }

        public void setItemCreatedBy(int itemCreatedBy) {
            this.itemCreatedBy = itemCreatedBy;
        }

        public int getItemUpdatedBy() {
            return itemUpdatedBy;
        }

        public void setItemUpdatedBy(int itemUpdatedBy) {
            this.itemUpdatedBy = itemUpdatedBy;
        }

        public String getItemImage() {
            return itemImage;
        }

        public void setItemImage(String itemImage) {
            this.itemImage = itemImage;
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

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getActualStock() {
            return actualStock;
        }

        public void setActualStock(int actualStock) {
            this.actualStock = actualStock;
        }

        public int getSelisihStock() {
            return selisihStock;
        }

        public void setSelisihStock(int selisihStock) {
            this.selisihStock = selisihStock;
        }

        public String getItemTypeTxt() {
            return itemTypeTxt;
        }

        public void setItemTypeTxt(String itemTypeTxt) {
            this.itemTypeTxt = itemTypeTxt;
        }

        public String getCategoryNameTxt() {
            return categoryNameTxt;
        }

        public void setCategoryNameTxt(String categoryNameTxt) {
            this.categoryNameTxt = categoryNameTxt;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public static class Category {

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
        }
    }
}
