package service;

import constructors.Gate;
import javafx.scene.image.Image;
import repository.GateRepository;

import java.util.Timer;
import java.util.TimerTask;

public class GateService {
    GateRepository gr= new GateRepository();
    Gate gate=gr.findByID();
    Timer timer = new Timer();

    public Image prepareImage(){
        Image myImg_switch;
        if(gate.isOpen()){
            myImg_switch =new Image(getClass().getResourceAsStream("/images/switch_off.png"));
            gate.setOpen(false);
            gr.update(gate);
        } else {
            myImg_switch =new Image(getClass().getResourceAsStream("/images/switch_on.png"));
            gate.setOpen(true);
            gr.update(gate);
        }
        return myImg_switch;
    }

    public void gateWork() {
        Gate gate = gr.findByID();
        if (gate.isOpen()){
            System.out.println("Poarta este deschisa");
        } else {
            System.out.println("Poarta este inchisa");
        }
    }
    public void timeGate(int seconds) {
        timer.schedule(new RemindTaskGate(),seconds * 1000L);
    }
    class RemindTaskGate extends TimerTask {
        GateRepository gr;
        public void run() {
            gr = new GateRepository();
            Gate gate = null;
            gate = gr.findByID();
            gate.setStatus(false);
            gr.update(gate);
        }
    }
}
