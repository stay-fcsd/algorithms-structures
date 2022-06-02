package mergeSort;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 2, 10, 8, 7};
        mergeSort(arr);

        for (int value : arr) System.out.println(value);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        // find middle of the array
        int middle = (rightEnd + leftStart) / 2;
        // recursively call method on left side of the array
        mergeSort(arr, temp, leftStart, middle);
        // recursively call method on right side of the array
        mergeSort(arr, temp, middle + 1, rightEnd);
        // merge both sub-lists into one
        merge(arr, temp, leftStart, rightEnd);
    }

    private static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;;
        int rightStart = leftEnd + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int tempIndex = leftStart;

        // place elements from both sub-arrays into temp array until
        // one of the sub-lists is traversed completely
        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex] < arr[rightIndex]) temp[tempIndex++] = arr[leftIndex++];
            else temp[tempIndex++] = arr[rightIndex++];
        }

        // finish passing elements from the list that was not traversed
        // completely to the temp array
        while (leftIndex <= leftEnd) temp[tempIndex++] = arr[leftIndex++];
        while (rightIndex <= rightEnd) temp[tempIndex++] = arr[rightIndex++];

        // pass all elements from temp array to original array
        for (int i = leftStart; i <=  rightEnd; i++) arr[i] = temp[i];
    }
}
