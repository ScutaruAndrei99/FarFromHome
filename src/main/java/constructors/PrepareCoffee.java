package constructors;

public class PrepareCoffee {
    private int sugar;
    private int quantity;
    private int intensity;
    private String typeCoffee;
    public PrepareCoffee(int sugarSet, int quantitySet, int intensitySet, String typeCoffee) {
        this.sugar = sugarSet;
        this.quantity = quantitySet;
        this.intensity = intensitySet;
        this.typeCoffee = typeCoffee;
    }
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity=quantity;}
    public int getIntensity() {return intensity;}
    public void setIntensity(int intensity) {this.intensity=intensity;}
    public int getSugar() {return sugar;}
    public void setSugar(int sugar) {this.sugar=sugar;}
    public String getTypeCoffee(){return typeCoffee;}
    public void setTypeCoffee(String typeCoffee){this.typeCoffee = typeCoffee;}
}
