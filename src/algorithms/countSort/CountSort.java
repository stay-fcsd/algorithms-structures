package algorithms.countSort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 10, 8, 7, -1};

        countSort(arr);

        for (int value : arr) System.out.println(value);
    }

    public static void countSort(int[] arr) {
        // find min and max to establish range of countArr
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        // create an array that will contain the count of each element in the range from min - max
        // eg: min = 1, max = 10. --> 9 + 1
        int[] countArr = new int[max - min + 1];

        // map elements from arr to countArr
        for (int value : arr) countArr[value - min]++;

        int arrIndex = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[arrIndex++] = i + min;
                countArr[i]--;
            }
        }
    }
}
