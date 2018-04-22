package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

/**
 * 堆排序的时间复杂度为O(nlogn)
 * @author single
 * @date 2018/1/3.
 */
public class HeapSort implements ISort {

    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    @Override
    public int[] sort(int[] source) {
        //自下而上,自右向左的遍历非叶子节点
        for (int i = source.length / 2; i >= 0; i--) {
            initTree(source, i, source.length);
        }

        for (int i = source.length - 1; i > 0; i--) {
            SortUtils.exchange(source, i, 0);
            EXCHANGE_COUNT ++;

            initTree(source, 0, i);
        }
        return source;
    }

    private void initTree(int[] source, int parent, int length) {
        int temp = source[parent];
        int child = 2 * parent + 1;

        while (child < length) {
            COMPARE_COUNT ++;
            if (child + 1 < length && source[child] < source[child + 1]) {
                child++;
            }
            COMPARE_COUNT ++;
            if (temp >= source[child]) {
                break;
            }
            EXCHANGE_COUNT ++;
            source[parent] = source[child];

            parent = child;
            child = child * 2 + 1;
        }

        source[parent] = temp;
    }

    @Override
    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    @Override
    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
