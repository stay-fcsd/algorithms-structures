package algorithms.heapSort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 10, 8, 7};
        heapSort(arr);
        for (int value : arr) System.out.println(value);
    }

    public static void heapSort(int[] arr) {

        // build max heap using heapify
        for (int i = arr.length / 2 - 1; i >= 0; i--) sink(arr, i, arr.length);

        // sort the array
        for (int i = arr.length -1; i >=  0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sink(arr, 0, i);
        }

    }

    private static void sink(int[] arr, int i, int n) {

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // default set left to largest
            int largest = left;

            // check which child is largest
            if (right < n && arr[right] > arr[left]) largest = right;

            // stopping condition
            if (left >= n || arr[i] > arr[largest]) break;

            // swap parent with largest child in case it is larger than parent
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            i = largest;

        }
    }
}
