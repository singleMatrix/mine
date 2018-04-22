package behavior.command;

/**
 * Created by single on 17/4/6.
 */
public class CommandOn implements Command{

    private TV myTV;

    CommandOn(TV tv){
        this.myTV = tv;
    }

    @Override
    public void execute() {
        myTV.turnOn();
    }
}
