package behavior.interviewer;

/**
 * @author single
 * @date 2018/3/30.
 */
public class Struct {
    public void wrapData(){
        UserGj user = new UserGj();
        DataAge da = new DataAge();
        DataName dn = new DataName();
        da.queryGJ(user);
        dn.queryGJ(user);
    }
}
