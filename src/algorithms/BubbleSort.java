package algorithms;

/*

Time Complexity
Best	O(n)
Worst	O(n2)
Average	O(n2)
Space Complexity	O(1)
Stability	Yes

For sorting values in ascending order, the larger values are bubbleled to the right
leaving the smaller values on the left. Resulting in elements being sorted from
smallest to greatest.
 */

public class BubbleSort {

    public static void main(String[] args) {

        int[] sorted = bubbleSort(new int[]{20,2, 1, 10,9});

        for (int i : sorted) System.out.println(i);
    }

    public static int[] bubbleSort(int[] arr) {
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
