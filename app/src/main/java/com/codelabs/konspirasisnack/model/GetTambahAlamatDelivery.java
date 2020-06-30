package com.codelabs.konspirasisnack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTambahAlamatDelivery {
    @Expose
    @SerializedName("shipping")
    private DATAShipping dataShipping;

    public DATAShipping getDataShipping() {
        return dataShipping;
    }

    public void setDataShipping(DATAShipping dataShipping) {
        this.dataShipping = dataShipping;
    }


    public static class DATAShipping{
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("address")
        private String address;
        @Expose
        @SerializedName("latitude")
        private String latitude;
        @Expose
        @SerializedName("longitude")
        private String longitude;
        @Expose
        @SerializedName("datetime")
        private String datetime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }
}
