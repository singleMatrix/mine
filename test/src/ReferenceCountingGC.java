public class ReferenceCountingGC {
    public Object instance = null;
    private final int ONE_MB = 1024 * 1024;
    private byte[] bigSize = new byte[1 * ONE_MB]; //只为了占空间

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        //假设在这行发生GC,objA和objB是否能被回收？
        System.out.println("befor:" + Runtime.getRuntime().freeMemory());
        System.gc();
        System.out.println("after:" + Runtime.getRuntime().freeMemory());  //判断到底释放了多少
    }
}