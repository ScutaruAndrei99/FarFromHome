package constructors;

public class Central {

    private int idCentral;
    private float temperature;
    private boolean power;


    public Central(int idCentral, float maxTemperature, boolean isPower){
        this.idCentral=2;
        this.temperature=maxTemperature;
        this.power=isPower;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
}
