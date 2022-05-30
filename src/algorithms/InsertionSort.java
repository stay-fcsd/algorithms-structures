package algorithms;

/*
Time Complexity
Best	O(n)
Worst	O(n2)
Average	O(n2)
Space Complexity	O(1)
Stability	Yes
 */

public class InsertionSort {
    public static void main(String[] args) {

        int[] sorted = insertionSort(new int[]{1, 10, 39, 33});

        for (int i : sorted) System.out.println(i);
    }

    public static int[] insertionSort(int[] arr) {
        int temp = -1;
        int current = -1;
        for (int i = 1; i < arr.length; i++) {
            current = i;
            while (arr[current] < arr[current - 1] && current >= 0) {
                temp = arr[current - 1];
                arr[current - 1] = arr[current];
                arr[current] = temp;
            }
        }
        return arr;
    }
}
