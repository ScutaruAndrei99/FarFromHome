package constructors;

public class Gate {
    private boolean open;
    private int idGate;
    private boolean status;
    public Gate(int idGate, boolean open, boolean status){
        this.idGate = idGate;
        this.open = open;
        this.status= status;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
