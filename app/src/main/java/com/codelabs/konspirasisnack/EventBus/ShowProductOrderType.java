package com.codelabs.konspirasisnack.EventBus;

public class ShowProductOrderType {
    private boolean productOrderType;

    public ShowProductOrderType(boolean productOrderType) {
        this.productOrderType = productOrderType;
    }

    public boolean productOrderType() {
        return productOrderType;
    }

    public void setProductOrderType(boolean productOrder) {
        productOrderType = productOrder;
    }
}
