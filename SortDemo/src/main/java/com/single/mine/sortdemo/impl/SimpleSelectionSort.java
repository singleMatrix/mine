package com.single.mine.sortdemo.impl;

import com.single.mine.sortdemo.ISort;
import com.single.mine.sortdemo.utils.SortUtils;

/**
 * 选择排序,不稳定
 * @author single
 * @date 2018/1/5.
 */
public class SimpleSelectionSort implements ISort{
    public static long COMPARE_COUNT = 0;
    public static long EXCHANGE_COUNT = 0;

    public int[] sort(int[] source) {
        for(int i = 0; i < source.length; i ++){
            int targetIndex = findIndex(source, i);
            EXCHANGE_COUNT ++;
            SortUtils.exchange(source, i, targetIndex);
        }
        return source;
    }

    private int findIndex(int[] source, int start){
        int result = start;
        for(int i = start + 1; i< source.length; i ++){
            COMPARE_COUNT ++;
            if(source[i] > source[result]){
                result = i;
            }
        }
        return result;
    }

    public long getCompareCount() {
        return COMPARE_COUNT;
    }

    public long getExchangeCount() {
        return EXCHANGE_COUNT;
    }
}
