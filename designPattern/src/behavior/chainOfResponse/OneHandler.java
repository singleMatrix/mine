package behavior.chainOfResponse;

/**
 * Created by single on 17/4/6.
 */
public class OneHandler extends Handler {

    OneHandler(int score, Handler handler) {
        this.score = score;
        this.nextHandler = handler;
    }

    @Override
    public void doIt() {
        System.out.println("One Handler do this");
    }
}
