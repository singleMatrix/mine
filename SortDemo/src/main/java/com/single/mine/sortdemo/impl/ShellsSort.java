package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

/**
 * @author single
 * @date 2018/1/4.
 */
public class ShellsSort implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        for (int d = 300; d >= 1; d--) {
            gaploop(source, d);
        }
        return source;
    }

    private void gaploop(int[] source, int gap) {
        for (int i = 0; i < gap; i++) {
            exchange(source, i, gap);
        }
    }

    private void exchange(int[] source, int start, int gap) {
        int current = start + gap;
        while (current < source.length) {
            int temp = current;
            while (temp - gap >= 0) {
                COMPARE_COUNT++;
                if (source[temp] > source[temp - gap]) {
                    EXCHANGE_COUNT++;
                    SortUtils.exchange(source, temp, temp - gap);
                } else {
                    break;
                }
                temp = temp - gap;
            }
            current = current + gap;
        }
    }


    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
