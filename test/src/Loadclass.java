import com.sun.org.apache.bcel.internal.generic.LoadClass;

/**
 * Created by single on 17/3/7.
 */
public class Loadclass {
    static {
        System.out.println("load class");
    }

    Loadclass() {
        System.out.println("execute construct");
    }

    public void go(){
        System.out.println("go method");
    }
}
