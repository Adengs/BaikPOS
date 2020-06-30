package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetInvoiceNumber {

    /**
     * DATA : {"invoice_no":"IN97010899831","promo_list":{"basic":{"promo_id":1,"promo_merchant_id":5,"promo_name":"Basic Promo","promo_start_date":"","promo_end_date":"","promo_type":1,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"0.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"BASIC PROMO","promo_days":"Sun,Mon,Tue,Wed,Thu,Fri,Sat","promo_created_by":0,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"2020-02-21 16:58:00","promo_items":[],"promo_bonus":[]},"product":[{"promo_id":5,"promo_merchant_id":5,"promo_name":"Valentine Promo","promo_start_date":"2020-02-01 06:00:00","promo_end_date":"2020-02-29 07:00:00","promo_type":2,"promo_bonus_type":3,"promo_value":"0.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"Buy 1 Get 1","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":9,"promo_is_active":1,"created_at":"","updated_at":"2020-02-11 09:24:49","promo_items":[{"pr_items_promo_id":5,"pr_items_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}],"promo_bonus":[{"pb_promo_id":5,"pb_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}]},{"promo_id":7,"promo_merchant_id":5,"promo_name":"Promo cek","promo_start_date":"2020-02-01 09:00:00","promo_end_date":"2020-03-07 09:00:00","promo_type":2,"promo_bonus_type":1,"promo_value":"10.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"cek","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[{"pr_items_promo_id":7,"pr_items_item_id":32,"item":{"item_id":32,"item_merchant_id":5,"item_category_id":8,"item_unit_id":23,"item_name":"Lotek","item_description":"","item_sku":"SKU12345","item_image":"2bc855ebd64240c5c26bccda8dcea72e.jpg","item_is_favorite":1,"item_harga_modal":"15000.00","item_harga_jual":"20000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"0.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-10 17:52:47","updated_at":"2020-02-10 18:02:57"}}],"promo_bonus":[]}],"pembelian":[{"promo_id":2,"promo_merchant_id":5,"promo_name":"Promo Sultan","promo_start_date":"2020-02-01 12:00:00","promo_end_date":"2020-07-24 12:00:00","promo_type":3,"promo_bonus_type":2,"promo_value":"5000000.00","promo_base_type":1,"promo_min_value":"100000000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo untuk pembelian di atas 100 juta","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]},{"promo_id":6,"promo_merchant_id":5,"promo_name":"Promo  Bandung","promo_start_date":"2020-02-01 16:00:00","promo_end_date":"2020-03-01 16:00:00","promo_type":3,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"100000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo Khusus Outlet Bandung","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]}]},"settings":{"tax":{"is_active":"on","tax_type":"2","percentage":"5      "},"service":{"is_active":"0","percentage":"0","table":"0","free_table":"0","bungkus":"0","pengiriman":"0","ojek_online":"0","reservasi":"0","jasa":"0","lainnya":"0"},"pembulatan":{"is_active":"0","value":"500"},"struk":{"is_active":"0","logo":"","logo_is_active":"0","negara":"0","nama_usaha":"0","telepon":"0","nama_outlet":"0","email":"0","alamat":"0","media_sosial":"0","kota":"0","provinsi":"0","header":"","header_is_active":"0","footer":"0","footer_is_active":"0","catatan":"0","catatan_is_active":"0"}}}
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
         * invoice_no : IN97010899831
         * promo_list : {"basic":{"promo_id":1,"promo_merchant_id":5,"promo_name":"Basic Promo","promo_start_date":"","promo_end_date":"","promo_type":1,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"0.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"BASIC PROMO","promo_days":"Sun,Mon,Tue,Wed,Thu,Fri,Sat","promo_created_by":0,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"2020-02-21 16:58:00","promo_items":[],"promo_bonus":[]},"product":[{"promo_id":5,"promo_merchant_id":5,"promo_name":"Valentine Promo","promo_start_date":"2020-02-01 06:00:00","promo_end_date":"2020-02-29 07:00:00","promo_type":2,"promo_bonus_type":3,"promo_value":"0.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"Buy 1 Get 1","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":9,"promo_is_active":1,"created_at":"","updated_at":"2020-02-11 09:24:49","promo_items":[{"pr_items_promo_id":5,"pr_items_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}],"promo_bonus":[{"pb_promo_id":5,"pb_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}]},{"promo_id":7,"promo_merchant_id":5,"promo_name":"Promo cek","promo_start_date":"2020-02-01 09:00:00","promo_end_date":"2020-03-07 09:00:00","promo_type":2,"promo_bonus_type":1,"promo_value":"10.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"cek","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[{"pr_items_promo_id":7,"pr_items_item_id":32,"item":{"item_id":32,"item_merchant_id":5,"item_category_id":8,"item_unit_id":23,"item_name":"Lotek","item_description":"","item_sku":"SKU12345","item_image":"2bc855ebd64240c5c26bccda8dcea72e.jpg","item_is_favorite":1,"item_harga_modal":"15000.00","item_harga_jual":"20000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"0.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-10 17:52:47","updated_at":"2020-02-10 18:02:57"}}],"promo_bonus":[]}],"pembelian":[{"promo_id":2,"promo_merchant_id":5,"promo_name":"Promo Sultan","promo_start_date":"2020-02-01 12:00:00","promo_end_date":"2020-07-24 12:00:00","promo_type":3,"promo_bonus_type":2,"promo_value":"5000000.00","promo_base_type":1,"promo_min_value":"100000000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo untuk pembelian di atas 100 juta","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]},{"promo_id":6,"promo_merchant_id":5,"promo_name":"Promo  Bandung","promo_start_date":"2020-02-01 16:00:00","promo_end_date":"2020-03-01 16:00:00","promo_type":3,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"100000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo Khusus Outlet Bandung","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]}]}
         * settings : {"tax":{"is_active":"on","tax_type":"2","percentage":"5      "},"service":{"is_active":"0","percentage":"0","table":"0","free_table":"0","bungkus":"0","pengiriman":"0","ojek_online":"0","reservasi":"0","jasa":"0","lainnya":"0"},"pembulatan":{"is_active":"0","value":"500"},"struk":{"is_active":"0","logo":"","logo_is_active":"0","negara":"0","nama_usaha":"0","telepon":"0","nama_outlet":"0","email":"0","alamat":"0","media_sosial":"0","kota":"0","provinsi":"0","header":"","header_is_active":"0","footer":"0","footer_is_active":"0","catatan":"0","catatan_is_active":"0"}}
         */

        @SerializedName("invoice_no")
        private String invoiceNo;
        @SerializedName("promo_list")
        private PromoItem promoList;
        @SerializedName("settings")
        private Settings settings;
        @SerializedName("marketplace")
        private Marketplace marketplace;

        public String getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }

        public PromoItem getPromoList() {
            return promoList;
        }

        public void setPromoList(PromoItem promoList) {
            this.promoList = promoList;
        }

        public Settings getSettings() {
            return settings;
        }

        public void setSettings(Settings settings) {
            this.settings = settings;
        }

        public Marketplace getMarketplace() {
            return marketplace;
        }

        public void setMarketplace(Marketplace marketplace) {
            this.marketplace = marketplace;
        }

        public static class PromoItem {
            /**
             * basic : {"promo_id":1,"promo_merchant_id":5,"promo_name":"Basic Promo","promo_start_date":"","promo_end_date":"","promo_type":1,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"0.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"BASIC PROMO","promo_days":"Sun,Mon,Tue,Wed,Thu,Fri,Sat","promo_created_by":0,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"2020-02-21 16:58:00","promo_items":[],"promo_bonus":[]}
             * product : [{"promo_id":5,"promo_merchant_id":5,"promo_name":"Valentine Promo","promo_start_date":"2020-02-01 06:00:00","promo_end_date":"2020-02-29 07:00:00","promo_type":2,"promo_bonus_type":3,"promo_value":"0.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":0,"promo_activation":0,"promo_info":"Buy 1 Get 1","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":9,"promo_is_active":1,"created_at":"","updated_at":"2020-02-11 09:24:49","promo_items":[{"pr_items_promo_id":5,"pr_items_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}],"promo_bonus":[{"pb_promo_id":5,"pb_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}]},{"promo_id":7,"promo_merchant_id":5,"promo_name":"Promo cek","promo_start_date":"2020-02-01 09:00:00","promo_end_date":"2020-03-07 09:00:00","promo_type":2,"promo_bonus_type":1,"promo_value":"10.00","promo_base_type":2,"promo_min_value":"1.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"cek","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[{"pr_items_promo_id":7,"pr_items_item_id":32,"item":{"item_id":32,"item_merchant_id":5,"item_category_id":8,"item_unit_id":23,"item_name":"Lotek","item_description":"","item_sku":"SKU12345","item_image":"2bc855ebd64240c5c26bccda8dcea72e.jpg","item_is_favorite":1,"item_harga_modal":"15000.00","item_harga_jual":"20000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"0.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-10 17:52:47","updated_at":"2020-02-10 18:02:57"}}],"promo_bonus":[]}]
             * pembelian : [{"promo_id":2,"promo_merchant_id":5,"promo_name":"Promo Sultan","promo_start_date":"2020-02-01 12:00:00","promo_end_date":"2020-07-24 12:00:00","promo_type":3,"promo_bonus_type":2,"promo_value":"5000000.00","promo_base_type":1,"promo_min_value":"100000000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo untuk pembelian di atas 100 juta","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]},{"promo_id":6,"promo_merchant_id":5,"promo_name":"Promo  Bandung","promo_start_date":"2020-02-01 16:00:00","promo_end_date":"2020-03-01 16:00:00","promo_type":3,"promo_bonus_type":1,"promo_value":"20.00","promo_base_type":1,"promo_min_value":"100000.00","promo_is_multiple":1,"promo_activation":0,"promo_info":"Promo Khusus Outlet Bandung","promo_days":"Mon,Tue,Wed,Thu,Fri,Sat,Sun","promo_created_by":9,"promo_updated_by":0,"promo_is_active":1,"created_at":"","updated_at":"","promo_items":[],"promo_bonus":[]}]
             */

            @SerializedName("basic")
            private Basic basic;
            @SerializedName("product")
            private List<ProductItem> product;
            @SerializedName("pembelian")
            private List<Pembelian> pembelian;

            public Basic getBasic() {
                return basic;
            }

            public void setBasic(Basic basic) {
                this.basic = basic;
            }

            public List<ProductItem> getProduct() {
                return product;
            }

            public void setProduct(List<ProductItem> product) {
                this.product = product;
            }

            public List<Pembelian> getPembelian() {
                return pembelian;
            }

            public void setPembelian(List<Pembelian> pembelian) {
                this.pembelian = pembelian;
            }

            public static class Basic {
                /**
                 * promo_id : 1
                 * promo_merchant_id : 5
                 * promo_name : Basic Promo
                 * promo_start_date :
                 * promo_end_date :
                 * promo_type : 1
                 * promo_bonus_type : 1
                 * promo_value : 20.00
                 * promo_base_type : 1
                 * promo_min_value : 0.00
                 * promo_is_multiple : 0
                 * promo_activation : 0
                 * promo_info : BASIC PROMO
                 * promo_days : Sun,Mon,Tue,Wed,Thu,Fri,Sat
                 * promo_created_by : 0
                 * promo_updated_by : 0
                 * promo_is_active : 1
                 * created_at :
                 * updated_at : 2020-02-21 16:58:00
                 * promo_items : []
                 * promo_bonus : []
                 */

                @SerializedName("promo_id")
                private int promoId;
                @SerializedName("promo_merchant_id")
                private int promoMerchantId;
                @SerializedName("promo_name")
                private String promoName;
                @SerializedName("promo_start_date")
                private String promoStartDate;
                @SerializedName("promo_end_date")
                private String promoEndDate;
                @SerializedName("promo_type")
                private int promoType;
                @SerializedName("promo_bonus_type")
                private int promoBonusType;
                @SerializedName("promo_value")
                private String promoValue;
                @SerializedName("promo_base_type")
                private int promoBaseType;
                @SerializedName("promo_min_value")
                private String promoMinValue;
                @SerializedName("promo_is_multiple")
                private int promoIsMultiple;
                @SerializedName("promo_activation")
                private int promoActivation;
                @SerializedName("promo_info")
                private String promoInfo;
                @SerializedName("promo_days")
                private String promoDays;
                @SerializedName("promo_created_by")
                private int promoCreatedBy;
                @SerializedName("promo_updated_by")
                private int promoUpdatedBy;
                @SerializedName("promo_is_active")
                private int promoIsActive;
                @SerializedName("created_at")
                private String createdAt;
                @SerializedName("updated_at")
                private String updatedAt;
                @SerializedName("promo_items")
                private List<?> promoItems;
                @SerializedName("promo_bonus")
                private List<?> promoBonus;

                public int getPromoId() {
                    return promoId;
                }

                public void setPromoId(int promoId) {
                    this.promoId = promoId;
                }

                public int getPromoMerchantId() {
                    return promoMerchantId;
                }

                public void setPromoMerchantId(int promoMerchantId) {
                    this.promoMerchantId = promoMerchantId;
                }

                public String getPromoName() {
                    return promoName;
                }

                public void setPromoName(String promoName) {
                    this.promoName = promoName;
                }

                public String getPromoStartDate() {
                    return promoStartDate;
                }

                public void setPromoStartDate(String promoStartDate) {
                    this.promoStartDate = promoStartDate;
                }

                public String getPromoEndDate() {
                    return promoEndDate;
                }

                public void setPromoEndDate(String promoEndDate) {
                    this.promoEndDate = promoEndDate;
                }

                public int getPromoType() {
                    return promoType;
                }

                public void setPromoType(int promoType) {
                    this.promoType = promoType;
                }

                public int getPromoBonusType() {
                    return promoBonusType;
                }

                public void setPromoBonusType(int promoBonusType) {
                    this.promoBonusType = promoBonusType;
                }

                public String getPromoValue() {
                    return promoValue;
                }

                public void setPromoValue(String promoValue) {
                    this.promoValue = promoValue;
                }

                public int getPromoBaseType() {
                    return promoBaseType;
                }

                public void setPromoBaseType(int promoBaseType) {
                    this.promoBaseType = promoBaseType;
                }

                public String getPromoMinValue() {
                    return promoMinValue;
                }

                public void setPromoMinValue(String promoMinValue) {
                    this.promoMinValue = promoMinValue;
                }

                public int getPromoIsMultiple() {
                    return promoIsMultiple;
                }

                public void setPromoIsMultiple(int promoIsMultiple) {
                    this.promoIsMultiple = promoIsMultiple;
                }

                public int getPromoActivation() {
                    return promoActivation;
                }

                public void setPromoActivation(int promoActivation) {
                    this.promoActivation = promoActivation;
                }

                public String getPromoInfo() {
                    return promoInfo;
                }

                public void setPromoInfo(String promoInfo) {
                    this.promoInfo = promoInfo;
                }

                public String getPromoDays() {
                    return promoDays;
                }

                public void setPromoDays(String promoDays) {
                    this.promoDays = promoDays;
                }

                public int getPromoCreatedBy() {
                    return promoCreatedBy;
                }

                public void setPromoCreatedBy(int promoCreatedBy) {
                    this.promoCreatedBy = promoCreatedBy;
                }

                public int getPromoUpdatedBy() {
                    return promoUpdatedBy;
                }

                public void setPromoUpdatedBy(int promoUpdatedBy) {
                    this.promoUpdatedBy = promoUpdatedBy;
                }

                public int getPromoIsActive() {
                    return promoIsActive;
                }

                public void setPromoIsActive(int promoIsActive) {
                    this.promoIsActive = promoIsActive;
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

                public List<?> getPromoItems() {
                    return promoItems;
                }

                public void setPromoItems(List<?> promoItems) {
                    this.promoItems = promoItems;
                }

                public List<?> getPromoBonus() {
                    return promoBonus;
                }

                public void setPromoBonus(List<?> promoBonus) {
                    this.promoBonus = promoBonus;
                }
            }

            public static class ProductItem {
                /**
                 * promo_id : 5
                 * promo_merchant_id : 5
                 * promo_name : Valentine Promo
                 * promo_start_date : 2020-02-01 06:00:00
                 * promo_end_date : 2020-02-29 07:00:00
                 * promo_type : 2
                 * promo_bonus_type : 3
                 * promo_value : 0.00
                 * promo_base_type : 2
                 * promo_min_value : 1.00
                 * promo_is_multiple : 0
                 * promo_activation : 0
                 * promo_info : Buy 1 Get 1
                 * promo_days : Mon,Tue,Wed,Thu,Fri,Sat,Sun
                 * promo_created_by : 9
                 * promo_updated_by : 9
                 * promo_is_active : 1
                 * created_at :
                 * updated_at : 2020-02-11 09:24:49
                 * promo_items : [{"pr_items_promo_id":5,"pr_items_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}]
                 * promo_bonus : [{"pb_promo_id":5,"pb_item_id":20,"item":{"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}}]
                 */

                @SerializedName("promo_id")
                private int promoId;
                @SerializedName("promo_merchant_id")
                private int promoMerchantId;
                @SerializedName("promo_name")
                private String promoName;
                @SerializedName("promo_start_date")
                private String promoStartDate;
                @SerializedName("promo_end_date")
                private String promoEndDate;
                @SerializedName("promo_type")
                private int promoType;
                @SerializedName("promo_bonus_type")
                private int promoBonusType;
                @SerializedName("promo_value")
                private String promoValue;
                @SerializedName("promo_base_type")
                private int promoBaseType;
                @SerializedName("promo_min_value")
                private String promoMinValue;
                @SerializedName("promo_is_multiple")
                private int promoIsMultiple;
                @SerializedName("promo_activation")
                private int promoActivation;
                @SerializedName("promo_info")
                private String promoInfo;
                @SerializedName("promo_days")
                private String promoDays;
                @SerializedName("promo_created_by")
                private int promoCreatedBy;
                @SerializedName("promo_updated_by")
                private int promoUpdatedBy;
                @SerializedName("promo_is_active")
                private int promoIsActive;
                @SerializedName("created_at")
                private String createdAt;
                @SerializedName("updated_at")
                private String updatedAt;
                @SerializedName("promo_items")
                private List<PromoItems> promoItems;
                @SerializedName("promo_bonus")
                private List<PromoBonus> promoBonus;

                public int getPromoId() {
                    return promoId;
                }

                public void setPromoId(int promoId) {
                    this.promoId = promoId;
                }

                public int getPromoMerchantId() {
                    return promoMerchantId;
                }

                public void setPromoMerchantId(int promoMerchantId) {
                    this.promoMerchantId = promoMerchantId;
                }

                public String getPromoName() {
                    return promoName;
                }

                public void setPromoName(String promoName) {
                    this.promoName = promoName;
                }

                public String getPromoStartDate() {
                    return promoStartDate;
                }

                public void setPromoStartDate(String promoStartDate) {
                    this.promoStartDate = promoStartDate;
                }

                public String getPromoEndDate() {
                    return promoEndDate;
                }

                public void setPromoEndDate(String promoEndDate) {
                    this.promoEndDate = promoEndDate;
                }

                public int getPromoType() {
                    return promoType;
                }

                public void setPromoType(int promoType) {
                    this.promoType = promoType;
                }

                public int getPromoBonusType() {
                    return promoBonusType;
                }

                public void setPromoBonusType(int promoBonusType) {
                    this.promoBonusType = promoBonusType;
                }

                public String getPromoValue() {
                    return promoValue;
                }

                public void setPromoValue(String promoValue) {
                    this.promoValue = promoValue;
                }

                public int getPromoBaseType() {
                    return promoBaseType;
                }

                public void setPromoBaseType(int promoBaseType) {
                    this.promoBaseType = promoBaseType;
                }

                public String getPromoMinValue() {
                    return promoMinValue;
                }

                public void setPromoMinValue(String promoMinValue) {
                    this.promoMinValue = promoMinValue;
                }

                public int getPromoIsMultiple() {
                    return promoIsMultiple;
                }

                public void setPromoIsMultiple(int promoIsMultiple) {
                    this.promoIsMultiple = promoIsMultiple;
                }

                public int getPromoActivation() {
                    return promoActivation;
                }

                public void setPromoActivation(int promoActivation) {
                    this.promoActivation = promoActivation;
                }

                public String getPromoInfo() {
                    return promoInfo;
                }

                public void setPromoInfo(String promoInfo) {
                    this.promoInfo = promoInfo;
                }

                public String getPromoDays() {
                    return promoDays;
                }

                public void setPromoDays(String promoDays) {
                    this.promoDays = promoDays;
                }

                public int getPromoCreatedBy() {
                    return promoCreatedBy;
                }

                public void setPromoCreatedBy(int promoCreatedBy) {
                    this.promoCreatedBy = promoCreatedBy;
                }

                public int getPromoUpdatedBy() {
                    return promoUpdatedBy;
                }

                public void setPromoUpdatedBy(int promoUpdatedBy) {
                    this.promoUpdatedBy = promoUpdatedBy;
                }

                public int getPromoIsActive() {
                    return promoIsActive;
                }

                public void setPromoIsActive(int promoIsActive) {
                    this.promoIsActive = promoIsActive;
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

                public List<PromoItems> getPromoItems() {
                    return promoItems;
                }

                public void setPromoItems(List<PromoItems> promoItems) {
                    this.promoItems = promoItems;
                }

                public List<PromoBonus> getPromoBonus() {
                    return promoBonus;
                }

                public void setPromoBonus(List<PromoBonus> promoBonus) {
                    this.promoBonus = promoBonus;
                }

                public static class PromoItems {
                    /**
                     * pr_items_promo_id : 5
                     * pr_items_item_id : 20
                     * item : {"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}
                     */

                    @SerializedName("pr_items_promo_id")
                    private int prItemsPromoId;
                    @SerializedName("pr_items_item_id")
                    private int prItemsItemId;
                    @SerializedName("item")
                    private Item item;

                    public int getPrItemsPromoId() {
                        return prItemsPromoId;
                    }

                    public void setPrItemsPromoId(int prItemsPromoId) {
                        this.prItemsPromoId = prItemsPromoId;
                    }

                    public int getPrItemsItemId() {
                        return prItemsItemId;
                    }

                    public void setPrItemsItemId(int prItemsItemId) {
                        this.prItemsItemId = prItemsItemId;
                    }

                    public Item getItem() {
                        return item;
                    }

                    public void setItem(Item item) {
                        this.item = item;
                    }

                    public static class Item {
                        /**
                         * item_id : 20
                         * item_merchant_id : 5
                         * item_category_id : 6
                         * item_unit_id : 0
                         * item_name : Es Kopi Kekinian
                         * item_description :
                         * item_sku : ES0101012
                         * item_image : d5217495884602661d8aed69a644cc10.jpg
                         * item_is_favorite : 1
                         * item_harga_modal : 10000.00
                         * item_harga_jual : 16000.00
                         * item_minimum_price : 0.00
                         * item_is_parent : 0
                         * item_parent_id : 0
                         * item_is_cashier_on : 1
                         * item_is_changeable_price : 0
                         * item_stock_alert_at : 40.00
                         * item_type : 1
                         * item_is_disposable : 0
                         * item_created_by : 9
                         * item_updated_by : 9
                         * item_is_active : 0
                         * created_at : 2020-02-07 11:05:29
                         * updated_at : 2020-02-18 12:08:14
                         */

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
                    }
                }

                public static class PromoBonus {
                    /**
                     * pb_promo_id : 5
                     * pb_item_id : 20
                     * item : {"item_id":20,"item_merchant_id":5,"item_category_id":6,"item_unit_id":0,"item_name":"Es Kopi Kekinian","item_description":"","item_sku":"ES0101012","item_image":"d5217495884602661d8aed69a644cc10.jpg","item_is_favorite":1,"item_harga_modal":"10000.00","item_harga_jual":"16000.00","item_minimum_price":"0.00","item_is_parent":0,"item_parent_id":0,"item_is_cashier_on":1,"item_is_changeable_price":0,"item_stock_alert_at":"40.00","item_type":1,"item_is_disposable":0,"item_created_by":9,"item_updated_by":9,"item_is_active":0,"created_at":"2020-02-07 11:05:29","updated_at":"2020-02-18 12:08:14"}
                     */

                    @SerializedName("pb_promo_id")
                    private int pbPromoId;
                    @SerializedName("pb_item_id")
                    private int pbItemId;
                    @SerializedName("item")
                    private ItemPromoBonus item;

                    public int getPbPromoId() {
                        return pbPromoId;
                    }

                    public void setPbPromoId(int pbPromoId) {
                        this.pbPromoId = pbPromoId;
                    }

                    public int getPbItemId() {
                        return pbItemId;
                    }

                    public void setPbItemId(int pbItemId) {
                        this.pbItemId = pbItemId;
                    }

                    public ItemPromoBonus getItem() {
                        return item;
                    }

                    public void setItem(ItemPromoBonus item) {
                        this.item = item;
                    }

                    public static class ItemPromoBonus {
                        /**
                         * item_id : 20
                         * item_merchant_id : 5
                         * item_category_id : 6
                         * item_unit_id : 0
                         * item_name : Es Kopi Kekinian
                         * item_description :
                         * item_sku : ES0101012
                         * item_image : d5217495884602661d8aed69a644cc10.jpg
                         * item_is_favorite : 1
                         * item_harga_modal : 10000.00
                         * item_harga_jual : 16000.00
                         * item_minimum_price : 0.00
                         * item_is_parent : 0
                         * item_parent_id : 0
                         * item_is_cashier_on : 1
                         * item_is_changeable_price : 0
                         * item_stock_alert_at : 40.00
                         * item_type : 1
                         * item_is_disposable : 0
                         * item_created_by : 9
                         * item_updated_by : 9
                         * item_is_active : 0
                         * created_at : 2020-02-07 11:05:29
                         * updated_at : 2020-02-18 12:08:14
                         */

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
                    }
                }
            }

            public static class Pembelian {
                /**
                 * promo_id : 2
                 * promo_merchant_id : 5
                 * promo_name : Promo Sultan
                 * promo_start_date : 2020-02-01 12:00:00
                 * promo_end_date : 2020-07-24 12:00:00
                 * promo_type : 3
                 * promo_bonus_type : 2
                 * promo_value : 5000000.00
                 * promo_base_type : 1
                 * promo_min_value : 100000000.00
                 * promo_is_multiple : 1
                 * promo_activation : 0
                 * promo_info : Promo untuk pembelian di atas 100 juta
                 * promo_days : Mon,Tue,Wed,Thu,Fri,Sat,Sun
                 * promo_created_by : 9
                 * promo_updated_by : 0
                 * promo_is_active : 1
                 * created_at :
                 * updated_at :
                 * promo_items : []
                 * promo_bonus : []
                 */

                @SerializedName("promo_id")
                private int promoId;
                @SerializedName("promo_merchant_id")
                private int promoMerchantId;
                @SerializedName("promo_name")
                private String promoName;
                @SerializedName("promo_start_date")
                private String promoStartDate;
                @SerializedName("promo_end_date")
                private String promoEndDate;
                @SerializedName("promo_type")
                private int promoType;
                @SerializedName("promo_bonus_type")
                private int promoBonusType;
                @SerializedName("promo_value")
                private String promoValue;
                @SerializedName("promo_base_type")
                private int promoBaseType;
                @SerializedName("promo_min_value")
                private String promoMinValue;
                @SerializedName("promo_is_multiple")
                private int promoIsMultiple;
                @SerializedName("promo_activation")
                private int promoActivation;
                @SerializedName("promo_info")
                private String promoInfo;
                @SerializedName("promo_days")
                private String promoDays;
                @SerializedName("promo_created_by")
                private int promoCreatedBy;
                @SerializedName("promo_updated_by")
                private int promoUpdatedBy;
                @SerializedName("promo_is_active")
                private int promoIsActive;
                @SerializedName("created_at")
                private String createdAt;
                @SerializedName("updated_at")
                private String updatedAt;
                @SerializedName("promo_items")
                private List<?> promoItems;
                @SerializedName("promo_bonus")
                private List<?> promoBonus;

                public int getPromoId() {
                    return promoId;
                }

                public void setPromoId(int promoId) {
                    this.promoId = promoId;
                }

                public int getPromoMerchantId() {
                    return promoMerchantId;
                }

                public void setPromoMerchantId(int promoMerchantId) {
                    this.promoMerchantId = promoMerchantId;
                }

                public String getPromoName() {
                    return promoName;
                }

                public void setPromoName(String promoName) {
                    this.promoName = promoName;
                }

                public String getPromoStartDate() {
                    return promoStartDate;
                }

                public void setPromoStartDate(String promoStartDate) {
                    this.promoStartDate = promoStartDate;
                }

                public String getPromoEndDate() {
                    return promoEndDate;
                }

                public void setPromoEndDate(String promoEndDate) {
                    this.promoEndDate = promoEndDate;
                }

                public int getPromoType() {
                    return promoType;
                }

                public void setPromoType(int promoType) {
                    this.promoType = promoType;
                }

                public int getPromoBonusType() {
                    return promoBonusType;
                }

                public void setPromoBonusType(int promoBonusType) {
                    this.promoBonusType = promoBonusType;
                }

                public String getPromoValue() {
                    return promoValue;
                }

                public void setPromoValue(String promoValue) {
                    this.promoValue = promoValue;
                }

                public int getPromoBaseType() {
                    return promoBaseType;
                }

                public void setPromoBaseType(int promoBaseType) {
                    this.promoBaseType = promoBaseType;
                }

                public String getPromoMinValue() {
                    return promoMinValue;
                }

                public void setPromoMinValue(String promoMinValue) {
                    this.promoMinValue = promoMinValue;
                }

                public int getPromoIsMultiple() {
                    return promoIsMultiple;
                }

                public void setPromoIsMultiple(int promoIsMultiple) {
                    this.promoIsMultiple = promoIsMultiple;
                }

                public int getPromoActivation() {
                    return promoActivation;
                }

                public void setPromoActivation(int promoActivation) {
                    this.promoActivation = promoActivation;
                }

                public String getPromoInfo() {
                    return promoInfo;
                }

                public void setPromoInfo(String promoInfo) {
                    this.promoInfo = promoInfo;
                }

                public String getPromoDays() {
                    return promoDays;
                }

                public void setPromoDays(String promoDays) {
                    this.promoDays = promoDays;
                }

                public int getPromoCreatedBy() {
                    return promoCreatedBy;
                }

                public void setPromoCreatedBy(int promoCreatedBy) {
                    this.promoCreatedBy = promoCreatedBy;
                }

                public int getPromoUpdatedBy() {
                    return promoUpdatedBy;
                }

                public void setPromoUpdatedBy(int promoUpdatedBy) {
                    this.promoUpdatedBy = promoUpdatedBy;
                }

                public int getPromoIsActive() {
                    return promoIsActive;
                }

                public void setPromoIsActive(int promoIsActive) {
                    this.promoIsActive = promoIsActive;
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

                public List<?> getPromoItems() {
                    return promoItems;
                }

                public void setPromoItems(List<?> promoItems) {
                    this.promoItems = promoItems;
                }

                public List<?> getPromoBonus() {
                    return promoBonus;
                }

                public void setPromoBonus(List<?> promoBonus) {
                    this.promoBonus = promoBonus;
                }
            }
        }

        public static class Settings {
            /**
             * tax : {"is_active":"on","tax_type":"2","percentage":"5      "}
             * service : {"is_active":"0","percentage":"0","table":"0","free_table":"0","bungkus":"0","pengiriman":"0","ojek_online":"0","reservasi":"0","jasa":"0","lainnya":"0"}
             * pembulatan : {"is_active":"0","value":"500"}
             * struk : {"is_active":"0","logo":"","logo_is_active":"0","negara":"0","nama_usaha":"0","telepon":"0","nama_outlet":"0","email":"0","alamat":"0","media_sosial":"0","kota":"0","provinsi":"0","header":"","header_is_active":"0","footer":"0","footer_is_active":"0","catatan":"0","catatan_is_active":"0"}
             */

            @SerializedName("tax")
            private Tax tax;
            @SerializedName("service")
            private Service service;
            @SerializedName("pembulatan")
            private Pembulatan pembulatan;
            @SerializedName("struk")
            private Struk struk;

            public Tax getTax() {
                return tax;
            }

            public void setTax(Tax tax) {
                this.tax = tax;
            }

            public Service getService() {
                return service;
            }

            public void setService(Service service) {
                this.service = service;
            }

            public Pembulatan getPembulatan() {
                return pembulatan;
            }

            public void setPembulatan(Pembulatan pembulatan) {
                this.pembulatan = pembulatan;
            }

            public Struk getStruk() {
                return struk;
            }

            public void setStruk(Struk struk) {
                this.struk = struk;
            }

            public static class Tax {
                /**
                 * is_active : on
                 * tax_type : 2
                 * percentage : 5
                 */

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("tax_type")
                private String taxType;
                @SerializedName("percentage")
                private String percentage;

                public String getIsActive() {
                    return isActive;
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getTaxType() {
                    return taxType;
                }

                public void setTaxType(String taxType) {
                    this.taxType = taxType;
                }

                public String getPercentage() {
                    return percentage;
                }

                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }
            }

            public static class Service {
                /**
                 * is_active : 0
                 * percentage : 0
                 * table : 0
                 * free_table : 0
                 * bungkus : 0
                 * pengiriman : 0
                 * ojek_online : 0
                 * reservasi : 0
                 * jasa : 0
                 * lainnya : 0
                 */

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("percentage")
                private String percentage;
                @SerializedName("table")
                private String table;
                @SerializedName("free_table")
                private String freeTable;
                @SerializedName("bungkus")
                private String bungkus;
                @SerializedName("pengiriman")
                private String pengiriman;
                @SerializedName("ojek_online")
                private String ojekOnline;
                @SerializedName("reservasi")
                private String reservasi;
                @SerializedName("jasa")
                private String jasa;
                @SerializedName("lainnya")
                private String lainnya;

                public String getIsActive() {
                    return isActive;
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getPercentage() {
                    return percentage;
                }

                public void setPercentage(String percentage) {
                    this.percentage = percentage;
                }

                public String getTable() {
                    return table;
                }

                public void setTable(String table) {
                    this.table = table;
                }

                public String getFreeTable() {
                    return freeTable;
                }

                public void setFreeTable(String freeTable) {
                    this.freeTable = freeTable;
                }

                public String getBungkus() {
                    return bungkus;
                }

                public void setBungkus(String bungkus) {
                    this.bungkus = bungkus;
                }

                public String getPengiriman() {
                    return pengiriman;
                }

                public void setPengiriman(String pengiriman) {
                    this.pengiriman = pengiriman;
                }

                public String getOjekOnline() {
                    return ojekOnline;
                }

                public void setOjekOnline(String ojekOnline) {
                    this.ojekOnline = ojekOnline;
                }

                public String getReservasi() {
                    return reservasi;
                }

                public void setReservasi(String reservasi) {
                    this.reservasi = reservasi;
                }

                public String getJasa() {
                    return jasa;
                }

                public void setJasa(String jasa) {
                    this.jasa = jasa;
                }

                public String getLainnya() {
                    return lainnya;
                }

                public void setLainnya(String lainnya) {
                    this.lainnya = lainnya;
                }
            }

            public static class Pembulatan {
                /**
                 * is_active : 0
                 * value : 500
                 */

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("value")
                private String value;

                public String getIsActive() {
                    return isActive;
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class Struk {
                /**
                 * is_active : 0
                 * logo :
                 * logo_is_active : 0
                 * negara : 0
                 * nama_usaha : 0
                 * telepon : 0
                 * nama_outlet : 0
                 * email : 0
                 * alamat : 0
                 * media_sosial : 0
                 * kota : 0
                 * provinsi : 0
                 * header :
                 * header_is_active : 0
                 * footer : 0
                 * footer_is_active : 0
                 * catatan : 0
                 * catatan_is_active : 0
                 */

                @SerializedName("is_active")
                private String isActive;
                @SerializedName("logo")
                private String logo;
                @SerializedName("logo_is_active")
                private String logoIsActive;
                @SerializedName("negara")
                private String negara;
                @SerializedName("nama_usaha")
                private String namaUsaha;
                @SerializedName("telepon")
                private String telepon;
                @SerializedName("nama_outlet")
                private String namaOutlet;
                @SerializedName("email")
                private String email;
                @SerializedName("alamat")
                private String alamat;
                @SerializedName("media_sosial")
                private String mediaSosial;
                @SerializedName("kota")
                private String kota;
                @SerializedName("provinsi")
                private String provinsi;
                @SerializedName("header")
                private String header;
                @SerializedName("header_is_active")
                private String headerIsActive;
                @SerializedName("footer")
                private String footer;
                @SerializedName("footer_is_active")
                private String footerIsActive;
                @SerializedName("catatan")
                private String catatan;
                @SerializedName("catatan_is_active")
                private String catatanIsActive;

                public String getIsActive() {
                    return isActive;
                }

                public void setIsActive(String isActive) {
                    this.isActive = isActive;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getLogoIsActive() {
                    return logoIsActive;
                }

                public void setLogoIsActive(String logoIsActive) {
                    this.logoIsActive = logoIsActive;
                }

                public String getNegara() {
                    return negara;
                }

                public void setNegara(String negara) {
                    this.negara = negara;
                }

                public String getNamaUsaha() {
                    return namaUsaha;
                }

                public void setNamaUsaha(String namaUsaha) {
                    this.namaUsaha = namaUsaha;
                }

                public String getTelepon() {
                    return telepon;
                }

                public void setTelepon(String telepon) {
                    this.telepon = telepon;
                }

                public String getNamaOutlet() {
                    return namaOutlet;
                }

                public void setNamaOutlet(String namaOutlet) {
                    this.namaOutlet = namaOutlet;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getAlamat() {
                    return alamat;
                }

                public void setAlamat(String alamat) {
                    this.alamat = alamat;
                }

                public String getMediaSosial() {
                    return mediaSosial;
                }

                public void setMediaSosial(String mediaSosial) {
                    this.mediaSosial = mediaSosial;
                }

                public String getKota() {
                    return kota;
                }

                public void setKota(String kota) {
                    this.kota = kota;
                }

                public String getProvinsi() {
                    return provinsi;
                }

                public void setProvinsi(String provinsi) {
                    this.provinsi = provinsi;
                }

                public String getHeader() {
                    return header;
                }

                public void setHeader(String header) {
                    this.header = header;
                }

                public String getHeaderIsActive() {
                    return headerIsActive;
                }

                public void setHeaderIsActive(String headerIsActive) {
                    this.headerIsActive = headerIsActive;
                }

                public String getFooter() {
                    return footer;
                }

                public void setFooter(String footer) {
                    this.footer = footer;
                }

                public String getFooterIsActive() {
                    return footerIsActive;
                }

                public void setFooterIsActive(String footerIsActive) {
                    this.footerIsActive = footerIsActive;
                }

                public String getCatatan() {
                    return catatan;
                }

                public void setCatatan(String catatan) {
                    this.catatan = catatan;
                }

                public String getCatatanIsActive() {
                    return catatanIsActive;
                }

                public void setCatatanIsActive(String catatanIsActive) {
                    this.catatanIsActive = catatanIsActive;
                }
            }
        }

        public static class Marketplace {
            @SerializedName("total")
            private int total;
            @SerializedName("text")
            private String text;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}
