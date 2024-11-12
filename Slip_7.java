interface Command {
    void execute();
    void undo();
}

class CeilingFan {
    void high() { System.out.println("Ceiling Fan is on High."); }
    void off() { System.out.println("Ceiling Fan is Off."); }
}

class CeilingFanHighCommand implements Command {
    private final CeilingFan fan;
    CeilingFanHighCommand(CeilingFan fan) { this.fan = fan; }
    public void execute() { fan.high(); }
    public void undo() { fan.off(); }
}

class RemoteControl {
    private Command command;
    void setCommand(Command command) { this.command = command; }
    void pressButton() { command.execute(); }
    void pressUndo() { command.undo(); }
}

public class Slip_7 {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        RemoteControl remote = new RemoteControl();
        
        remote.setCommand(new CeilingFanHighCommand(fan));
        remote.pressButton();  
        remote.pressUndo();   
    }
}
