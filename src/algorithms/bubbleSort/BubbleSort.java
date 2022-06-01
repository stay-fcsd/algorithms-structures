package algorithms.bubbleSort;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 2, 10, 8, 7};
        bubbleSort((arr));

        for (int value : arr) System.out.println(value);

    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
