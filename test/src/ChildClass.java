import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

/**
 * Created by single on 17/2/11.
 */
public class ChildClass extends ParentClass {

    public final String ss;

    ChildClass() {
        super("cc");
        ss = "ssjf";
        System.out.println("Child class initialized");
    }

    @Override
    public void testStaticOverwrite() {
        System.out.println("parent static method");
    }

    public void play(String param) {
        System.out.println("child has param:" + param);
    }

    public static void main(String[] args) {
        /*ChildClass cc = new ChildClass();
        out.println("adf");
        cc.play();*/
        int[] a= {5,7,3,8,2,6,9,2,1};
        ChildClass.sort(a, 0, a.length);
    }

    static void sort(int[] dest, int low, int high){
        for (int i=low; i<high; i++)
            for (int j=i; j>low &&
                    ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--) {
                int a = dest[j-1];
                dest[j-1] = dest[j];
                dest[j] = a;
                System.out.println(Arrays.toString(dest));
            }
        return;
    }
}
