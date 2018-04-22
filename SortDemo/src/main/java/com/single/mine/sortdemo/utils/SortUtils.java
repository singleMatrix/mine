package com.single.mine.sortdemo.utils;

/**
 * @author single
 * @date 2018/1/4.
 */
public class SortUtils {
    public static void exchange(int[] source, int first, int second) {
        int temp = source[first];
        source[first] = source[second];
        source[second] = temp;
    }

    public static <T> void exchangeAny(T target, T dest) {
        T temp = target;
        target = dest;
        dest = temp;
    }

    public static void printArray(String prefix, int[] source) {
        System.out.print(prefix + " [");
        for (int i = 0; i < source.length; i++) {
            if (i == source.length - 1) {
                System.out.print(source[i]);
            } else {
                System.out.print(source[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
