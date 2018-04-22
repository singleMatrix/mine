package test2;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args) {

		int[] dest = new int[] { 31, 52, 74, 45, 38, 25, 44, 63, 34, 45, 78, 99 };
		int low = 0;
		int high = dest.length;
		for (int i = low; i < high; i++)
			for (int j = i; j > low; j--) {
				if (((Comparable) dest[j - 1]).compareTo(dest[j]) > 0)
					swap(dest, j, j - 1);
				System.out.println(j + "  " + (j - 1));
				System.out.println(Arrays.toString(dest));
			}
	}

	public static void swap(int[] dest, int i, int j) {
		int temp = dest[i];
		dest[i] = dest[j];
		dest[j] = temp;
	}
}
