package behavior.command;

/**
 * Created by single on 17/4/6.
 */
public class Controller {
    private Command commandOn, commandOff ;

    public Controller(Command commandOn, Command commandOff){
        this.commandOn = commandOn;
        this.commandOff = commandOff;
    }

    public void turnOn(){
        commandOn.execute();
    }

    public void turnOff(){
        commandOff.execute();
    }
}
