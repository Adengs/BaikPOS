package com.codelabs.konspirasisnack.EventBus;

import com.codelabs.konspirasisnack.model.GetOrderDetail;

public class OrderDetailBus {
    private GetOrderDetail.DATA.TransactionItems order;

    public OrderDetailBus(GetOrderDetail.DATA.TransactionItems order) {
        this.order = order;
    }

    public GetOrderDetail.DATA.TransactionItems getOrder() {
        return order;
    }
}
