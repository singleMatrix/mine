package behavior.interviewer;

/**
 * @author single
 * @date 2018/3/30.
 */
public class DataAge implements Data {

    @Override
    public void queryWB(UserWB user) {
        System.out.println("query wb age from" + user.getRedisKey());
    }

    @Override
    public void queryGJ(UserGj user) {
        System.out.println("query gj age from" + user.getRedisKey());
    }
}
