package service;

import repository.CentralRepository;

import constructors.Central;

public class CentralService {
    CentralRepository cr;
    public CentralService () { cr = new CentralRepository(); }
    public static void up(){
        CentralService up = new CentralService();
        up.upTemperature();
    }
    public static void down(){
        CentralService down =new CentralService();
        down.downTemperature();
    }
    public static String temperatureSet(){
        CentralService temperatureSet = new CentralService();
        String temperature = (temperatureSet.readTemperature()) +" °C";
        return temperature;
    }

    public void upTemperature() {
        Central central = cr.findById(2);
        float change = (float) (central.getTemperature() + ((float) 1 / 2.0));
        central.setTemperature(change);
        cr.updateCentral(central);
    }
    public void downTemperature() {
        Central central = cr.findById(2);
        float change = (float) (central.getTemperature() - ((float) 1 / 2.0));
        central.setTemperature(change);
        cr.updateCentral(central);
    }
    public void setPowerCentral()  {
        Central central = cr.findById(2);
        if(central.isPower() == true) {
            central.setPower(false);
        } else if (central.isPower() == false) {
            central.setPower(true);
        }
        cr.updateCentral(central);
    }

    public float readTemperature() {
        Central central = cr.findById(2);
        return central.getTemperature();
    }

}
