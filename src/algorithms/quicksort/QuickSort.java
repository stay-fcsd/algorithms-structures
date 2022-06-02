package algorithms.quicksort;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 0};

        quickSort(arr, 0, arr.length -1);

        for (int value: arr) System.out.println(value);
    }

    public static void quickSort(int[] arr, int start, int end) {
        // return since there is either one element left which means that it is sorted by default
        // or there is no elements left
        if (start >= end) return;

        int index = partition(arr, start, end);

        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // pick a pivot: in this case the last element will be picked
        int pivot = arr[end];
        /*
            we point to start - 1 because in case there is no element less than the pivot.
            The pivot itself is the smallest element of section(start - end), which means
            that the pivot should be placed in start position
         */
        int maxElemPointer = start - 1;

        /*
            Look for elements smaller than the pivot. Then switch its position with element at maxElemPointer
         */
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                // increment before switching elements since we started 1 less than the range of start - end.
                maxElemPointer++;

                int temp = arr[maxElemPointer];
                arr[maxElemPointer] = arr[j];
                arr[j] = temp;
            }
        }

        /*
            switch position of pivot element with element at maxEmPointer
         */
        int temp = arr[maxElemPointer + 1];
        arr[maxElemPointer + 1] = pivot;
        arr[end] = temp;

        return maxElemPointer + 1;
    }



}
