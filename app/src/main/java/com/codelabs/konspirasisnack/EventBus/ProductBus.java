package com.codelabs.konspirasisnack.EventBus;

import com.codelabs.konspirasisnack.model.GetProductDetail;

public class ProductBus {
    private GetProductDetail.DATAProduct produk;

    public ProductBus(GetProductDetail.DATAProduct produk) {
        this.produk = produk;
    }

    public GetProductDetail.DATAProduct getProduk() {
        return produk;
    }
}
