package javanet;

import java.util.Map;

/**
 * Created by single on 17/3/7.
 */
public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("i'm a loader");
        String path = "";
        return super.findClass(name);
    }

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        try {
            Class clazz = Class.forName("Testdd", true, loader);
            System.out.println(clazz);
            clazz.getClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
