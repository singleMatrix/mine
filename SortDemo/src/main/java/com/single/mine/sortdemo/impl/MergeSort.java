package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

import java.util.Arrays;

/**
 * @author single
 * @date 2018/1/10.
 */
public class MergeSort implements ISort {


    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        int[] result = Arrays.copyOf(source, source.length);

        this.mergeSort2(source, result, 0, source.length - 1);
        return result;
    }

    public void mergeSort2(int[] source, int[] result, int s, int e) {
        int time = 1;

        while (time < source.length) {
            COMPARE_COUNT++;

            int gap = 2 * time;
            int i = 0;

            while (COMPARE_COUNT ++ >0 && i + gap - 1 < source.length) {
                COMPARE_COUNT++;
                merge(source, result, i, i + time - 1, i + gap - 1);
                i += gap;
            }

            int left = source.length % gap;
            if (left > time) {
                merge(source, result, i, i + time - 1, source.length - 1);
            }
            time += time;
        }
    }

    public void mergeSort(int[] source, int[] result, int s, int e) {
        if (s == e) {
            return;
        }

        int middle = (s + e) / 2;

        mergeSort(source, result, s, middle);
        mergeSort(source, result, middle + 1, e);
        merge(source, result, s, middle, e);
    }

    public void merge(int[] source, int[] result, int s, int m, int e) {
        int i = s;
        int j = m + 1;
        int ri = s;

        while (i <= m && j <= e) {
            COMPARE_COUNT += 2;
            COMPARE_COUNT++;
            EXCHANGE_COUNT++;
            if (source[i] > source[j]) {
                result[ri++] = source[i++];
            } else {
                result[ri++] = source[j++];
            }
        }

        while (i <= m) {
            EXCHANGE_COUNT++;
            COMPARE_COUNT++;
            result[ri++] = source[i++];
        }

        while (j <= e) {
            COMPARE_COUNT++;
            EXCHANGE_COUNT++;
            result[ri++] = source[j++];
        }

        int tag = s;
        while (tag <= e) {
            EXCHANGE_COUNT++;
            source[tag] = result[tag];
            tag++;
        }
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
