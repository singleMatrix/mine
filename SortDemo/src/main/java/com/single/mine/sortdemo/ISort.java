package com.single.mine.sortdemo;

/**
 * @author single
 * @date 2018/1/3.
 */
public interface ISort {
    int[] sort(int[] source);

    long getCompareCount();

    long getExchangeCount();
}
