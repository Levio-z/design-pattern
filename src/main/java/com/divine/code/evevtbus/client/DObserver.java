package com.divine.code.evevtbus.client;

import com.divine.code.evevtbus.framework.Subscribe;

public class DObserver {
    @Subscribe
    public void handlePMsg(PMsg event) {
        System.out.println("Received PMsg: " + event.getContent());
    }

    @Subscribe
    public void handleQMsg(QMsg event) {
        System.out.println("Received QMsg: " + event.getCode());
    }
}

