package com.codelabs.konspirasisnack.EventBus;

public class ShowSearchKasir {
    private boolean isShowing;

    public ShowSearchKasir(boolean isShowing) {
        this.isShowing = isShowing;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }
}
