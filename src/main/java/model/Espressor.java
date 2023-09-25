package model;

public class Espressor {

    private long idEspressor;
    private long shotCoffe;
    private long shotWater;
    private long shotMilk;
    private long sugar;

    public Espressor(long idEspressor, long MaxCoffe, long MaxWater, long MaxMilk, long MaxSugar){
        this.idEspressor =1;
        this.shotCoffe =MaxCoffe;
        this.shotWater =MaxWater;
        this.shotMilk =MaxMilk;
        this.sugar=MaxSugar;
    }
    public long getSugar(){return sugar;}
    public void setSugar(long sugar){this.sugar = sugar;}

    public long getShotCoffe() {return shotCoffe;}

    public void setShotCoffe(long shotCoffe) {this.shotCoffe = shotCoffe;}

    public long getShotWater() {return shotWater;}

    public void setShotWater(long shotWater) {this.shotWater = shotWater;}

    public long getShotMilk() {return shotMilk;}

    public void setShotMilk(long shotMilk) {this.shotMilk = shotMilk;}

}
