package com.codelabs.konspirasisnack.EventBus;

import com.codelabs.konspirasisnack.model.GetOrderListDate;

public class DetailPesanan {
    private GetOrderListDate.DATA date;
    private int position;

    public DetailPesanan(GetOrderListDate.DATA date, int position) {

        this.date = date;
        this.position = position;
    }

    public GetOrderListDate.DATA getDate() {
        return date;
    }

    public void setDate(GetOrderListDate.DATA date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
