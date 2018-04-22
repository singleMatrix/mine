package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;

/**
 * @author single
 * @date 2018/1/4.
 */
public class BinaryInsertSort implements ISort {
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int currentIndex = i + 1;
            int changeIndex = searchIndex(source, 0, i, currentIndex);
            if (source[changeIndex] > source[currentIndex]) {
                changeIndex++;
            }
            insert(source, changeIndex, currentIndex);
        }
        return source;
    }

    private int searchIndex(int[] source, int startIndex, int endIndex, int key) {
        int middle = (startIndex + endIndex) / 2;
        COMPARE_COUNT++;
        if (endIndex <= startIndex) {
            return startIndex;
        } else if (source[key] < source[middle]) {
            return searchIndex(source, middle + 1, endIndex, key);
        } else if (source[key] > source[middle]) {
            return searchIndex(source, startIndex, middle - 1, key);
        } else {
            return middle;
        }
    }

    private void insert(int[] source, int destination, int from) {
        int temp = source[from];
        for (int i = from - 1; i >= destination; i--) {
            EXCHANGE_COUNT++;
            source[i + 1] = source[i];
        }
        source[destination] = temp;
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
