package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

/**
 * @author single
 * @date 2018/1/4.
 */
public class BubbleSort implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        for (int i = source.length - 1; i > 0; i--) {
            this.doSort(source, i);
        }
        return source;
    }

    private void doSort(int[] source, int endIndex) {
        for (int i = 1; i <= endIndex; i++) {
            COMPARE_COUNT ++;
            if (source[i - 1] < source[i]) {
                EXCHANGE_COUNT ++;
                SortUtils.exchange(source, i - 1, i);
            }
        }
    }


    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
