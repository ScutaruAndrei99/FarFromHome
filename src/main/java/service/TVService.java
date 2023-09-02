package service;

import repository.TVRepository;

import java.util.List;

public class TVService {
    private final TVRepository tr;

    public TVService() { tr = new TVRepository();}

    public List<String> TVChannelShow(){
        List<String> TVChannel = tr.TVlist();

        return TVChannel;
    }
    public static List<String> TVChannelPrint(){
        TVService show =new TVService();
        List<String> TVChannelPrint =show.TVChannelShow();
        return TVChannelPrint;
    }
    public String Channel1() {
        String channel = tr.Channel();
        return channel;
    }
    public static String Channel(){
        TVService show = new TVService();
        String channel=show.Channel1();
        return channel;
    }
//    public String ChannelSelected(String SelectedOption){
//
//    }
}
