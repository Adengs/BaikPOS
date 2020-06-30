package com.codelabs.konspirasisnack.EventBus;

public class SetDataAlamat {

    private String address, latitude, longitude, datetime;

    public SetDataAlamat(String address,String latitude, String longitude, String datetime) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.datetime = datetime;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
