package com.codelabs.konspirasisnack.EventBus;

public class ShowTambahAlamat {
    private boolean isShowing;

    public ShowTambahAlamat(boolean isShowing) {
        this.isShowing = isShowing;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }
}
