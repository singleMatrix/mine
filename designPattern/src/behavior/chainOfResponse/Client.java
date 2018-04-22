package behavior.chainOfResponse;

/**
 * Created by single on 17/4/6.
 */
public class Client {
    public static void main(String[] args){
        ThirdHandler thirdHandler = new ThirdHandler(3, null);
        SecondHandler secondHandler = new SecondHandler(2, thirdHandler);
        OneHandler oneHandler = new OneHandler(1, secondHandler);

        oneHandler.doHandler(2);
        oneHandler.doHandler(1);
        oneHandler.doHandler(3);
        oneHandler.doHandler(4);
    }
}
