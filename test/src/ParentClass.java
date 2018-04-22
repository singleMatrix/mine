/**
 * Created by single on 17/2/11.
 */
public class ParentClass {
    ParentClass(String ss){
        System.out.println(ss + " Parent class initialized");
    }

    public  void testStaticOverwrite(){
        System.out.println("parent static method");
    }

    public void play(){
        System.out.println("parent no param");
    }

    public void play(String param){
        System.out.println("parent has param:" + param);
    }
}
