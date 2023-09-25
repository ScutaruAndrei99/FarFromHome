package service;

import model.Espressor;
import model.PrepareCoffee;
import javafx.scene.control.Alert;
import repository.EspressorRepository;

import java.util.Timer;
import java.util.TimerTask;

public class EspressorService {
    private final EspressorRepository er;
    private volatile boolean isPreparing = false;

    public EspressorService() {
        er = new EspressorRepository();
    }
    public void typeCoffeeSelect(String typeCoffeeSelect) {
        PrepareCoffee prepare = er.findPrepare();
        prepare.setTypeCoffee(typeCoffeeSelect);
        er.updatePrepare(prepare);
    }

    public void prepareCoffee() {
        Espressor espressor = er.findById(1);
        PrepareCoffee prepare =er.findPrepare();
        if(!isPreparing) {
            switch (prepare.getTypeCoffee()) {
                case "espresso":
                    if (espressor.getShotCoffe() != FinalSelection()){
                        espressor.setShotCoffe(FinalSelection());
                        if(espressor.getShotWater() >= 1) {
                            espressor.setShotWater(espressor.getShotWater()-1);
                            if (espressor.getSugar() >= prepare.getSugar()) {
                                espressor.setSugar(espressor.getSugar() - prepare.getSugar());
                                er.update(espressor);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("You need to refill sugar");
                                alert.show();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("You need to refill water tank");
                            alert.show();
                        }
                    }
                    break;
                case "cappuccino":
                    if (espressor.getShotCoffe() != FinalSelection()) {
                        espressor.setShotCoffe(FinalSelection());
                        if (espressor.getShotMilk() >= 1) {
                            espressor.setShotMilk(espressor.getShotMilk() - 1);
                            if (espressor.getSugar() >= prepare.getSugar()) {
                                espressor.setSugar(espressor.getSugar() - prepare.getSugar());
                                er.update(espressor);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("You need to refill sugar");
                                alert.show();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("You need to refill milk tank");
                            alert.show();
                        }
                    }
                    break;
                case "latte":
                    if (espressor.getShotCoffe() != FinalSelection()) {
                        espressor.setShotCoffe(FinalSelection());
                        if (espressor.getShotMilk() >= 2) {
                            espressor.setShotMilk(espressor.getShotMilk() - 2);
                            if (espressor.getSugar() >= prepare.getSugar()) {
                                espressor.setSugar(espressor.getSugar() - prepare.getSugar());
                                er.update(espressor);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("You need to refill sugar");
                                alert.show();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("You need to refill milk tank");
                            alert.show();
                        }
                    }
                    break;
            }
        }
    }
    public void resetPrepareSet() {
        PrepareCoffee prepare = er.findPrepare();
        prepare.setSugar(0);
        prepare.setQuantity(0);
        prepare.setIntensity(0);
        er.updatePrepare(prepare);
    }
    public void findALL() {
        System.out.println(er.findAll());
    }
    public void refill() {
        er.updateRefill();
    }

    public void timeEspressor(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000L);
    }

    public void minusSugar(){
        PrepareCoffee prepare = er.findPrepare();
        if(prepare.getSugar() > 0){
            prepare.setSugar(prepare.getSugar()-1);
            er.updatePrepare(prepare);
        }
    }

    public void plusSugar(){
        PrepareCoffee prepare =er.findPrepare();
        if(prepare.getSugar() < 5){
            prepare.setSugar(prepare.getSugar()+1);
            er.updatePrepare(prepare);
        }
    }

    public String readSugarSet(){
        PrepareCoffee prepare =er.findPrepare();
        return String.valueOf(prepare.getSugar()) ;
    }
    public void minusQuantity(){
        PrepareCoffee prepare = er.findPrepare();
        if(prepare.getQuantity() > 0){
            prepare.setQuantity(prepare.getQuantity()-50);
            er.updatePrepare(prepare);
        }
    }
    public void plusQuantity(){
        PrepareCoffee prepare =er.findPrepare();
        if(prepare.getQuantity() < 200){
            prepare.setQuantity(prepare.getQuantity()+50);
            er.updatePrepare(prepare);
        }
    }
    public String readQuantitySet(){
        PrepareCoffee prepare =er.findPrepare();
        return String.valueOf(prepare.getQuantity()) ;
    }
    public void minusIntensity(){
        PrepareCoffee prepare = er.findPrepare();
        if(prepare.getIntensity() > 0){
            prepare.setIntensity(prepare.getIntensity()-1);
            er.updatePrepare(prepare);
        }
    }
    public void plusIntensity(){
        PrepareCoffee prepare =er.findPrepare();
        if(prepare.getIntensity() < 3){
            prepare.setIntensity(prepare.getIntensity()+1);
            er.updatePrepare(prepare);
        }
    }
    public String readIntensitySet(){
        PrepareCoffee prepare =er.findPrepare();
        return String.valueOf(prepare.getIntensity()) ;
    }
    public Long FinalSelection() {
        PrepareCoffee prepare =er.findPrepare();
        Espressor espressor=er.findById(1);
        switch (prepare.getQuantity()) {
            case 50:
                if(prepare.getIntensity() == 0 && espressor.getShotCoffe() > 0 ) {
                    espressor.setShotCoffe(espressor.getShotCoffe()- 1);
                }else if(prepare.getIntensity() ==0 && espressor.getShotCoffe() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You need to refill coffee");
                    alert.show();
                }
                else {
                     int coffee = prepare.getIntensity();
                     if(espressor.getShotCoffe() >= coffee) {
                         espressor.setShotCoffe(espressor.getShotCoffe() - coffee);
                     } else {
                         Alert alert = new Alert(Alert.AlertType.ERROR);
                         alert.setContentText("You need to refill coffee");
                         alert.show();
                     }
                }
                break;
            case 100:
                if(prepare.getIntensity() ==0 && espressor.getShotCoffe() > 0 ) {
                    espressor.setShotCoffe(espressor.getShotCoffe()- 1);
                } else if(prepare.getIntensity() ==0 && espressor.getShotCoffe() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You need to refill coffee");
                    alert.show();
                }
                else {
                    int coffee =  prepare.getIntensity() * 2;
                    if (espressor.getShotCoffe() >= coffee) {
                        espressor.setShotCoffe(espressor.getShotCoffe() - coffee);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("You need to refill coffee");
                        alert.show();
                    }
                }
                break;
            case 150:
                if(prepare.getIntensity() ==0 && espressor.getShotCoffe() > 0) {
                    espressor.setShotCoffe(espressor.getShotCoffe()- 1);
                } else if(prepare.getIntensity() ==0 && espressor.getShotCoffe() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You need to refill coffee");
                    alert.show();
                }
                else {
                    int coffee =  prepare.getIntensity() * 3;
                    if (espressor.getShotCoffe() >= coffee) {
                        espressor.setShotCoffe(espressor.getShotCoffe() - coffee);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("You need to refill coffee");
                        alert.show();
                    }
                }
                break;
            case 200:
                if(prepare.getIntensity() ==0 && espressor.getShotCoffe() > 0) {
                    espressor.setShotCoffe(espressor.getShotCoffe()- 1);
                } else if(prepare.getIntensity() ==0 && espressor.getShotCoffe() <= 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("You need to refill coffee");
                    alert.show();
                }
                else {
                    int coffee = prepare.getIntensity() * 4;
                    if (espressor.getShotCoffe() >= coffee) {
                        espressor.setShotCoffe(espressor.getShotCoffe() - coffee);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("You need to refill coffee");
                        alert.show();
                    }
                }
                break;
        }
        return espressor.getShotCoffe();
    }


    class RemindTask extends TimerTask {

        @Override
        public void run() {
            isPreparing = false;
            System.out.println("Aparatul a devenit disponibil");
        }
    }
}
