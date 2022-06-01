package algorithms.insertionSort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 10, 8, 7};

        insertionSort(arr);

        for (int value : arr) System.out.println(value);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                --j;
            }
        }
    }
}
