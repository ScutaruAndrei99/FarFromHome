package service;

import repository.CentralRepository;

import model.Central;

public class CentralService {
    CentralRepository cr;
    public CentralService () { cr = new CentralRepository(); }

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

    public String readTemperature() {
        Central central = cr.findById(2);
        String temperature = central.getTemperature() +" °C";
        return temperature;
    }

}
