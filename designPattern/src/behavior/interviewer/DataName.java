package behavior.interviewer;

/**
 * @author single
 * @date 2018/3/30.
 */
public class DataName implements Data {

    @Override
    public void queryWB(UserWB user) {
        System.out.println("query wbname from" + user.getRedisKey());
    }

    @Override
    public void queryGJ(UserGj user) {
        System.out.println("query gjname from" + user.getRedisKey());
    }
}
