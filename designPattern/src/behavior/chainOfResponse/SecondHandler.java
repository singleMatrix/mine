package behavior.chainOfResponse;

/**
 * Created by single on 17/4/6.
 */
public class SecondHandler extends Handler {

    SecondHandler(int score, Handler handler){
        this.score = score;
        this.nextHandler = handler;
    }
    @Override
    public void doIt() {
        System.out.println("Second Handler do this");
    }
}
