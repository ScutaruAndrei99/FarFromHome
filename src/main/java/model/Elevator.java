package model;

public class Elevator {
    private int idElevator=7;
    private int floor;
    private boolean doors;
    private boolean used;

    public Elevator (int idElevator, int floor, boolean doors, boolean used) {
        this.idElevator=idElevator;
        this.floor=floor;
        this.doors=doors;
        this.used=used;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isDoors() {
        return doors;
    }

    public void setDoors(boolean doors) {
        this.doors = doors;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
