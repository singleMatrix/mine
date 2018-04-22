package behavior.command;

/**
 * Created by single on 17/4/6.
 */
public class CommandOff implements Command{

    private TV myTV;

    CommandOff(TV tv){
        this.myTV = tv;
    }

    @Override
    public void execute() {
        myTV.turnOff();
    }
}
