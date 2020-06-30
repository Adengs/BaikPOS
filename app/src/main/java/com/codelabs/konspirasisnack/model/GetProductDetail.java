package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProductDetail {

    @Expose
    @SerializedName("STATUS")
    private int STATUS;
    @Expose
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @Expose
    @SerializedName("DATA")
    private DATAProduct DATA;


    public int getSTATUS() {
        return STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public DATAProduct getDATA() {
        return DATA;
    }

    public static class DATAProduct {
        @Expose
        @SerializedName("unit")
        private UnitData unit;
        @Expose
        @SerializedName("variants")
        private List<VariantsData> variantsData;
        @Expose
        @SerializedName("promos")
        private List<PromosData> promosData;
        @Expose
        @SerializedName("item_id")
        private int item_id;
        @Expose
        @SerializedName("item_merchant_id")
        private int item_merchant_id;
        @Expose
        @SerializedName("item_category_id")
        private int item_category_id;
        @Expose
        @SerializedName("item_unit_id")
        private int item_unit_id;
        @Expose
        @SerializedName("item_name")
        private String item_name;
        @Expose
        @SerializedName("item_description")
        private String item_description;
        @Expose
        @SerializedName("item_sku")
        private String item_sku;
        @Expose
        @SerializedName("item_image")
        private String item_image;
        @Expose
        @SerializedName("item_is_favorite")
        private int item_is_favorite;
        @Expose
        @SerializedName("item_harga_modal")
        private String item_harga_modal;
        @Expose
        @SerializedName("item_harga_jual")
        private String item_harga_jual;
        @Expose
        @SerializedName("item_minimum_price")
        private String item_minimum_price;
        @Expose
        @SerializedName("item_is_parent")
        private int item_is_parent;
        @Expose
        @SerializedName("item_parent_id")
        private int item_parent_id;
        @Expose
        @SerializedName("item_is_cashier_on")
        private int item_is_cashier_on;
        @Expose
        @SerializedName("item_is_changeable_price")
        private int item_is_changeable_price;
        @Expose
        @SerializedName("item_stock_alert_at")
        private String item_stock_alert_at;
        @Expose
        @SerializedName("item_type")
        private int item_type;
        @Expose
        @SerializedName("item_is_disposable")
        private int item_is_disposable;
        @SerializedName("item_created_by")
        private int item_created_by;
        @Expose
        @SerializedName("item_updated_by")
        private int item_updated_by;
        @Expose
        @SerializedName("deleted_at")
        private String deleted_at;
        @Expose
        @SerializedName("item_service_charge")
        private String item_service_charge;
        @Expose
        @SerializedName("item_is_active")
        private int item_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("actual_stock")
        private int actual_stock;
        @Expose
        @SerializedName("item_type_txt")
        private String item_type_txt;
        @Expose
        @SerializedName("category_name_txt")
        private String category_name_txt;
        @SerializedName("note")
        private String note;
        @SerializedName("subtotal")
        private String subtotal;
        @SerializedName("qty")
        private int qty;
        @SerializedName("item_harga_jual_actual")
        private String item_harga_jual_actual;
        @SerializedName("is_promo_available")
        private int is_promo_available;
        @SerializedName("promo_actual_value")
        private String promo_actual_value;


        public UnitData getUnit() {
            return unit;
        }

        public List<VariantsData> getVariantsData() {
            return variantsData;
        }

        public List<PromosData> getPromosData() {
            return promosData;
        }

        public int getItem_id() {
            return item_id;
        }

        public int getItem_merchant_id() {
            return item_merchant_id;
        }

        public int getItem_category_id() {
            return item_category_id;
        }

        public int getItem_unit_id() {
            return item_unit_id;
        }

        public String getItem_name() {
            return item_name;
        }

        public String getItem_description() {
            return item_description;
        }

        public String getItem_sku() {
            return item_sku;
        }

        public String getItem_image() {
            return item_image;
        }

        public int getItem_is_favorite() {
            return item_is_favorite;
        }

        public String getItem_harga_modal() {
            return item_harga_modal;
        }

        public String getItem_harga_jual() {
            return item_harga_jual;
        }

        public void setItem_harga_jual(String item_harga_jual) {
            this.item_harga_jual = item_harga_jual;
        }

        public String getItem_minimum_price() {
            return item_minimum_price;
        }

        public int getItem_is_parent() {
            return item_is_parent;
        }

        public int getItem_parent_id() {
            return item_parent_id;
        }

        public int getItem_is_cashier_on() {
            return item_is_cashier_on;
        }

        public int getItem_is_changeable_price() {
            return item_is_changeable_price;
        }

        public String getItem_stock_alert_at() {
            return item_stock_alert_at;
        }

        public int getItem_type() {
            return item_type;
        }

        public int getItem_created_by() {
            return item_created_by;
        }

        public int getItem_updated_by() {
            return item_updated_by;
        }

        public int getItem_is_active() {
            return item_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public int getActual_stock() {
            return actual_stock;
        }

        public String getItem_type_txt() {
            return item_type_txt;
        }

        public String getCategory_name_txt() {
            return category_name_txt;
        }

        public int getItem_is_disposable() {
            return item_is_disposable;
        }

        public void setItem_is_disposable(int item_is_disposable) {
            this.item_is_disposable = item_is_disposable;
        }

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getItem_service_charge() {
            return item_service_charge;
        }

        public void setItem_service_charge(String item_service_charge) {
            this.item_service_charge = item_service_charge;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getItem_harga_jual_actual() {
            return item_harga_jual_actual;
        }

        public void setItem_harga_jual_actual(String item_harga_jual_actual) {
            this.item_harga_jual_actual = item_harga_jual_actual;
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
    }


    public static class UnitData {
        @Expose
        @SerializedName("unit_id")
        private String unit_id;


        public String getUnit_id() {
            return unit_id;
        }
    }

    public static class VariantsData {
        @Expose
        @SerializedName("detail")
        private List<DetailData> detailData;
        @Expose
        @SerializedName("variant_id")
        private int variant_id;
        @Expose
        @SerializedName("variant_merchant_id")
        private int variant_merchant_id;
        @Expose
        @SerializedName("variant_outlet_id")
        private int variant_outlet_id;
        @Expose
        @SerializedName("variant_name")
        private String variant_name;
        @Expose
        @SerializedName("variant_choose_type")
        private int variant_choose_type;
        @Expose
        @SerializedName("variant_created_by")
        private int variant_created_by;
        @Expose
        @SerializedName("variant_updated_by")
        private int variant_updated_by;
        @Expose
        @SerializedName("variant_is_active")
        private int variant_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;


        public List<DetailData> getDetailData() {
            return detailData;
        }

        public int getVariant_id() {
            return variant_id;
        }

        public int getVariant_merchant_id() {
            return variant_merchant_id;
        }

        public int getVariant_outlet_id() {
            return variant_outlet_id;
        }

        public String getVariant_name() {
            return variant_name;
        }

        public int getVariant_choose_type() {
            return variant_choose_type;
        }

        public int getVariant_created_by() {
            return variant_created_by;
        }

        public int getVariant_updated_by() {
            return variant_updated_by;
        }

        public int getVariant_is_active() {
            return variant_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

    }

    public static class DetailData {
        @Expose
        @SerializedName("variant_detail_id")
        private int variant_detail_id;
        @Expose
        @SerializedName("variant_detail_variant_id")
        private int variant_detail_variant_id;
        @Expose
        @SerializedName("variant_detail_item_id")
        private int variant_detail_item_id;
        @Expose
        @SerializedName("variant_detail_name")
        private String variant_detail_name;
        @Expose
        @SerializedName("variant_detail_harga_modal")
        private String variant_detail_harga_modal;
        @Expose
        @SerializedName("variant_detail_harga_jual")
        private String variant_detail_harga_jual;
        @Expose
        @SerializedName("variant_detail_amount")
        private String variant_detail_amount;
        @Expose
        @SerializedName("variant_detail_is_inventory")
        private int variant_detail_is_inventory;
        @Expose
        @SerializedName("detail_name_txt")
        private String detail_name_txt;

        private boolean isChecked = false;

        public int getVariant_detail_id() {
            return variant_detail_id;
        }

        public int getVariant_detail_variant_id() {
            return variant_detail_variant_id;
        }

        public int getVariant_detail_item_id() {
            return variant_detail_item_id;
        }

        public String getVariant_detail_name() {
            return variant_detail_name;
        }

        public String getVariant_detail_harga_modal() {
            return variant_detail_harga_modal;
        }

        public String getVariant_detail_harga_jual() {
            return variant_detail_harga_jual;
        }

        public String getVariant_detail_amount() {
            return variant_detail_amount;
        }

        public int getVariant_detail_is_inventory() {
            return variant_detail_is_inventory;
        }

        public String getDetail_name_txt() {
            return detail_name_txt;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }
    }


    public static class PromosData {
        @Expose
        @SerializedName("bonus_products")
        private List<BonusProducts> bonusProducts;
        @Expose
        @SerializedName("promo_id")
        private int promo_id;
        @Expose
        @SerializedName("promo_merchant_id")
        private int promo_merchant_id;
        @Expose
        @SerializedName("promo_name")
        private String promo_name;
        @Expose
        @SerializedName("promo_start_date")
        private String promo_start_date;
        @Expose
        @SerializedName("promo_end_date")
        private String promo_end_date;
        @Expose
        @SerializedName("promo_type")
        private int promo_type;
        @Expose
        @SerializedName("promo_bonus_type")
        private int promo_bonus_type;
        @Expose
        @SerializedName("promo_value")
        private String promo_value;
        @Expose
        @SerializedName("promo_base_type")
        private int promo_base_type;
        @Expose
        @SerializedName("promo_min_value")
        private String promo_min_value;
        @Expose
        @SerializedName("promo_is_multiple")
        private int promo_is_multiple;
        @Expose
        @SerializedName("promo_activation")
        private int promo_activation;
        @Expose
        @SerializedName("promo_info")
        private String promo_info;
        @Expose
        @SerializedName("promo_days")
        private String promo_days;
        @Expose
        @SerializedName("promo_created_by")
        private int promo_created_by;
        @Expose
        @SerializedName("promo_updated_by")
        private int promo_updated_by;
        @Expose
        @SerializedName("promo_is_active")
        private int promo_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;


        public List<BonusProducts> getBonusProducts() {
            return bonusProducts;
        }

        public int getPromo_id() {
            return promo_id;
        }

        public int getPromo_merchant_id() {
            return promo_merchant_id;
        }

        public String getPromo_name() {
            return promo_name;
        }

        public String getPromo_start_date() {
            return promo_start_date;
        }

        public String getPromo_end_date() {
            return promo_end_date;
        }

        public int getPromo_type() {
            return promo_type;
        }

        public int getPromo_bonus_type() {
            return promo_bonus_type;
        }

        public String getPromo_value() {
            return promo_value;
        }

        public int getPromo_base_type() {
            return promo_base_type;
        }

        public String getPromo_min_value() {
            return promo_min_value;
        }

        public int getPromo_is_multiple() {
            return promo_is_multiple;
        }

        public int getPromo_activation() {
            return promo_activation;
        }

        public String getPromo_info() {
            return promo_info;
        }

        public String getPromo_days() {
            return promo_days;
        }

        public int getPromo_created_by() {
            return promo_created_by;
        }

        public int getPromo_updated_by() {
            return promo_updated_by;
        }

        public int getPromo_is_active() {
            return promo_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

    }


    public static class BonusProducts {
        @Expose
        @SerializedName("item_id")
        private int item_id;
        @Expose
        @SerializedName("item_merchant_id")
        private int item_merchant_id;
        @Expose
        @SerializedName("item_category_id")
        private int item_category_id;
        @Expose
        @SerializedName("item_unit_id")
        private int item_unit_id;
        @Expose
        @SerializedName("item_name")
        private String item_name;
        @Expose
        @SerializedName("item_description")
        private String item_description;
        @Expose
        @SerializedName("item_sku")
        private String item_sku;
        @Expose
        @SerializedName("item_image")
        private String item_image;
        @Expose
        @SerializedName("item_is_favorite")
        private int item_is_favorite;
        @Expose
        @SerializedName("item_harga_modal")
        private String item_harga_modal;
        @Expose
        @SerializedName("item_harga_jual")
        private String item_harga_jual;
        @Expose
        @SerializedName("item_minimum_price")
        private String item_minimum_price;
        @Expose
        @SerializedName("item_is_parent")
        private int item_is_parent;
        @Expose
        @SerializedName("item_parent_id")
        private int item_parent_id;
        @Expose
        @SerializedName("item_is_cashier_on")
        private int item_is_cashier_on;
        @Expose
        @SerializedName("item_is_changeable_price")
        private int item_is_changeable_price;
        @Expose
        @SerializedName("item_stock_alert_at")
        private String item_stock_alert_at;
        @Expose
        @SerializedName("item_type")
        private int item_type;
        @Expose
        @SerializedName("item_created_by")
        private int item_created_by;
        @Expose
        @SerializedName("item_updated_by")
        private int item_updated_by;
        @Expose
        @SerializedName("item_is_active")
        private int item_is_active;
        @Expose
        @SerializedName("created_at")
        private String created_at;
        @Expose
        @SerializedName("updated_at")
        private String updated_at;
        @Expose
        @SerializedName("actual_stock")
        private int actual_stock;
        @Expose
        @SerializedName("item_type_txt")
        private String item_type_txt;
        @Expose
        @SerializedName("category_name_txt")
        private String category_name_txt;


        public int getItem_id() {
            return item_id;
        }

        public int getItem_merchant_id() {
            return item_merchant_id;
        }

        public int getItem_category_id() {
            return item_category_id;
        }

        public int getItem_unit_id() {
            return item_unit_id;
        }

        public String getItem_name() {
            return item_name;
        }

        public String getItem_description() {
            return item_description;
        }

        public String getItem_sku() {
            return item_sku;
        }

        public String getItem_image() {
            return item_image;
        }

        public int getItem_is_favorite() {
            return item_is_favorite;
        }

        public String getItem_harga_modal() {
            return item_harga_modal;
        }

        public String getItem_harga_jual() {
            return item_harga_jual;
        }

        public String getItem_minimum_price() {
            return item_minimum_price;
        }

        public int getItem_is_parent() {
            return item_is_parent;
        }

        public int getItem_parent_id() {
            return item_parent_id;
        }

        public int getItem_is_cashier_on() {
            return item_is_cashier_on;
        }

        public int getItem_is_changeable_price() {
            return item_is_changeable_price;
        }

        public String getItem_stock_alert_at() {
            return item_stock_alert_at;
        }

        public int getItem_type() {
            return item_type;
        }

        public int getItem_created_by() {
            return item_created_by;
        }

        public int getItem_updated_by() {
            return item_updated_by;
        }

        public int getItem_is_active() {
            return item_is_active;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public int getActual_stock() {
            return actual_stock;
        }

        public String getItem_type_txt() {
            return item_type_txt;
        }

        public String getCategory_name_txt() {
            return category_name_txt;
        }

    }
}
