package algorithms;

public class MergeSort {

    public static void main(String[] args) {
        int[] sorted = mergeSort(new int[]{1, 22, 2, 3, 10, 4, 8, 9});

        for (int i : sorted) System.out.println(i);
    }

    public static int[] mergeSort(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length -1);
    }

    private static int[] mergeSort(int[] arr, int[] temp, int left, int right) {

//      base condition: while left is less than right, there is at least two elements. Else there is only one element that is sorted by default.
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, temp, left, middle);
            mergeSort(arr, temp, middle + 1, right);
            merge(arr, temp, left, right);
        }
        return arr;
    }

    private static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int tempIndex = leftStart;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex] < arr[rightIndex]) {
                temp[tempIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[tempIndex] = arr[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }

        while (leftIndex <= leftEnd) {
            temp[tempIndex] = arr[leftIndex];
            leftIndex++;
            tempIndex++;
        }

        while (rightIndex <= rightEnd) {
            temp[tempIndex] = arr[rightIndex];
            rightIndex++;
            tempIndex++;
        }

        tempIndex = leftStart;

        while (tempIndex <= rightEnd) {
            arr[tempIndex] = temp[tempIndex];
            tempIndex++;
        }
    }



}
