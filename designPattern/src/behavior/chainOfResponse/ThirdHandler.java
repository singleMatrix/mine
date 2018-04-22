package behavior.chainOfResponse;

/**
 * Created by single on 17/4/6.
 */
public class ThirdHandler extends Handler {

    ThirdHandler(int score, Handler handler){
        this.score = score;
        this.nextHandler = handler;
    }

    @Override
    public void doIt() {
        System.out.println("Third Handler do this");
    }
}
