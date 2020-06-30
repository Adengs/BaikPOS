package com.codelabs.konspirasisnack.EventBus;

public class BarcodeScanner {
    private boolean isStart;

    public BarcodeScanner(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean isStart() {
        return isStart;
    }
}
