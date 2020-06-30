package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetOrderByReservation {

    @SerializedName("DATA")
    private DATAReservation DATAReservation;
    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("STATUS")
    private int STATUS;

    public DATAReservation getDATAReservation() {
        return DATAReservation;
    }

    public void setDATAReservation(DATAReservation DATAReservation) {
        this.DATAReservation = DATAReservation;
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

    public static class DATAReservation {

        @SerializedName("trans_id")
        private int trans_id;
        @SerializedName("trans_code")
        private String trans_code;
        @SerializedName("trans_merchant_id")
        private int trans_merchant_id;
        @SerializedName("trans_outlet_id")
        private int trans_outlet_id;
        @SerializedName("trans_customer_id")
        private int trans_customer_id;
        @SerializedName("trans_table_id")
        private int trans_table_id;
        @SerializedName("trans_reservation_id")
        private int trans_reservation_id;
        @SerializedName("trans_subtotal")
        private String trans_subtotal;
        @SerializedName("trans_tax_type")
        private String trans_tax_type;
        @SerializedName("trans_tax_value")
        private String trans_tax_value;
        @SerializedName("trans_discount_type")
        private String trans_discount_type;
        @SerializedName("trans_discount_value")
        private String trans_discount_value;
        @SerializedName("trans_total")
        private String trans_total;
        @SerializedName("trans_service_charge")
        private String trans_service_charge;
        @SerializedName("trans_additional_fee")
        private String trans_additional_fee;
        @SerializedName("trans_total_guest")
        private int trans_total_guest;
        @SerializedName("trans_payment_method_id")
        private int trans_payment_method_id;
        @SerializedName("trans_sessid")
        private String trans_sessid;
        @SerializedName("trans_cashier_id")
        private int trans_cashier_id;
        @SerializedName("trans_created_by")
        private int trans_created_by;
        @SerializedName("trans_updated_by")
        private int trans_updated_by;
        @SerializedName("trans_date")
        private String trans_date;
        @SerializedName("trans_paid_date")
        private String trans_paid_date;
        @SerializedName("trans_info")
        private String trans_info;
        @SerializedName("trans_order_type")
        private int trans_order_type;
        @SerializedName("trans_status")
        private int trans_status;
        @SerializedName("created_at")
        private String created_at;
        @SerializedName("updated_at")
        private String updated_at;
        @SerializedName("service_charge_value")
        private String service_charge_value;
        @SerializedName("status_txt")
        private String status_txt;
        @SerializedName("cashier_name")
        private String cashier_name;
        @SerializedName("order_type_name")
        private String order_type_name;
        @SerializedName("payment_method_name")
        private String payment_method_name;
        @SerializedName("customer_name")
        private String customer_name;
        @SerializedName("customer")
        private CustomerReservation customerReservation;
        @SerializedName("table")
        private TableReservation tableReservation;
        @SerializedName("transaction_items")
        private List<TransactionItemsReservation> transactionItemsReservations;


        public int getTrans_id() {
            return trans_id;
        }

        public void setTrans_id(int trans_id) {
            this.trans_id = trans_id;
        }

        public String getTrans_code() {
            return trans_code;
        }

        public void setTrans_code(String trans_code) {
            this.trans_code = trans_code;
        }

        public int getTrans_merchant_id() {
            return trans_merchant_id;
        }

        public void setTrans_merchant_id(int trans_merchant_id) {
            this.trans_merchant_id = trans_merchant_id;
        }

        public int getTrans_outlet_id() {
            return trans_outlet_id;
        }

        public void setTrans_outlet_id(int trans_outlet_id) {
            this.trans_outlet_id = trans_outlet_id;
        }

        public int getTrans_customer_id() {
            return trans_customer_id;
        }

        public void setTrans_customer_id(int trans_customer_id) {
            this.trans_customer_id = trans_customer_id;
        }

        public int getTrans_table_id() {
            return trans_table_id;
        }

        public void setTrans_table_id(int trans_table_id) {
            this.trans_table_id = trans_table_id;
        }

        public int getTrans_reservation_id() {
            return trans_reservation_id;
        }

        public void setTrans_reservation_id(int trans_reservation_id) {
            this.trans_reservation_id = trans_reservation_id;
        }

        public String getTrans_subtotal() {
            return trans_subtotal;
        }

        public void setTrans_subtotal(String trans_subtotal) {
            this.trans_subtotal = trans_subtotal;
        }

        public String getTrans_tax_type() {
            return trans_tax_type;
        }

        public void setTrans_tax_type(String trans_tax_type) {
            this.trans_tax_type = trans_tax_type;
        }

        public String getTrans_tax_value() {
            return trans_tax_value;
        }

        public void setTrans_tax_value(String trans_tax_value) {
            this.trans_tax_value = trans_tax_value;
        }

        public String getTrans_discount_type() {
            return trans_discount_type;
        }

        public void setTrans_discount_type(String trans_discount_type) {
            this.trans_discount_type = trans_discount_type;
        }

        public String getTrans_discount_value() {
            return trans_discount_value;
        }

        public void setTrans_discount_value(String trans_discount_value) {
            this.trans_discount_value = trans_discount_value;
        }

        public String getTrans_total() {
            return trans_total;
        }

        public void setTrans_total(String trans_total) {
            this.trans_total = trans_total;
        }

        public String getTrans_service_charge() {
            return trans_service_charge;
        }

        public void setTrans_service_charge(String trans_service_charge) {
            this.trans_service_charge = trans_service_charge;
        }

        public String getTrans_additional_fee() {
            return trans_additional_fee;
        }

        public void setTrans_additional_fee(String trans_additional_fee) {
            this.trans_additional_fee = trans_additional_fee;
        }

        public int getTrans_total_guest() {
            return trans_total_guest;
        }

        public void setTrans_total_guest(int trans_total_guest) {
            this.trans_total_guest = trans_total_guest;
        }

        public int getTrans_payment_method_id() {
            return trans_payment_method_id;
        }

        public void setTrans_payment_method_id(int trans_payment_method_id) {
            this.trans_payment_method_id = trans_payment_method_id;
        }

        public String getTrans_sessid() {
            return trans_sessid;
        }

        public void setTrans_sessid(String trans_sessid) {
            this.trans_sessid = trans_sessid;
        }

        public int getTrans_cashier_id() {
            return trans_cashier_id;
        }

        public void setTrans_cashier_id(int trans_cashier_id) {
            this.trans_cashier_id = trans_cashier_id;
        }

        public int getTrans_created_by() {
            return trans_created_by;
        }

        public void setTrans_created_by(int trans_created_by) {
            this.trans_created_by = trans_created_by;
        }

        public int getTrans_updated_by() {
            return trans_updated_by;
        }

        public void setTrans_updated_by(int trans_updated_by) {
            this.trans_updated_by = trans_updated_by;
        }

        public String getTrans_date() {
            return trans_date;
        }

        public void setTrans_date(String trans_date) {
            this.trans_date = trans_date;
        }

        public String getTrans_paid_date() {
            return trans_paid_date;
        }

        public void setTrans_paid_date(String trans_paid_date) {
            this.trans_paid_date = trans_paid_date;
        }

        public String getTrans_info() {
            return trans_info;
        }

        public void setTrans_info(String trans_info) {
            this.trans_info = trans_info;
        }

        public int getTrans_order_type() {
            return trans_order_type;
        }

        public void setTrans_order_type(int trans_order_type) {
            this.trans_order_type = trans_order_type;
        }

        public int getTrans_status() {
            return trans_status;
        }

        public void setTrans_status(int trans_status) {
            this.trans_status = trans_status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getService_charge_value() {
            return service_charge_value;
        }

        public void setService_charge_value(String service_charge_value) {
            this.service_charge_value = service_charge_value;
        }

        public String getStatus_txt() {
            return status_txt;
        }

        public void setStatus_txt(String status_txt) {
            this.status_txt = status_txt;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public String getOrder_type_name() {
            return order_type_name;
        }

        public void setOrder_type_name(String order_type_name) {
            this.order_type_name = order_type_name;
        }

        public String getPayment_method_name() {
            return payment_method_name;
        }

        public void setPayment_method_name(String payment_method_name) {
            this.payment_method_name = payment_method_name;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public CustomerReservation getCustomerReservation() {
            return customerReservation;
        }

        public void setCustomerReservation(CustomerReservation customerReservation) {
            this.customerReservation = customerReservation;
        }

        public TableReservation getTableReservation() {
            return tableReservation;
        }

        public void setTableReservation(TableReservation tableReservation) {
            this.tableReservation = tableReservation;
        }

        public List<TransactionItemsReservation> getTransactionItemsReservations() {
            return transactionItemsReservations;
        }

        public void setTransactionItemsReservations(List<TransactionItemsReservation> transactionItemsReservations) {
            this.transactionItemsReservations = transactionItemsReservations;
        }

        public static class CustomerReservation {
            @SerializedName("cust_id")
            private int cust_id;

            public int getCust_id() {
                return cust_id;
            }

            public void setCust_id(int cust_id) {
                this.cust_id = cust_id;
            }
        }

        public static class TableReservation {
            @SerializedName("table_id")
            private int table_id;

            public int getTable_id() {
                return table_id;
            }

            public void setTable_id(int table_id) {
                this.table_id = table_id;
            }
        }


        public static class TransactionItemsReservation {

            @SerializedName("tr_item_transaction_id")
            private int tr_item_transaction_id;
            @SerializedName("tr_item_id")
            private int tr_item_id;
            @SerializedName("tr_item_variant_id")
            private int tr_item_variant_id;
            @SerializedName("tr_item_actual_price")
            private String tr_item_actual_price;
            @SerializedName("tr_item_qty")
            private String tr_item_qty;
            @SerializedName("tr_item_additional_price")
            private String tr_item_additional_price;
            @SerializedName("tr_item_service_charge")
            private String tr_item_service_charge;
            @SerializedName("tr_item_total_price")
            private String tr_item_total_price;
            @SerializedName("tr_item_harga_modal")
            private String tr_item_harga_modal;
            @SerializedName("tr_item_harga_modal_total")
            private String tr_item_harga_modal_total;
            @SerializedName("tr_item_tax_type")
            private String tr_item_tax_type;
            @SerializedName("tr_item_tax_value")
            private String tr_item_tax_value;
            @SerializedName("tr_item_discount_type")
            private String tr_item_discount_type;
            @SerializedName("tr_item_discount_value")
            private String tr_item_discount_value;
            @SerializedName("tr_item_info")
            private String tr_item_info;
            @SerializedName("tr_item_harga_jual_actual")
            private String tr_item_harga_jual_actual;
            @SerializedName("detail_item")
            private DetailNameReservation detailNameReservation;
            @SerializedName("variants")
            private List<VariantsReservation> variantsReservations;


            public int getTr_item_transaction_id() {
                return tr_item_transaction_id;
            }

            public void setTr_item_transaction_id(int tr_item_transaction_id) {
                this.tr_item_transaction_id = tr_item_transaction_id;
            }

            public int getTr_item_id() {
                return tr_item_id;
            }

            public void setTr_item_id(int tr_item_id) {
                this.tr_item_id = tr_item_id;
            }

            public int getTr_item_variant_id() {
                return tr_item_variant_id;
            }

            public void setTr_item_variant_id(int tr_item_variant_id) {
                this.tr_item_variant_id = tr_item_variant_id;
            }

            public String getTr_item_actual_price() {
                return tr_item_actual_price;
            }


            public void setTr_item_actual_price(String tr_item_actual_price) {
                this.tr_item_actual_price = tr_item_actual_price;
            }

            public String getTr_item_qty() {
                return tr_item_qty;
            }

            public void setTr_item_qty(String tr_item_qty) {
                this.tr_item_qty = tr_item_qty;
            }

            public String getTr_item_additional_price() {
                return tr_item_additional_price;
            }

            public void setTr_item_additional_price(String tr_item_additional_price) {
                this.tr_item_additional_price = tr_item_additional_price;
            }

            public String getTr_item_service_charge() {
                return tr_item_service_charge;
            }

            public void setTr_item_service_charge(String tr_item_service_charge) {
                this.tr_item_service_charge = tr_item_service_charge;
            }

            public String getTr_item_total_price() {
                return tr_item_total_price;
            }

            public void setTr_item_total_price(String tr_item_total_price) {
                this.tr_item_total_price = tr_item_total_price;
            }

            public String getTr_item_harga_modal() {
                return tr_item_harga_modal;
            }

            public void setTr_item_harga_modal(String tr_item_harga_modal) {
                this.tr_item_harga_modal = tr_item_harga_modal;
            }

            public String getTr_item_harga_modal_total() {
                return tr_item_harga_modal_total;
            }

            public void setTr_item_harga_modal_total(String tr_item_harga_modal_total) {
                this.tr_item_harga_modal_total = tr_item_harga_modal_total;
            }

            public String getTr_item_tax_type() {
                return tr_item_tax_type;
            }

            public void setTr_item_tax_type(String tr_item_tax_type) {
                this.tr_item_tax_type = tr_item_tax_type;
            }

            public String getTr_item_tax_value() {
                return tr_item_tax_value;
            }

            public void setTr_item_tax_value(String tr_item_tax_value) {
                this.tr_item_tax_value = tr_item_tax_value;
            }

            public String getTr_item_discount_type() {
                return tr_item_discount_type;
            }

            public void setTr_item_discount_type(String tr_item_discount_type) {
                this.tr_item_discount_type = tr_item_discount_type;
            }

            public String getTr_item_discount_value() {
                return tr_item_discount_value;
            }

            public void setTr_item_discount_value(String tr_item_discount_value) {
                this.tr_item_discount_value = tr_item_discount_value;
            }

            public String getTr_item_info() {
                return tr_item_info;
            }

            public void setTr_item_info(String tr_item_info) {
                this.tr_item_info = tr_item_info;
            }

            public String getTr_item_harga_jual_actual() {
                return tr_item_harga_jual_actual;
            }

            public void setTr_item_harga_jual_actual(String tr_item_harga_jual_actual) {
                this.tr_item_harga_jual_actual = tr_item_harga_jual_actual;
            }

            public DetailNameReservation getDetailNameReservation() {
                return detailNameReservation;
            }

            public void setDetailNameReservation(DetailNameReservation detailNameReservation) {
                this.detailNameReservation = detailNameReservation;
            }

            public List<VariantsReservation> getVariantsReservations() {
                return variantsReservations;
            }

            public void setVariantsReservations(List<VariantsReservation> variantsReservations) {
                this.variantsReservations = variantsReservations;
            }


            public static class DetailNameReservation {

                @SerializedName("item_id")
                private int item_id;
                @SerializedName("item_merchant_id")
                private int item_merchant_id;
                @SerializedName("item_category_id")
                private int item_category_id;
                @SerializedName("item_unit_id")
                private int item_unit_id;
                @SerializedName("item_name")
                private String item_name;
                @SerializedName("item_description")
                private String item_description;
                @SerializedName("item_sku")
                private String item_sku;
                @SerializedName("item_image")
                private String item_image;
                @SerializedName("item_is_favorite")
                private int item_is_favorite;
                @SerializedName("item_harga_modal")
                private String item_harga_modal;
                @SerializedName("item_harga_jual")
                private String item_harga_jual;
                @SerializedName("item_minimum_price")
                private String item_minimum_price;
                @SerializedName("item_is_parent")
                private int item_is_parent;
                @SerializedName("item_parent_id")
                private int item_parent_id;
                @SerializedName("item_is_cashier_on")
                private int item_is_cashier_on;
                @SerializedName("item_is_changeable_price")
                private int item_is_changeable_price;
                @SerializedName("item_stock_alert_at")
                private String item_stock_alert_at;
                @SerializedName("item_type")
                private int item_type;
                @SerializedName("item_is_disposable")
                private int item_is_disposable;
                @SerializedName("item_created_by")
                private int item_created_by;
                @SerializedName("item_updated_by")
                private int item_updated_by;
                @SerializedName("item_is_active")
                private int item_is_active;
                @SerializedName("created_at")
                private String created_at;
                @SerializedName("updated_at")
                private String updated_at;
                @SerializedName("deleted_at")
                private String deleted_at;


                public int getItem_id() {
                    return item_id;
                }

                public void setItem_id(int item_id) {
                    this.item_id = item_id;
                }

                public int getItem_merchant_id() {
                    return item_merchant_id;
                }

                public void setItem_merchant_id(int item_merchant_id) {
                    this.item_merchant_id = item_merchant_id;
                }

                public int getItem_category_id() {
                    return item_category_id;
                }

                public void setItem_category_id(int item_category_id) {
                    this.item_category_id = item_category_id;
                }

                public int getItem_unit_id() {
                    return item_unit_id;
                }

                public void setItem_unit_id(int item_unit_id) {
                    this.item_unit_id = item_unit_id;
                }

                public String getItem_name() {
                    return item_name;
                }

                public void setItem_name(String item_name) {
                    this.item_name = item_name;
                }

                public String getItem_description() {
                    return item_description;
                }

                public void setItem_description(String item_description) {
                    this.item_description = item_description;
                }

                public String getItem_sku() {
                    return item_sku;
                }

                public void setItem_sku(String item_sku) {
                    this.item_sku = item_sku;
                }

                public String getItem_image() {
                    return item_image;
                }

                public void setItem_image(String item_image) {
                    this.item_image = item_image;
                }

                public int getItem_is_favorite() {
                    return item_is_favorite;
                }

                public void setItem_is_favorite(int item_is_favorite) {
                    this.item_is_favorite = item_is_favorite;
                }

                public String getItem_harga_modal() {
                    return item_harga_modal;
                }

                public void setItem_harga_modal(String item_harga_modal) {
                    this.item_harga_modal = item_harga_modal;
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

                public void setItem_minimum_price(String item_minimum_price) {
                    this.item_minimum_price = item_minimum_price;
                }

                public int getItem_is_parent() {
                    return item_is_parent;
                }

                public void setItem_is_parent(int item_is_parent) {
                    this.item_is_parent = item_is_parent;
                }

                public int getItem_parent_id() {
                    return item_parent_id;
                }

                public void setItem_parent_id(int item_parent_id) {
                    this.item_parent_id = item_parent_id;
                }

                public int getItem_is_cashier_on() {
                    return item_is_cashier_on;
                }

                public void setItem_is_cashier_on(int item_is_cashier_on) {
                    this.item_is_cashier_on = item_is_cashier_on;
                }

                public int getItem_is_changeable_price() {
                    return item_is_changeable_price;
                }

                public void setItem_is_changeable_price(int item_is_changeable_price) {
                    this.item_is_changeable_price = item_is_changeable_price;
                }

                public String getItem_stock_alert_at() {
                    return item_stock_alert_at;
                }

                public void setItem_stock_alert_at(String item_stock_alert_at) {
                    this.item_stock_alert_at = item_stock_alert_at;
                }

                public int getItem_type() {
                    return item_type;
                }

                public void setItem_type(int item_type) {
                    this.item_type = item_type;
                }

                public int getItem_is_disposable() {
                    return item_is_disposable;
                }

                public void setItem_is_disposable(int item_is_disposable) {
                    this.item_is_disposable = item_is_disposable;
                }

                public int getItem_created_by() {
                    return item_created_by;
                }

                public void setItem_created_by(int item_created_by) {
                    this.item_created_by = item_created_by;
                }

                public int getItem_updated_by() {
                    return item_updated_by;
                }

                public void setItem_updated_by(int item_updated_by) {
                    this.item_updated_by = item_updated_by;
                }

                public int getItem_is_active() {
                    return item_is_active;
                }

                public void setItem_is_active(int item_is_active) {
                    this.item_is_active = item_is_active;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }

                public String getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(String deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }

            public static class VariantsReservation {

                @SerializedName("tr_variant_transaction_id")
                private int tr_variant_transaction_id;
                @SerializedName("tr_variant_item_id")
                private int tr_variant_item_id;
                @SerializedName("tr_variant_variant_id")
                private int tr_variant_variant_id;
                @SerializedName("tr_variant_actual_price")
                private String tr_variant_actual_price;
                @SerializedName("tr_variant_qty")
                private String tr_variant_qty;
                @SerializedName("tr_variant_additional_price")
                private String tr_variant_additional_price;
                @SerializedName("tr_variant_total_price")
                private String tr_variant_total_price;
                @SerializedName("tr_variant_harga_modal")
                private String tr_variant_harga_modal;
                @SerializedName("tr_variant_harga_modal_total")
                private String tr_variant_harga_modal_total;
                @SerializedName("tr_variant_tax_type")
                private String tr_variant_tax_type;
                @SerializedName("tr_variant_tax_value")
                private String tr_variant_tax_value;
                @SerializedName("tr_variant_discount_type")
                private String tr_variant_discount_type;
                @SerializedName("tr_variant_discount_value")
                private String tr_variant_discount_value;
                @SerializedName("tr_variant_info")
                private String tr_variant_info;
                @SerializedName("item")
                private ItemReservation itemReservation;

                public int getTr_variant_transaction_id() {
                    return tr_variant_transaction_id;
                }

                public void setTr_variant_transaction_id(int tr_variant_transaction_id) {
                    this.tr_variant_transaction_id = tr_variant_transaction_id;
                }

                public int getTr_variant_item_id() {
                    return tr_variant_item_id;
                }

                public void setTr_variant_item_id(int tr_variant_item_id) {
                    this.tr_variant_item_id = tr_variant_item_id;
                }

                public int getTr_variant_variant_id() {
                    return tr_variant_variant_id;
                }

                public void setTr_variant_variant_id(int tr_variant_variant_id) {
                    this.tr_variant_variant_id = tr_variant_variant_id;
                }

                public String getTr_variant_actual_price() {
                    return tr_variant_actual_price;
                }

                public void setTr_variant_actual_price(String tr_variant_actual_price) {
                    this.tr_variant_actual_price = tr_variant_actual_price;
                }

                public String getTr_variant_qty() {
                    return tr_variant_qty;
                }

                public void setTr_variant_qty(String tr_variant_qty) {
                    this.tr_variant_qty = tr_variant_qty;
                }

                public String getTr_variant_additional_price() {
                    return tr_variant_additional_price;
                }

                public void setTr_variant_additional_price(String tr_variant_additional_price) {
                    this.tr_variant_additional_price = tr_variant_additional_price;
                }

                public String getTr_variant_total_price() {
                    return tr_variant_total_price;
                }

                public void setTr_variant_total_price(String tr_variant_total_price) {
                    this.tr_variant_total_price = tr_variant_total_price;
                }

                public String getTr_variant_harga_modal() {
                    return tr_variant_harga_modal;
                }

                public void setTr_variant_harga_modal(String tr_variant_harga_modal) {
                    this.tr_variant_harga_modal = tr_variant_harga_modal;
                }

                public String getTr_variant_harga_modal_total() {
                    return tr_variant_harga_modal_total;
                }

                public void setTr_variant_harga_modal_total(String tr_variant_harga_modal_total) {
                    this.tr_variant_harga_modal_total = tr_variant_harga_modal_total;
                }

                public String getTr_variant_tax_type() {
                    return tr_variant_tax_type;
                }

                public void setTr_variant_tax_type(String tr_variant_tax_type) {
                    this.tr_variant_tax_type = tr_variant_tax_type;
                }

                public String getTr_variant_tax_value() {
                    return tr_variant_tax_value;
                }

                public void setTr_variant_tax_value(String tr_variant_tax_value) {
                    this.tr_variant_tax_value = tr_variant_tax_value;
                }

                public String getTr_variant_discount_type() {
                    return tr_variant_discount_type;
                }

                public void setTr_variant_discount_type(String tr_variant_discount_type) {
                    this.tr_variant_discount_type = tr_variant_discount_type;
                }

                public String getTr_variant_discount_value() {
                    return tr_variant_discount_value;
                }

                public void setTr_variant_discount_value(String tr_variant_discount_value) {
                    this.tr_variant_discount_value = tr_variant_discount_value;
                }

                public String getTr_variant_info() {
                    return tr_variant_info;
                }

                public void setTr_variant_info(String tr_variant_info) {
                    this.tr_variant_info = tr_variant_info;
                }

                public ItemReservation getItemReservation() {
                    return itemReservation;
                }

                public void setItemReservation(ItemReservation itemReservation) {
                    this.itemReservation = itemReservation;
                }

                public static class ItemReservation {

                    @SerializedName("variant_detail_id")
                    private int variant_detail_id;
                    @SerializedName("variant_detail_variant_id")
                    private int variant_detail_variant_id;
                    @SerializedName("variant_detail_item_id")
                    private int variant_detail_item_id;
                    @SerializedName("variant_detail_name")
                    private String variant_detail_name;
                    @SerializedName("variant_detail_harga_modal")
                    private String variant_detail_harga_modal;
                    @SerializedName("variant_detail_harga_jual")
                    private String variant_detail_harga_jual;
                    @SerializedName("variant_detail_amount")
                    private String variant_detail_amount;
                    @SerializedName("variant_detail_is_inventory")
                    private int variant_detail_is_inventory;
                    @SerializedName("detail_name_txt")
                    private String detail_name_txt;


                    public int getVariant_detail_id() {
                        return variant_detail_id;
                    }

                    public void setVariant_detail_id(int variant_detail_id) {
                        this.variant_detail_id = variant_detail_id;
                    }

                    public int getVariant_detail_variant_id() {
                        return variant_detail_variant_id;
                    }

                    public void setVariant_detail_variant_id(int variant_detail_variant_id) {
                        this.variant_detail_variant_id = variant_detail_variant_id;
                    }

                    public int getVariant_detail_item_id() {
                        return variant_detail_item_id;
                    }

                    public void setVariant_detail_item_id(int variant_detail_item_id) {
                        this.variant_detail_item_id = variant_detail_item_id;
                    }

                    public String getVariant_detail_name() {
                        return variant_detail_name;
                    }

                    public void setVariant_detail_name(String variant_detail_name) {
                        this.variant_detail_name = variant_detail_name;
                    }

                    public String getVariant_detail_harga_modal() {
                        return variant_detail_harga_modal;
                    }

                    public void setVariant_detail_harga_modal(String variant_detail_harga_modal) {
                        this.variant_detail_harga_modal = variant_detail_harga_modal;
                    }

                    public String getVariant_detail_harga_jual() {
                        return variant_detail_harga_jual;
                    }

                    public void setVariant_detail_harga_jual(String variant_detail_harga_jual) {
                        this.variant_detail_harga_jual = variant_detail_harga_jual;
                    }

                    public String getVariant_detail_amount() {
                        return variant_detail_amount;
                    }

                    public void setVariant_detail_amount(String variant_detail_amount) {
                        this.variant_detail_amount = variant_detail_amount;
                    }

                    public int getVariant_detail_is_inventory() {
                        return variant_detail_is_inventory;
                    }

                    public void setVariant_detail_is_inventory(int variant_detail_is_inventory) {
                        this.variant_detail_is_inventory = variant_detail_is_inventory;
                    }

                    public String getDetail_name_txt() {
                        return detail_name_txt;
                    }

                    public void setDetail_name_txt(String detail_name_txt) {
                        this.detail_name_txt = detail_name_txt;
                    }
                }
            }
        }
    }
}
