package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProducts {

    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;
    @SerializedName("DATA")
    private List<DATABean> DATA;

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

    public List<DATABean> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATABean> DATA) {
        this.DATA = DATA;
    }

    public static class DATABean {


        @SerializedName("item_id")
        private int itemId;
        @SerializedName("item_merchant_id")
        private int itemMerchantId;
        @SerializedName("item_category_id")
        private int itemCategoryId;
        @SerializedName("item_unit_id")
        private int itemUnitId;
        @SerializedName("item_name")
        private String itemName;
        @SerializedName("item_description")
        private String itemDescription;
        @SerializedName("item_sku")
        private String itemSku;
        @SerializedName("item_image")
        private String itemImage;
        @SerializedName("item_is_favorite")
        private int itemIsFavorite;
        @SerializedName("item_harga_modal")
        private String itemHargaModal;
        @SerializedName("item_harga_jual")
        private String itemHargaJual;
        @SerializedName("item_minimum_price")
        private String itemMinimumPrice;
        @SerializedName("item_is_parent")
        private int itemIsParent;
        @SerializedName("item_parent_id")
        private int itemParentId;
        @SerializedName("item_is_cashier_on")
        private int itemIsCashierOn;
        @SerializedName("item_is_changeable_price")
        private int itemIsChangeablePrice;
        @SerializedName("item_stock_alert_at")
        private String itemStockAlertAt;
        @SerializedName("item_type")
        private int itemType;
        @SerializedName("item_created_by")
        private int itemCreatedBy;
        @SerializedName("item_updated_by")
        private int itemUpdatedBy;
        @SerializedName("item_is_active")
        private int itemIsActive;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("actual_stock")
        private int actualStock;
        @SerializedName("item_type_txt")
        private String itemTypeTxt;
        @SerializedName("category_name_txt")
        private String categoryNameTxt;
        @SerializedName("is_promo_available")
        private int is_promo_available;
        @SerializedName("promo_actual_value")
        private String promo_actual_value;
        @SerializedName("item_harga_jual_actual")
        private String item_harga_jual_actual;
        @SerializedName("category")
        private Category category;
        @SerializedName("unit")
        private Unit unit;
        @SerializedName("variants")
        private List<Variants> variants;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getItemMerchantId() {
            return itemMerchantId;
        }

        public void setItemMerchantId(int itemMerchantId) {
            this.itemMerchantId = itemMerchantId;
        }

        public int getItemCategoryId() {
            return itemCategoryId;
        }

        public void setItemCategoryId(int itemCategoryId) {
            this.itemCategoryId = itemCategoryId;
        }

        public int getItemUnitId() {
            return itemUnitId;
        }

        public void setItemUnitId(int itemUnitId) {
            this.itemUnitId = itemUnitId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getItemSku() {
            return itemSku;
        }

        public void setItemSku(String itemSku) {
            this.itemSku = itemSku;
        }

        public String getItemImage() {
            return itemImage;
        }

        public void setItemImage(String itemImage) {
            this.itemImage = itemImage;
        }

        public int getItemIsFavorite() {
            return itemIsFavorite;
        }

        public void setItemIsFavorite(int itemIsFavorite) {
            this.itemIsFavorite = itemIsFavorite;
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

        public String getItemMinimumPrice() {
            return itemMinimumPrice;
        }

        public void setItemMinimumPrice(String itemMinimumPrice) {
            this.itemMinimumPrice = itemMinimumPrice;
        }

        public int getItemIsParent() {
            return itemIsParent;
        }

        public void setItemIsParent(int itemIsParent) {
            this.itemIsParent = itemIsParent;
        }

        public int getItemParentId() {
            return itemParentId;
        }

        public void setItemParentId(int itemParentId) {
            this.itemParentId = itemParentId;
        }

        public int getItemIsCashierOn() {
            return itemIsCashierOn;
        }

        public void setItemIsCashierOn(int itemIsCashierOn) {
            this.itemIsCashierOn = itemIsCashierOn;
        }

        public int getItemIsChangeablePrice() {
            return itemIsChangeablePrice;
        }

        public void setItemIsChangeablePrice(int itemIsChangeablePrice) {
            this.itemIsChangeablePrice = itemIsChangeablePrice;
        }

        public String getItemStockAlertAt() {
            return itemStockAlertAt;
        }

        public void setItemStockAlertAt(String itemStockAlertAt) {
            this.itemStockAlertAt = itemStockAlertAt;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
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

        public int getItemIsActive() {
            return itemIsActive;
        }

        public void setItemIsActive(int itemIsActive) {
            this.itemIsActive = itemIsActive;
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

        public int getActualStock() {
            return actualStock;
        }

        public void setActualStock(int actualStock) {
            this.actualStock = actualStock;
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


        public int getIs_promo_available() {
            return is_promo_available;
        }

        public void setIs_promo_available(int is_promo_available) {
            this.is_promo_available = is_promo_available;
        }

        public String getPromo_actual_value() {
            return promo_actual_value;
        }

        public void setPromo_actual_value(String promo_actual_value) {
            this.promo_actual_value = promo_actual_value;
        }

        public String getItem_harga_jual_actual() {
            return item_harga_jual_actual;
        }

        public void setItem_harga_jual_actual(String item_harga_jual_actual) {
            this.item_harga_jual_actual = item_harga_jual_actual;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public List<Variants> getVariants() {
            return variants;
        }

        public void setVariants(List<Variants> variants) {
            this.variants = variants;
        }

        public static class Category {
            /**
             * item_cat_id : 2
             * item_cat_merchant_id : 3
             * item_cat_outlet_id : 0
             * item_cat_name : Nasi goreng
             * item_cat_description : Nasi yang di goreng tidak sehat
             * item_cat_sort : 1
             * item_cat_is_active : 1
             * created_at : 2019-12-30 17:11:08
             * updated_at : 2020-01-03 11:22:22
             */

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

        public static class Unit {
            /**
             * unit_id : 4
             * unit_name : Buah
             * unit_code : Bh
             * unit_is_active : 1
             * created_at : 2017-02-18 12:03:33
             * updated_at : 2017-02-18 12:03:33
             */

            @SerializedName("unit_id")
            private int unitId;
            @SerializedName("unit_name")
            private String unitName;
            @SerializedName("unit_code")
            private String unitCode;
            @SerializedName("unit_is_active")
            private int unitIsActive;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getUnitId() {
                return unitId;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
            }

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public String getUnitCode() {
                return unitCode;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public int getUnitIsActive() {
                return unitIsActive;
            }

            public void setUnitIsActive(int unitIsActive) {
                this.unitIsActive = unitIsActive;
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

        public static class Variants {


            @SerializedName("variant_id")
            private int variantId;
            @SerializedName("variant_merchant_id")
            private int variantMerchantId;
            @SerializedName("variant_outlet_id")
            private int variantOutletId;
            @SerializedName("variant_name")
            private String variantName;
            @SerializedName("variant_choose_type")
            private int variantChooseType;
            @SerializedName("variant_created_by")
            private int variantCreatedBy;
            @SerializedName("variant_updated_by")
            private int variantUpdatedBy;
            @SerializedName("variant_is_active")
            private int variantIsActive;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;
            @SerializedName("detail")
            private List<Detail> detail;

            public int getVariantId() {
                return variantId;
            }

            public void setVariantId(int variantId) {
                this.variantId = variantId;
            }

            public int getVariantMerchantId() {
                return variantMerchantId;
            }

            public void setVariantMerchantId(int variantMerchantId) {
                this.variantMerchantId = variantMerchantId;
            }

            public int getVariantOutletId() {
                return variantOutletId;
            }

            public void setVariantOutletId(int variantOutletId) {
                this.variantOutletId = variantOutletId;
            }

            public String getVariantName() {
                return variantName;
            }

            public void setVariantName(String variantName) {
                this.variantName = variantName;
            }

            public int getVariantChooseType() {
                return variantChooseType;
            }

            public void setVariantChooseType(int variantChooseType) {
                this.variantChooseType = variantChooseType;
            }

            public int getVariantCreatedBy() {
                return variantCreatedBy;
            }

            public void setVariantCreatedBy(int variantCreatedBy) {
                this.variantCreatedBy = variantCreatedBy;
            }

            public int getVariantUpdatedBy() {
                return variantUpdatedBy;
            }

            public void setVariantUpdatedBy(int variantUpdatedBy) {
                this.variantUpdatedBy = variantUpdatedBy;
            }

            public int getVariantIsActive() {
                return variantIsActive;
            }

            public void setVariantIsActive(int variantIsActive) {
                this.variantIsActive = variantIsActive;
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

            public List<Detail> getDetail() {
                return detail;
            }

            public void setDetail(List<Detail> detail) {
                this.detail = detail;
            }

            public static class Detail {
                /**
                 * variant_detail_id : 12
                 * variant_detail_variant_id : 5
                 * variant_detail_item_id : 0
                 * variant_detail_name : Regular
                 * variant_detail_harga_modal : 0.00
                 * variant_detail_harga_jual : 0.00
                 * variant_detail_amount : 0.00
                 * variant_detail_is_inventory : 0
                 * detail_name_txt : Regular
                 * item : {"item_id":0,"id":0,"actual_stock":0,"item_type_txt":"","category_name_txt":"","category":{"item_cat_id":0}}
                 */

                @SerializedName("variant_detail_id")
                private int variantDetailId;
                @SerializedName("variant_detail_variant_id")
                private int variantDetailVariantId;
                @SerializedName("variant_detail_item_id")
                private int variantDetailItemId;
                @SerializedName("variant_detail_name")
                private String variantDetailName;
                @SerializedName("variant_detail_harga_modal")
                private String variantDetailHargaModal;
                @SerializedName("variant_detail_harga_jual")
                private String variantDetailHargaJual;
                @SerializedName("variant_detail_amount")
                private String variantDetailAmount;
                @SerializedName("variant_detail_is_inventory")
                private int variantDetailIsInventory;
                @SerializedName("detail_name_txt")
                private String detailNameTxt;
                @SerializedName("item")
                private Item item;

                public int getVariantDetailId() {
                    return variantDetailId;
                }

                public void setVariantDetailId(int variantDetailId) {
                    this.variantDetailId = variantDetailId;
                }

                public int getVariantDetailVariantId() {
                    return variantDetailVariantId;
                }

                public void setVariantDetailVariantId(int variantDetailVariantId) {
                    this.variantDetailVariantId = variantDetailVariantId;
                }

                public int getVariantDetailItemId() {
                    return variantDetailItemId;
                }

                public void setVariantDetailItemId(int variantDetailItemId) {
                    this.variantDetailItemId = variantDetailItemId;
                }

                public String getVariantDetailName() {
                    return variantDetailName;
                }

                public void setVariantDetailName(String variantDetailName) {
                    this.variantDetailName = variantDetailName;
                }

                public String getVariantDetailHargaModal() {
                    return variantDetailHargaModal;
                }

                public void setVariantDetailHargaModal(String variantDetailHargaModal) {
                    this.variantDetailHargaModal = variantDetailHargaModal;
                }

                public String getVariantDetailHargaJual() {
                    return variantDetailHargaJual;
                }

                public void setVariantDetailHargaJual(String variantDetailHargaJual) {
                    this.variantDetailHargaJual = variantDetailHargaJual;
                }

                public String getVariantDetailAmount() {
                    return variantDetailAmount;
                }

                public void setVariantDetailAmount(String variantDetailAmount) {
                    this.variantDetailAmount = variantDetailAmount;
                }

                public int getVariantDetailIsInventory() {
                    return variantDetailIsInventory;
                }

                public void setVariantDetailIsInventory(int variantDetailIsInventory) {
                    this.variantDetailIsInventory = variantDetailIsInventory;
                }

                public String getDetailNameTxt() {
                    return detailNameTxt;
                }

                public void setDetailNameTxt(String detailNameTxt) {
                    this.detailNameTxt = detailNameTxt;
                }

                public Item getItem() {
                    return item;
                }

                public void setItem(Item item) {
                    this.item = item;
                }

                public static class Item {
                    /**
                     * item_id : 0
                     * id : 0
                     * actual_stock : 0
                     * item_type_txt :
                     * category_name_txt :
                     * category : {"item_cat_id":0}
                     */

                    @SerializedName("item_id")
                    private int itemId;
                    @SerializedName("id")
                    private int id;
                    @SerializedName("actual_stock")
                    private int actualStock;
                    @SerializedName("item_type_txt")
                    private String itemTypeTxt;
                    @SerializedName("category_name_txt")
                    private String categoryNameTxt;
                    @SerializedName("category")
                    private CategoryBean category;

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getActualStock() {
                        return actualStock;
                    }

                    public void setActualStock(int actualStock) {
                        this.actualStock = actualStock;
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

                    public CategoryBean getCategory() {
                        return category;
                    }

                    public void setCategory(CategoryBean category) {
                        this.category = category;
                    }

                    public static class CategoryBean {
                        /**
                         * item_cat_id : 0
                         */

                        @SerializedName("item_cat_id")
                        private int itemCatId;

                        public int getItemCatId() {
                            return itemCatId;
                        }

                        public void setItemCatId(int itemCatId) {
                            this.itemCatId = itemCatId;
                        }

                    }
                }
            }
        }
    }

}
