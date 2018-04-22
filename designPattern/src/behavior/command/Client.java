package behavior.command;

/**
 * Created by single on 17/4/6.
 */
public class Client {
    public static void main(String[] args){
        TV tv = new TV();
        Command commandOn = new CommandOn(tv);
        Command commandOff = new CommandOff(tv);
        Controller controller = new Controller(commandOn, commandOff);
        controller.turnOff();
        controller.turnOn();
    }
}
