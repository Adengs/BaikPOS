package com.codelabs.konspirasisnack.EventBus;

import org.greenrobot.eventbus.EventBus;

public class ShowMeja {
    private boolean isShowing;

    public ShowMeja(boolean isShowing) {
        this.isShowing = isShowing;
        EventBus.getDefault().post(new ShowSearchKasir(!isShowing));
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }
}
