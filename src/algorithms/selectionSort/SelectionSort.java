package algorithms.selectionSort;

/*
Time Complexity: The time complexity of Selection Sort is O(N2) as there are two nested loops:

One loop to select an element of Array one by one = O(N)
Another loop to compare that element with every other Array element = O(N)
Therefore overall complexity = O(N)*O(N) = O(N*N) = O(N2)

Auxiliary Space: O(1) as the only extra memory used is for temporary variable while swapping two values in Array.
The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 10, 8, 7};

        selectionSort(arr);

        for (int value : arr) System.out.println(value);
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i == minIndex) continue;
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
