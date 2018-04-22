package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author single
 * @date 2018/1/10.
 */
public class UglyNumber {
    public static List<Integer> GetUglyNumber_Solution1(int index) {
        List<Integer> uglyNums = new ArrayList<>();

        int current = 1;

        while (uglyNums.size() <= index) {
            int number = current;
            while ((number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0)) {
                while (number % 2 == 0) {
                    number = number / 2;
                }

                while (number % 3 == 0) {
                    number = number / 3;
                }

                while (number % 5 == 0) {
                    number = number / 5;
                }
            }
            if (number == 1) {
                uglyNums.add(current);
            }
            current++;
        }
        return uglyNums;
    }

    public static List<Integer> GetUglyNumber_Solution2(int index) {
        List<Integer> result = new ArrayList<>();
        if (index <= 0) {
            return result;
        }

        result.add(1);
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;

        while (result.size() <= index) {
            int min = min(result.get(pMultiply2) * 2, result.get(pMultiply3) * 3, result.get(pMultiply5) * 5);
            if (result.get(pMultiply2) * 2 == min) {
                pMultiply2++;
            }
            if (result.get(pMultiply3) * 3 == min) {
                pMultiply3++;
            }
            if (result.get(pMultiply5) * 5 == min) {
                pMultiply5++;
            }
            result.add(min);
        }
        return result;
    }

    public static int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }

    public static void main(String[] args) {
        Long begin = System.currentTimeMillis();
        List<Integer> uglyUnmbers = UglyNumber.GetUglyNumber_Solution1(1500);
        System.out.println("cost time:" + (System.currentTimeMillis() - begin) + "ms");
        System.out.println(uglyUnmbers.get(uglyUnmbers.size() - 1));
    }
}
