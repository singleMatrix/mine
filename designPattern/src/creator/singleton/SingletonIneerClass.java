package creator.singleton;

/**
 * @author single
 * @date 2018/4/5.
 */
public class SingletonIneerClass {
    //利用内部类的延迟加载来获得延迟效果,利用类的clinit方法获得单线程效果
    private static class Inner {
        private static SingletonIneerClass instance = new SingletonIneerClass();
    }

    private SingletonIneerClass() {

    }

    public SingletonIneerClass getInstance() {
        return Inner.instance;
    }
}
