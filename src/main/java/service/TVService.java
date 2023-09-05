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
    public void ChannelSelected(String SelectedOption){
        tr.WhatChannelPostIs(SelectedOption);
        Television tv= tr.TVStatus();
        tv.setChannelName(SelectedOption);
        tr.updateChannel(tv);
    }
}
