package algorithms.countSort;

import java.util.Arrays;

public class CountSortV2 {

    public static void main(String[] args) {

        int[] arr = {3, 3, 1, 4, 2, 2, 10, 8, 7, -2, 10, -2};

        int[] sorted = countSort(arr);

        for (int value : sorted) System.out.println(value);
    }

    public static int[] countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        // k is the number of unique values
        int k = max - min + 1;

        int[] countArr = new int[k];

        for (int value : arr) countArr[value - min]++;

        /*
            running sum tells us how many elements are less than or equal to me
            eg: let say position 2 has a value of 1. That means that there
            is 1 occurrence of values that are less than or equal to 2 in the
            original array

            The value that is in each of the indices indicates the last position
            that that number can be in the output array
            eg: let say index 4 has a value of 5. That means that the last index
            that value 4 can appear in the output array is position 5 - 1  = 4.
         */
        for (int i = 1; i < countArr.length; i++) countArr[i] += countArr[i-1];

        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // subtract 1 because we need to switch from count form to
            // 0 based
            int outputIndex = countArr[arr[i] - min] - 1;
            output[outputIndex] = arr[i];
            // decrement count of occurrence of element
            countArr[arr[i] - min]--;
        }

        return output;
    }
}
