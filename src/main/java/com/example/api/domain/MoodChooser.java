package com.example.api.domain;

import com.example.api.remoteservices.RemoteServices;

public class MoodChooser {

    RemoteServices remoteServices = new RemoteServices();

    public boolean getMood(String currency) throws NoSuchFieldException, IllegalAccessException {

        float rate = remoteServices.getRate(currency);
        if (rate > 1) {
            return true;
        }
        return false;
    }
}
