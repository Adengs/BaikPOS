package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetStock {

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
        @SerializedName("item_is_disposable")
        private int itemIsDisposable;
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
        @SerializedName("deleted_at")
        private String deletedAt;
        @SerializedName("jenis_item")
        private String jenisItem;
        @SerializedName("stock_awal")
        private String stockAwal;
        @SerializedName("stock_masuk")
        private String stockMasuk;
        @SerializedName("stock_terbuang")
        private String stockTerbuang;
        @SerializedName("stock_terproduksi")
        private String stockTerproduksi;
        @SerializedName("stock_keluar")
        private String stockKeluar;
        @SerializedName("stock_transit")
        private String stockTransit;
        @SerializedName("stock_terjual")
        private String stockTerjual;
        @SerializedName("stock_akhir")
        private String stockAkhir;
        @SerializedName("unit_name")
        private String unitName;
        @SerializedName("actual_stock")
        private int actualStock;
        @SerializedName("item_type_txt")
        private String itemTypeTxt;
        @SerializedName("category_name_txt")
        private String categoryNameTxt;

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

        public int getItemIsDisposable() {
            return itemIsDisposable;
        }

        public void setItemIsDisposable(int itemIsDisposable) {
            this.itemIsDisposable = itemIsDisposable;
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

        public String getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
        }

        public String getJenisItem() {
            return jenisItem;
        }

        public void setJenisItem(String jenisItem) {
            this.jenisItem = jenisItem;
        }

        public String getStockAwal() {
            return stockAwal.replace(".00","");
        }


        public void setStockAwal(String stockAwal) {
            this.stockAwal = stockAwal;
        }

        public String getStockMasuk() {
            return stockMasuk.replace(".00","");
        }

        public void setStockMasuk(String stockMasuk) {
            this.stockMasuk = stockMasuk;
        }

        public String getStockTerbuang() {
            return stockTerbuang.replace(".00","");
        }

        public void setStockTerbuang(String stockTerbuang) {
            this.stockTerbuang = stockTerbuang;
        }

        public String getStockTerproduksi() {
            return stockTerproduksi.replace(".00","");
        }

        public void setStockTerproduksi(String stockTerproduksi) {
            this.stockTerproduksi = stockTerproduksi;
        }

        public String getStockKeluar() {
            return stockKeluar.replace(".00","");
        }

        public void setStockKeluar(String stockKeluar) {
            this.stockKeluar = stockKeluar;
        }

        public String getStockTransit() {
            return stockTransit.replace(".00","");
        }

        public void setStockTransit(String stockTransit) {
            this.stockTransit = stockTransit;
        }

        public String getStockTerjual() {
            return stockTerjual.replace(".00","");
        }

        public void setStockTerjual(String stockTerjual) {
            this.stockTerjual = stockTerjual;
        }

        public String getStockAkhir() {
            return stockAkhir.replace(".00","");
        }

        public void setStockAkhir(String stockAkhir) {
            this.stockAkhir = stockAkhir;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
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
    }
}
