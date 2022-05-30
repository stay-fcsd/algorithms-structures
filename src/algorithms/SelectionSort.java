package algorithms;

/*
Running time: O(n)^2
Space: O(1)

The algorithm works by maintaining two sub-arrays - a sorted and an unsorted sub-array.
After each completion of the inner loop, the smallest element of the unsorted sub-array is
added to the sorted sub-array.
 */

public class SelectionSort {
    public static void main(String[] args) {

        int[] sorted = selectionSort(new int[]{10, 3, 2, 1, 33});

        for (int i : sorted) System.out.println(i);
    }

    public static int[] selectionSort(int[] arr) {
        int min_index = -1;
        int temp = -1;

        for (int i = 0; i < arr.length; i++) {
            min_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) min_index = j;
            }

            if (min_index != i) {
                temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        return arr;
    }
}
