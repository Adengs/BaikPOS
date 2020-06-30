package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ParamCreateOrder {

    @Expose
    @SerializedName("items")
    private List<ItemsOrder> itemsOrders;
    @Expose
    @SerializedName("invoice_no")
    private String invoice_no;
    @Expose
    @SerializedName("customer_id")
    private int customer_id = 0;
    @Expose
    @SerializedName("table_id")
    private int table_id;
    @Expose
    @SerializedName("total_paid")
    private String total_paid;
    @Expose
    @SerializedName("total_discount")
    private String total_discount;
    @Expose
    @SerializedName("total_tax")
    private String total_tax;
    @Expose
    @SerializedName("trans_status")
    private String trans_status;
    @Expose
    @SerializedName("reservation_id")
    private int reservation_id = 0;
    @Expose
    @SerializedName("served_by")
    private List<Integer> served_by = new ArrayList<>();
    @Expose
    @SerializedName("service_charge")
    private String service_charge = 0 + "";
    @Expose
    @SerializedName("order_type")
    private String order_type;
    @Expose
    @SerializedName("total_guest")
    private String total_guest;
    @Expose
    @SerializedName("arrival_date")
    private String arrivalDateRes;
    @Expose
    @SerializedName("arrival_time")
    private String arrivalTimeRes;
    @Expose
    @SerializedName("merge_tables")
    private int mergeTablesRes;
    @Expose
    @SerializedName("number_of_people")
    private int numberOfPeopleRes;
    @Expose
    @SerializedName("note")
    private String noteRes;
    @Expose
    @SerializedName("status")
    private int statusRes;
    @Expose
    @SerializedName("is_reservation")
    private int isReservationRes;
    @Expose
    @SerializedName("tables")
    private List<ParamCreateReservation.Table> tables;
    @Expose
    @SerializedName("order_type_name")
    private String orderTypeName;
    @Expose
    @SerializedName("customer_name")
    private String customerName;
    @Expose
    @SerializedName("cashier_name")
    private String cashierName;


    public List<ItemsOrder> getItemsOrders() {
        return itemsOrders;
    }

    public void setItemsOrders(List<ItemsOrder> itemsOrders) {
        this.itemsOrders = itemsOrders;
    }


    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(String total_paid) {
        this.total_paid = total_paid;
    }

    public String getTrans_status() {
        return trans_status;
    }

    public void setTotal_discount(String total_discount) {
        this.total_discount = total_discount;
    }

    public String getTotal_discount() {
        return total_discount;
    }

    public void setTotal_tax(String total_tax) {
        this.total_tax = total_tax;
    }

    public String getTotal_tax() {
        return total_tax;
    }

    public void setTrans_status(String trans_status) {
        this.trans_status = trans_status;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getService_charge() {
        return service_charge;
    }

    public void setService_charge(String service_charge) {
        this.service_charge = service_charge;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getTotal_guest() {
        return total_guest;
    }

    public void setTotal_guest(String total_guest) {
        this.total_guest = total_guest;
    }

    public List<Integer> getServed_by() {
        return served_by;
    }

    public void setServed_by(int served_by) {
        this.served_by.add(served_by);
    }

    public String getArrivalDateRes() {
        return arrivalDateRes;
    }

    public void setArrivalDateRes(String arrivalDateRes) {
        this.arrivalDateRes = arrivalDateRes;
    }

    public String getArrivalTimeRes() {
        return arrivalTimeRes;
    }

    public void setArrivalTimeRes(String arrivalTimeRes) {
        this.arrivalTimeRes = arrivalTimeRes;
    }

    public int getMergeTablesRes() {
        return mergeTablesRes;
    }

    public void setMergeTablesRes(int mergeTablesRes) {
        this.mergeTablesRes = mergeTablesRes;
    }

    public int getNumberOfPeopleRes() {
        return numberOfPeopleRes;
    }

    public void setNumberOfPeopleRes(int numberOfPeopleRes) {
        this.numberOfPeopleRes = numberOfPeopleRes;
    }

    public String getNoteRes() {
        return noteRes;
    }

    public void setNoteRes(String noteRes) {
        this.noteRes = noteRes;
    }

    public int getStatusRes() {
        return statusRes;
    }

    public void setStatusRes(int statusRes) {
        this.statusRes = statusRes;
    }

    public int getIsReservationRes() {
        return isReservationRes;
    }

    public void setIsReservationRes(int isReservationRes) {
        this.isReservationRes = isReservationRes;
    }

    public List<ParamCreateReservation.Table> getTables() {
        return tables;
    }

    public void setTables(List<ParamCreateReservation.Table> tables) {
        this.tables = tables;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }


    public static class ItemsOrder {
        @Expose
        @SerializedName("variants")
        private List<ItemsVariants> itemsVariants;
        @Expose
        @SerializedName("id")
        private int id;
        @Expose
        @SerializedName("harga_modal")
        private String harga_modal;
        @Expose
        @SerializedName("actual_price")
        private String actual_price;
        @Expose
        @SerializedName("qty")
        private int qty;
        @Expose
        @SerializedName("info")
        private String note;
        @Expose
        @SerializedName("total_price")
        private String total_price;
        @Expose
        @SerializedName("service_charge")
        private String service_charge;
        @Expose
        @SerializedName("discount")
        private String discount;
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("unit")
        private String unit;
        @Expose
        @SerializedName("image")
        private String image;
        @Expose
        @SerializedName("category_id")
        private int category_id;
        @Expose
        @SerializedName("category_name")
        private String category_name;


        public List<ItemsVariants> getItemsVariants() {
            return itemsVariants;
        }

        public void setItemsVariants(List<ItemsVariants> itemsVariants) {
            this.itemsVariants = itemsVariants;
        }

        public ItemsOrder(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHarga_modal() {
            return harga_modal;
        }

        public void setHarga_modal(String harga_modal) {
            this.harga_modal = harga_modal;
        }

        public String getActual_price() {
            return actual_price;
        }

        public void setActual_price(String actual_price) {
            this.actual_price = actual_price;
        }

        public String getService_charge() {
            return service_charge;
        }

        public void setService_charge(String service_charge) {
            this.service_charge = service_charge;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public static class ItemsVariants {

            @Expose
            @SerializedName("id")
            private int id;
            @Expose
            @SerializedName("harga_modal")
            private String harga_modal;
            @Expose
            @SerializedName("actual_price")
            private String actual_price;
            @Expose
            @SerializedName("total_price")
            private String total_price;
            @Expose
            @SerializedName("is_inventory")
            private int is_inventory;
            @Expose
            @SerializedName("name")
            private String name;
            @Expose
            @SerializedName("unit")
            private int unit;
            @Expose
            @SerializedName("image")
            private String image;
            @Expose
            @SerializedName("item_name")
            private String item_name;


            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getHarga_modal() {
                return harga_modal;
            }

            public void setHarga_modal(String harga_modal) {
                this.harga_modal = harga_modal;
            }

            public String getTotal_price() {
                return total_price;
            }

            public void setTotal_price(String total_price) {
                this.total_price = total_price;
            }

            public String getActual_price() {
                return actual_price;
            }

            public void setActual_price(String actual_price) {
                this.actual_price = actual_price;
            }

            public int getIs_inventory() {
                return is_inventory;
            }

            public void setIs_inventory(int is_inventory) {
                this.is_inventory = is_inventory;
            }

            public int getUnit() {
                return unit;
            }

            public void setUnit(int unit) {
                this.unit = unit;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getItem_name() {
                return item_name;
            }

            public void setItem_name(String item_name) {
                this.item_name = item_name;
            }
        }
    }

//    public static class ShippingOrder {
//        @Expose
//        @SerializedName("name")
//        private String name;
//        @Expose
//        @SerializedName("address")
//        private String address;
//        @Expose
//        @SerializedName("latitude")
//        private String latitude;
//        @Expose
//        @SerializedName("longitude")
//        private String longitude;
//        @Expose
//        @SerializedName("datetime")
//        private String datetime;
//
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//
//        public void setAddress(String address) {
//            this.address = address;
//        }
//
//        public String getLatitude() {
//            return latitude;
//        }
//
//        public void setLatitude(String latitude) {
//            this.latitude = latitude;
//        }
//
//        public String getLongitude() {
//            return longitude;
//        }
//
//        public void setLongitude(String longitude) {
//            this.longitude = longitude;
//        }
//
//        public String getDatetime() {
//            return datetime;
//        }
//
//        public void setDatetime(String datetime) {
//            this.datetime = datetime;
//        }
//    }
}
