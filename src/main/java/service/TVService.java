package service;

import constructors.Television;
import repository.TVRepository;

import java.util.List;

public class TVService {
    private final TVRepository tr;

    public TVService() { tr = new TVRepository();}

    public List<String> TVChannelShow(){
        List<String> TVChannel = tr.TVlist();
        return TVChannel;
    }

    public String Channel() {
        String channel = tr.Channel();
        return channel;
    }
    public void SelectedChannel(String SelectedOption){
        Television tv= tr.TVStatus();
        tv.setChannelPost(tr.WhatChannelPostIs(SelectedOption));
        tv.setChannelName(SelectedOption);
        tr.UpdateTV(tv);
    }

    public void PressButtonPower(){
        Television tv = tr.TVStatus();
        if (tv.isPower()==true) {
            tv.setPower(false);
            tr.UpdateTV(tv);
        } else {
            tv.setPower(true);
            tr.UpdateTV(tv);
        }
    }
    public boolean PowerStatus(){
        Television tv = tr.TVStatus();
        return tv.isPower();

    }
}
