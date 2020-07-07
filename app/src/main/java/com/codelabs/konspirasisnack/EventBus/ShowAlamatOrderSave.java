package com.codelabs.konspirasisnack.EventBus;

public class ShowAlamatOrderSave {
    private boolean isShowing;

    public ShowAlamatOrderSave(boolean isShowing) {
        this.isShowing = isShowing;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }
}
