package service;

import model.Television;
import repository.TVRepository;

import java.util.List;

public class TVService {
    private final TVRepository tr;

    public TVService() { tr = new TVRepository();}

    public List<String> TVChannelShow(){
        List<String> TVChannel = tr.tvList();
        return TVChannel;
    }

    public String Channel() {
        String channel = tr.channel();
        return channel;
    }
    public void SelectedChannel(String SelectedOption){
        Television tv= tr.tvStatus();
        tv.setChannelPost(tr.whatChannelPostIs(SelectedOption));
        tv.setChannelName(SelectedOption);
        tr.updateTV(tv);
    }

    public void PressButtonPower(){
        Television tv = tr.tvStatus();
        if (tv.isPower()==true) {
            tv.setPower(false);
            tr.updateTV(tv);
        } else {
            tv.setPower(true);
            tr.updateTV(tv);
        }
    }
    public boolean PowerStatus(){
        Television tv = tr.tvStatus();
        return tv.isPower();

    }
}
