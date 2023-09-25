package service;

import model.Elevator;
import repository.ElevatorRepository;

public class ElevatorService {
    ElevatorRepository er;
    public ElevatorService() { er = new ElevatorRepository();}

    public void choiceFloor(int floor) {
        Elevator e = er.findALL();
        e.setFloor(floor);
        er.updateElevator(e);
    }
    public void call (int floor) {
        Elevator e = er.findALL();
        if (e.isUsed()) {
            System.out.println("Elevator is in use. Will not come.");
            return;
        }
        e.setDoors(false);
        e.setFloor(floor);
        e.setDoors(true);
        er.updateElevator(e);
    }

    public void goTo (int floor) {
        Elevator e = er.findALL();
        e.setUsed(true);
        countDownTimer(floor*4);
        e.setDoors(false);
        e.setDoors(true);
        e.setUsed(false);
    }

    public void countDownTimer(int seconds) {
        for (int i = seconds; i >= 0; i--) {
            int mins = i / 60;
            int secs = i % 60;

            System.out.print(String.format("%02d:%02d", mins, secs) + "\r");

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nTime's up!");
    }
}
