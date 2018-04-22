package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

import java.util.Arrays;

/**
 * 选择排序,不稳定
 *
 * @author single
 * @date 2018/1/5.
 */
public class QuickSort implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        recursion(source, 0, source.length - 1);
        return source;
    }

    private void recursion(int[] source, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int start = startIndex;
        int end = endIndex;
        while (start < end) {
            COMPARE_COUNT ++;
            while (end > start) {
                COMPARE_COUNT ++;
                if (source[end] > source[start]) {
                    COMPARE_COUNT ++;
                    EXCHANGE_COUNT ++;
                    SortUtils.exchange(source, end, start);
                    start++;
                    break;
                }
                end--;
            }

            while (start < end) {
                COMPARE_COUNT ++;
                COMPARE_COUNT ++;
                if (source[start] < source[end]) {
                    EXCHANGE_COUNT ++;
                    SortUtils.exchange(source, start, end);
                    end--;
                    break;
                }
                start++;
            }
        }
        recursion(source, startIndex, start - 1);
        recursion(source, start + 1, endIndex);
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
