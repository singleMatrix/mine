package behavior.chainOfResponse;

/**
 * Created by single on 17/4/6.
 */
public abstract class Handler {
    protected Handler nextHandler;

    protected int score;

    public abstract void doIt();

    public void doHandler(int num){
        if (num == score) {
            doIt();
        } else {
            if(this.getNextHandler() != null){
                this.getNextHandler().doHandler(num);
            }else{
                System.out.println("Your request has been rejected");
            }
        }
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
